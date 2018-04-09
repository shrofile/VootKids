package com.tv.vootkids.injection.module;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tv.vootkids.config.AppConfig;
import com.tv.vootkids.config.Config;
import com.tv.vootkids.data.remote.ApiService;
import com.tv.vootkids.data.remote.LoggingInterceptor;
import com.tv.vootkids.injection.scope.ApplicationScope;
import com.tv.vootkids.ui.base.rxbus.RxBus;
import com.tv.vootkids.utils.Logger;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = RxBusModule.class)
public class NetworkModule {

    private static final String TAG = NetworkModule.class.getSimpleName();
    private final String mBaseUrl;
    private Context mContext;

    public NetworkModule(Context context, String baseUrl) {
        this.mBaseUrl = baseUrl;
        this.mContext = context;
    }

    @Provides
    @ApplicationScope
    Gson provideGson() {

        return new GsonBuilder()
                .setLenient()
                .create();
    }

    @Provides
    @ApplicationScope
    OkHttpClient provideOkHttpClient(final RxBus rxBus) {
        try {
            OkHttpClient.Builder client = new OkHttpClient.Builder();
            if (AppConfig.DEBUG) {
                client.addNetworkInterceptor(new LoggingInterceptor());
            }

            if (Config.DISABLE_SSL_VERIFICATION) {
                client.sslSocketFactory(getSSLSocketFactory(), (X509TrustManager) getTrustManagers()[0]);
                client.hostnameVerifier(getHostnameVerifier());
            }

            client.addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request original = chain.request();
                    String authorization = original.header("Authorization");
                    Request.Builder requestBuilder = original.newBuilder()
                            .addHeader("Accept-Language", "")
                            .addHeader("Platform", "phone")
                            .addHeader("Content-Type", "application/json")
                            .addHeader("Accept", "application/json")
                            .method(original.method(), original.body());

                    if (TextUtils.isEmpty(authorization)) {
                        requestBuilder.addHeader("Authorization", "Bearer " + "");
                    }
                    Request request = requestBuilder.build();
                    Response response = chain.proceed(request);
                    return response;
                }
            });

            client.connectTimeout(60, TimeUnit.SECONDS);
            client.readTimeout(60, TimeUnit.SECONDS);
            return client.build();
        } catch (Exception e) {
            Logger.e(TAG, "Exception during sending API request", e);
            return null;
        }
    }

    private HostnameVerifier getHostnameVerifier() {
        return new HostnameVerifier() {
            @Override
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        };
    }

    private SSLSocketFactory getSSLSocketFactory()
            throws CertificateException, KeyStoreException, IOException,
            NoSuchAlgorithmException, KeyManagementException {
        // Create a trust manager that does not validate certificate chains
        final TrustManager[] trustAllCerts = getTrustManagers();
        // Install the all-trusting trust manager
        final SSLContext sslContext = SSLContext.getInstance("SSL");
        sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
        // Create an ssl socket factory with our all-trusting manager
        return sslContext.getSocketFactory();
    }

    @NonNull
    private TrustManager[] getTrustManagers() {
        return new TrustManager[]{
                new X509TrustManager() {
                    @Override
                    public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                    }

                    @Override
                    public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                    }

                    @Override
                    public X509Certificate[] getAcceptedIssuers() {
                        return new X509Certificate[]{};
                    }
                }
        };
    }

    @Provides
    @ApplicationScope
    Retrofit provideRetrofit(Gson gson, OkHttpClient okHttpClient) {

        return new Retrofit.Builder()
                .baseUrl(mBaseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .build();
    }

    @Provides
    @ApplicationScope
    ApiService provideAPIService(Retrofit restClient) {
        return restClient.create(ApiService.class);
    }



}

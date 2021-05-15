package com.laioffer.tinnews.network;

import android.content.Context;

import com.ashokvarma.gander.GanderInterceptor;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    // TODO: Assign your API_KEY here
    private static final String API_KEY = "beb46e6870c446ccb897d2522e8a54d6";
    private static final String BASE_URL = "https://newsapi.org/v2/";

    //gander is the network debugging tool.
    //Gander lets you see each HTTP request from your app, it’s a very convenient network debugging tool. Add the required dependency
    // to your app/build.gradle (not the project one!),
    // then hit the elephant gradle sync button.
    public static Retrofit newInstance(Context context) {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new HeaderInterceptor())
                .addInterceptor(new GanderInterceptor(context).showNotification(true))
                .build();
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //convert Gson to java
                .client(okHttpClient) //addInterceptor, need return client.
                .build();
    }
    //retrofit extends okhttp
    //okhttp below: add API key in header by NEWsAPI authentation
    private static class HeaderInterceptor implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request original = chain.request();
            Request request = original
                    .newBuilder()
                    .header("X-Api-Key", API_KEY)
                    .build();
            return chain.proceed(request);
        }
    }
}
//This class is responsible for providing a configured Retrofit instance, that can then instantiate a NewsApi implementation. So what’s been configured?
// The base URL. Sometimes you can have different base URLs, for production, develop, and staging environment.
//  A header interceptor. You can attach custom or standard header information to all requests.
//  Gson adapter. This is to tell how a JSON response can be deserialized into model classes.


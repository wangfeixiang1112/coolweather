package android.coolweather.com.coolweather.util;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2017-8-1.
 */

public class HttpUtil {
    public static void sendOkHttpRequest(String address,okhttp3.Callback callback)
    {
        OkHttpClient httpClient = new OkHttpClient();
        Request request = new Request.Builder().url(address).build();
        httpClient.newCall(request).enqueue(callback);
    }
}

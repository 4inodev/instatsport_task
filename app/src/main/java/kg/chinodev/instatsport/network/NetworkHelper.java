package kg.chinodev.instatsport.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkHelper {
    private static NetworkHelper helper;
    private Retrofit retrofit;

    private NetworkHelper() {
        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.instat.tv/test/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static NetworkHelper getInstance() {
        if (helper == null) {
            helper = new NetworkHelper();
        }
        return helper;
    }

    public ApiService getService() {
        return retrofit.create(ApiService.class);
    }
}

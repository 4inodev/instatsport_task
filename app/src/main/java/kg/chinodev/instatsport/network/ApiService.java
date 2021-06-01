package kg.chinodev.instatsport.network;

import java.util.List;

import kg.chinodev.instatsport.network.model.MatchData;
import kg.chinodev.instatsport.network.model.MatchDataRequest;
import kg.chinodev.instatsport.network.model.MatchVideo;
import kg.chinodev.instatsport.network.model.MatchVideoRequest;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {
    @POST("data")
    public Call<MatchData> getMatchData(@Body MatchDataRequest body);

    @POST("video-urls")
    public Call<List<MatchVideo>> getMatchVideo(@Body MatchVideoRequest body);
}

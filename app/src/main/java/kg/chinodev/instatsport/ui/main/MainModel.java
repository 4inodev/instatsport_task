package kg.chinodev.instatsport.ui.main;

import java.util.List;

import kg.chinodev.instatsport.network.NetworkHelper;
import kg.chinodev.instatsport.network.model.MatchData;
import kg.chinodev.instatsport.network.model.MatchDataRequest;
import kg.chinodev.instatsport.network.model.MatchVideo;
import kg.chinodev.instatsport.network.model.MatchVideoRequest;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainModel implements MainContract.Model {
    private final MainContract.Listener listener;

    public MainModel(MainContract.Listener listener) {
        this.listener = listener;
    }

    @Override
    public void loadMatchData(MatchDataRequest body) {
        NetworkHelper.getInstance()
                .getService()
                .getMatchData(body)
                .enqueue(new Callback<MatchData>() {
                    @Override
                    public void onResponse(Call<MatchData> call, Response<MatchData> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            listener.onMatchDataSuccess(response.body());
                        } else listener.onError(response.message());
                    }

                    @Override
                    public void onFailure(Call<MatchData> call, Throwable t) {
                        listener.onError(t.getMessage());
                    }
                });
    }

    @Override
    public void loadMatchVideos(MatchVideoRequest body) {
        NetworkHelper.getInstance()
                .getService()
                .getMatchVideo(body)
                .enqueue(new Callback<List<MatchVideo>>() {
                    @Override
                    public void onResponse(Call<List<MatchVideo>> call, Response<List<MatchVideo>> response) {
                        System.out.println(response.body().toString());
                        if (response.isSuccessful() && response.body() != null) {
                            listener.onMatchVideosSuccess(response.body());
                        } else listener.onError(response.message());
                    }

                    @Override
                    public void onFailure(Call<List<MatchVideo>> call, Throwable t) {
                        listener.onError(t.getMessage());
                    }
                });
    }
}

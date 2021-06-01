package kg.chinodev.instatsport.ui.main;

import java.util.List;

import kg.chinodev.instatsport.network.model.MatchData;
import kg.chinodev.instatsport.network.model.MatchDataRequest;
import kg.chinodev.instatsport.network.model.MatchVideo;
import kg.chinodev.instatsport.network.model.MatchVideoRequest;

public interface MainContract {
    interface View {
        void showMatchData(MatchData data);
        void showMatchVideos(List<MatchVideo> data);
        void showError(String message);
    }
    interface Presenter {
        void loadInfo(MatchDataRequest matchDataRequest, MatchVideoRequest matchVideoRequest);
        void onDetach();
    }
    interface  Model {
        void loadMatchData(MatchDataRequest body);
        void loadMatchVideos(MatchVideoRequest body);
    }
    interface Listener {
        void onMatchDataSuccess(MatchData data);
        void onMatchVideosSuccess(List<MatchVideo> data);
        void onError(String message);
    }
}

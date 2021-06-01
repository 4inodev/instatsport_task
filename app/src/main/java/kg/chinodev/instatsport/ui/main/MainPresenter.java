package kg.chinodev.instatsport.ui.main;

import java.util.List;

import kg.chinodev.instatsport.network.model.MatchData;
import kg.chinodev.instatsport.network.model.MatchDataRequest;
import kg.chinodev.instatsport.network.model.MatchVideo;
import kg.chinodev.instatsport.network.model.MatchVideoRequest;

public class MainPresenter implements MainContract.Presenter, MainContract.Listener {
    private MainContract.View view;
    private MainContract.Model model;

    public MainPresenter(MainContract.View view) {
        this.view = view;
        this.model = new MainModel(this);
    }

    @Override
    public void loadInfo(MatchDataRequest matchDataRequest, MatchVideoRequest matchVideoRequest) {
        model.loadMatchData(matchDataRequest);
        model.loadMatchVideos(matchVideoRequest);
    }

    @Override
    public void onDetach() {
        this.view = null;
    }

    @Override
    public void onMatchDataSuccess(MatchData data) {
        if (view != null) view.showMatchData(data);
    }

    @Override
    public void onMatchVideosSuccess(List<MatchVideo> data) {
        if (view != null) view.showMatchVideos(data);
    }

    @Override
    public void onError(String message) {
        if (view != null) view.showError(message);
    }
}

package kg.chinodev.instatsport.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import kg.chinodev.instatsport.adapter.MatchVideosAdapter;
import kg.chinodev.instatsport.databinding.ActivityMainBinding;
import kg.chinodev.instatsport.network.model.MatchData;
import kg.chinodev.instatsport.network.model.MatchDataRequest;
import kg.chinodev.instatsport.network.model.MatchDataRequestParams;
import kg.chinodev.instatsport.network.model.MatchVideo;
import kg.chinodev.instatsport.network.model.MatchVideoRequest;
import kg.chinodev.instatsport.ui.video.PlayerActivity;
import kg.chinodev.instatsport.util.Constants;
import kg.chinodev.instatsport.util.Util;

public class MainActivity extends AppCompatActivity implements MainContract.View {
    private MainContract.Presenter presenter;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        presenter = new MainPresenter(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        MatchDataRequest dataRequest = new MatchDataRequest(
                "get_match_info",
                new MatchDataRequestParams(1, 1724836)
        );
        MatchVideoRequest videoRequest = new MatchVideoRequest(1724836, 1);
        presenter.loadInfo(dataRequest, videoRequest);
    }

    @Override
    public void showMatchData(MatchData data) {
        binding.matchDate.setText(Util.timeStampToDate(data.date));
        binding.matchName.setText(data.tournament.nameEng);
        binding.teamOneName.setText(data.team1.nameEng);
        binding.teamOneScore.setText(String.valueOf(data.team1.score));
        binding.teamTwoName.setText(data.team2.nameEng);
        binding.teamTwoScore.setText(String.valueOf(data.team2.score));
    }

    @Override
    public void showMatchVideos(List<MatchVideo> data) {
        binding.videosRecycler.setLayoutManager(new GridLayoutManager(this, 2));
        MatchVideosAdapter adapter = new MatchVideosAdapter(data);
        adapter.setListener(item -> {
            Intent intent = new Intent(this, PlayerActivity.class);
            intent.putExtra(Constants.EXTRA_VIDEO_URL, item.url);
            startActivity(intent);
        });
        binding.videosRecycler.setAdapter(adapter);
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
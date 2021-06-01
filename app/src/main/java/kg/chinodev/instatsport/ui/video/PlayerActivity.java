package kg.chinodev.instatsport.ui.video;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.MediaController;

import kg.chinodev.instatsport.databinding.ActivityPlayerBinding;
import kg.chinodev.instatsport.util.Constants;

public class PlayerActivity extends AppCompatActivity {
    private ActivityPlayerBinding binding;
    private String videoUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPlayerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String url = getIntent().getStringExtra(Constants.EXTRA_VIDEO_URL);
        if (url != null) {
            videoUrl = url;
        } else finish();
        initPlayer();
        initPlayerController();
    }

    private void initPlayerController() {
        MediaController controller = new MediaController(this);
        controller.setMediaPlayer(binding.videoView);
        binding.videoView.setMediaController(controller);
    }

    private void initPlayer() {
        binding.progressBar.setVisibility(View.VISIBLE);

        Uri videoUri = Uri.parse(videoUrl);
        binding.videoView.setVideoURI(videoUri);
        binding.videoView.setOnPreparedListener(mediaPlayer -> {
            binding.progressBar.setVisibility(View.GONE);
            binding.videoView.start();
        });
        binding.videoView.setOnCompletionListener(mediaPlayer ->
                finish()
        );
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) { //no need on newer versions
            binding.videoView.pause();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        binding.videoView.stopPlayback();
    }
}
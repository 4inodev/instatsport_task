package kg.chinodev.instatsport.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import kg.chinodev.instatsport.R;
import kg.chinodev.instatsport.network.model.MatchVideo;
import kg.chinodev.instatsport.util.Util;

public class MatchVideosAdapter extends RecyclerView.Adapter<MatchVideosAdapter.ViewHolder> {
    private List<MatchVideo> data;
    private MatchVideosAdapter.MachVideosAdapterListener listener;

    public MatchVideosAdapter(List<MatchVideo> data) {
        this.data = data;
    }

    public void setListener(MachVideosAdapterListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_video, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MatchVideo item = data.get(position);
        holder.qualityType.setText(item.quality + "p " + item.videoType);
        holder.startTime.setText(Util.millisToTime(item.duration));
        holder.itemView.setOnClickListener(v -> {
           if (listener != null) {
               listener.onItemClick(item);
           }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView qualityType;
        TextView startTime;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            qualityType = itemView.findViewById(R.id.video_quality_type);
            startTime = itemView.findViewById(R.id.video_duration);
        }
    }

    public interface MachVideosAdapterListener {
        void onItemClick(MatchVideo item);
    }
}

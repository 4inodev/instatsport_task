package kg.chinodev.instatsport.network.model;

import com.google.gson.annotations.SerializedName;

public class MatchVideoRequest {
    @SerializedName("match_id")
    private long matchId;
    @SerializedName("sport_id")
    private long sportId;

    public MatchVideoRequest(long matchId, long sportId) {
        this.matchId = matchId;
        this.sportId = sportId;
    }
}

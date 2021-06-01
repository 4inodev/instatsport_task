package kg.chinodev.instatsport.network.model;

import com.google.gson.annotations.SerializedName;

public class MatchData {
    @SerializedName("tournament")
    public Tournament tournament;
    @SerializedName("date")
    public String date;
    @SerializedName("team1")
    public Team team1;
    @SerializedName("team2")
    public Team team2;
    @SerializedName("stream_status")
    public long streamStatus;
}
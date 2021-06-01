package kg.chinodev.instatsport.network.model;

import com.google.gson.annotations.SerializedName;

public class MatchVideo {
    @SerializedName("name")
    public String name;
    @SerializedName("match_id")
    public long matchId;
    @SerializedName("period")
    public int period;
    @SerializedName("server_id")
    public long serverId;
    @SerializedName("quality")
    public String quality;
    @SerializedName("folder")
    public String folder;
    @SerializedName("video_type")
    public String videoType;
    @SerializedName("abc")
    public String abc;
    @SerializedName("start_ms")
    public long startMs;
    @SerializedName("checksum")
    public long checksum;
    @SerializedName("size")
    public long size;
    @SerializedName("abc_type")
    public String abcType;
    @SerializedName("duration")
    public long duration;
    @SerializedName("fps")
    public int fps;
    @SerializedName("url_root")
    public String urlRoot;
    @SerializedName("url")
    public String url;
}

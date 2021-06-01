package kg.chinodev.instatsport.network.model;

import com.google.gson.annotations.SerializedName;

public class MatchDataRequest {
    @SerializedName("proc")
    private String proc;
    @SerializedName("params")
    private MatchDataRequestParams params;

    public MatchDataRequest(String proc, MatchDataRequestParams params) {
        this.proc = proc;
        this.params = params;
    }
}

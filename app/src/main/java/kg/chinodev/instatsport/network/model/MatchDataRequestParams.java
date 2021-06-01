package kg.chinodev.instatsport.network.model;

import com.google.gson.annotations.SerializedName;

public class MatchDataRequestParams {
    @SerializedName("_p_sport")
    private int pSport;
    @SerializedName("_p_match_id")
    private long pMatchId;

    public MatchDataRequestParams(int pSport, long pMatchId) {
        this.pSport = pSport;
        this.pMatchId = pMatchId;
    }
}

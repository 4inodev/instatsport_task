package kg.chinodev.instatsport.network.model;

import com.google.gson.annotations.SerializedName;

public class Team {
    @SerializedName("id")
    public long id;
    @SerializedName("name_eng")
    public String nameEng;
    @SerializedName("name_rus")
    public String nameRus;
    @SerializedName("score")
    public long score;
}
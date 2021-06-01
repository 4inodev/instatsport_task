package kg.chinodev.instatsport.network.model;

import com.google.gson.annotations.SerializedName;

public class Tournament {
    @SerializedName("id")
    public long id;
    @SerializedName("name_eng")
    public String nameEng;
    @SerializedName("name_rus")
    public String nameRus;
}

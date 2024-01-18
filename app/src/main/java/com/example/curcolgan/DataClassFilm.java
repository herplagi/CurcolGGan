package com.example.curcolgan;

public class DataClassFilm {

    private String dataTitle;
    private String dataDesc;
    private String dataGenre;
    private String dataCreator;
    private String dataActor;
    private String dataImage;
    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDataTitle() {
        return dataTitle;
    }

    public String getDataDesc() {
        return dataDesc;
    }
    public String getDataGenre() {
        return dataGenre;
    }
    public String getDataCreator() {
        return dataCreator;
    }
    public String getDataActor() {
        return dataActor;
    }
    public String getDataImage() {
        return dataImage;
    }

    public DataClassFilm(String dataTitle, String dataDesc, String dataGenre, String dataCreator, String dataActor, String dataImage) {
        this.dataTitle = dataTitle;
        this.dataDesc = dataDesc;
        this.dataGenre = dataGenre;
        this.dataCreator = dataCreator;
        this.dataActor = dataActor;
        this.dataImage = dataImage;
    }

    public DataClassFilm() {
        // Default constructor is needed for Firebase
    }
}

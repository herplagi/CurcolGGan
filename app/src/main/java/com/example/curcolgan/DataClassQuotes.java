package com.example.curcolgan;

public class DataClassQuotes {

    private String dataQuote;
    private String dataPencipta;
    private String dataImage;
    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDataQuote() {
        return dataQuote;
    }

    public String getDataPencipta() {
        return dataPencipta;
    }


    public String getDataImage() {
        return dataImage;
    }

    public DataClassQuotes(String dataQuote, String dataPencipta, String dataImage) {
        this.dataQuote = dataQuote;
        this.dataPencipta = dataPencipta;
        this.dataImage = dataImage;
    }

    public DataClassQuotes() {
        // Default constructor is needed for Firebase
    }
}

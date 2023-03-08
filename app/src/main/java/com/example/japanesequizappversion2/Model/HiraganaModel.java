package com.example.japanesequizappversion2.Model;

public class HiraganaModel {
    private String textModel;
    private String imgUrl;

    public HiraganaModel() {
    }

    public HiraganaModel(String textModel, String imgUrl) {
        this.textModel = textModel;
        this.imgUrl = imgUrl;
    }

    public String getTextModel() {
        return textModel;
    }

    public void setTextModel(String textModel) {
        this.textModel = textModel;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}

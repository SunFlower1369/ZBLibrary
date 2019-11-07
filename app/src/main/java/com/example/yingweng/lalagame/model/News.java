package com.example.yingweng.lalagame.model;

public class News {
    private String imageUrl;
    private String newsTitle;
    private String newsDescrpotion;

    public News() {
        //default
    }
    public News(String imageUrl) {
        this();
        this.imageUrl = imageUrl;
    }
    public News(String imageUrl, String newsTitle) {
        this(imageUrl);
        this.newsTitle = newsTitle;
    }
    public News(String imageUrl, String newsTitle,String newsDescrpotion) {
        this(imageUrl,newsTitle);
        this.newsDescrpotion = newsDescrpotion;
    }
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsDescrpotion() {
        return newsDescrpotion;
    }

    public void setNewsDescrpotion(String newsDescrpotion) {
        this.newsDescrpotion = newsDescrpotion;
    }
}

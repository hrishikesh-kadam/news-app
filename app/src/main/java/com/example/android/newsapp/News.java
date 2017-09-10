package com.example.android.newsapp;

public class News {

    private String sectionName, webTitle, webPublicationDate, webUrl;

    public News(String sectionName, String webTitle, String webPublicationDate, String webUrl) {
        this.sectionName = sectionName;
        this.webTitle = webTitle;
        this.webPublicationDate = webPublicationDate;
        this.webUrl = webUrl;
    }

    public String getSectionName() {
        return sectionName;
    }

    public String getWebTitle() {
        return webTitle;
    }

    public String getWebPublicationDate() {
        return webPublicationDate;
    }

    public String getWebUrl() {
        return webUrl;
    }
}

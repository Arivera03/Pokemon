package com.example.pokemon;

import com.google.gson.annotations.SerializedName;

public class TypeDetail {
    @SerializedName("name")
    public String name;
    @SerializedName("url")
    public String url;

    public TypeDetail(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

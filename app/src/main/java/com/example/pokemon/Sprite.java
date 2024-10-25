package com.example.pokemon;

import com.google.gson.annotations.SerializedName;

public class Sprite {
    @SerializedName("front_default")
    private String frontDefault;

    public Sprite() {
    }

    public String getFrontDefault() {
        return frontDefault;
    }

    public void setFrontDefault(String frontDefault) {
        this.frontDefault = frontDefault;
    }
}

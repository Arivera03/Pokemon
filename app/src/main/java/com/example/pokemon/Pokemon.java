package com.example.pokemon;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Pokemon {
    public String name;
    public int id;
    @SerializedName("sprites")
    public Sprite sprite;
    public double weight;
    public List<Type> types;

    public Pokemon(){

    }

    public Pokemon(String n, int id, Sprite s, double w, List<Type> t){
        this.name = n;
        this.id = id;
        this.sprite = s;
        this.weight = w;
        this.types = t;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

    public List<Type> getTypes() {
        return types;
    }

    public void setTypes(List<Type> types) {
        this.types = types;
    }

    @Override
    public String toString(){
        return "Nombre: " + this.getName();
    }
}

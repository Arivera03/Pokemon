package com.example.pokemon;

import java.util.List;

public class Pokemon {
    public String name;
    public int id;
    public String sprite;
    public double weight;
    public List<Type> types;

    public Pokemon(){

    }

    public Pokemon(String n, int id, String s, double w, List<Type> t){
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

    public String getSprite() {
        return sprite;
    }

    public void setSprite(String sprite) {
        this.sprite = sprite;
    }

    public List<Type> getTypes() {
        return types;
    }

    public void setTypes(List<Type> types) {
        this.types = types;
    }
}

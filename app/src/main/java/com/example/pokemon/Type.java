package com.example.pokemon;

import com.google.gson.annotations.SerializedName;

public class Type {
    @SerializedName("slot")
    public int slot;
    @SerializedName("type")
    public TypeDetail detalletipo;

    public Type(int slot, TypeDetail detalletipo) {
        this.slot = slot;
        this.detalletipo = detalletipo;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public TypeDetail getDetalletipo() {
        return detalletipo;
    }

    public void setDetalletipo(TypeDetail detalletipo) {
        this.detalletipo = detalletipo;
    }
}

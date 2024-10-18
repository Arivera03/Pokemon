package com.example.pokemon;

public class Type {
    public int slot;
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

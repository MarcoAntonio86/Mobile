package com.devandroidmarcoantonio.lista.Model;

public class Lista {

    private String NomeItem;
    public Lista(){}

    public String getNomeItem() {
        return NomeItem;
    }

    public void setNomeItem(String nomeItem) {
        NomeItem = nomeItem;
    }

    @Override
    public String toString() {
        return "Lista{" +
                "NomeItem='" + NomeItem + '\'' +
                '}';
    }
}

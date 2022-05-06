package com.example.trabalho;

public class Equipamento {

    public int id;
    public String marca, modelo, SO;
    public float preco;

    public Equipamento() {

    }

    public Equipamento(String marca) {
        this.marca = marca;
    }

    public Equipamento(String marca, String modelo, String SO, float preco) {
        this.marca = marca;
        this.modelo = modelo;
        this.SO = SO;
        this.preco = preco;
    }

    public Equipamento(String marca, String modelo, String SO, float preco, int id) {
        this.marca = marca;
        this.modelo = modelo;
        this.SO = SO;
        this.preco = preco;
        this.id = id;
    }

    @Override
    public String toString() {
        return  marca ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getSO() {
        return SO;
    }

    public void setSO(String SO) {
        this.SO = SO;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
}

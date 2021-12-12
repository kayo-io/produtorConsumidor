package com.company;

public class Main {
    public static void main(String[] args) {

        Buffer b = new Buffer(); // Área/Região Crítica

        new Produtor(b).start();
        new Consumidor(b).start();
        new Consumidor(b).start();
        new Consumidor(b).start();
        new Consumidor(b).start();
    }
}

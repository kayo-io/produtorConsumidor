package com.company;

public class Produtor extends Thread {

    Buffer dados;

    public Produtor(Buffer b) {
        this.dados = b;
    }

    public void run() {

        try {
            Thread.sleep(300);
            while (true) {
                this.dados.produzir(1);
                System.out.println("[Produtor]: Novo Dado");
            }

        } catch (Exception e) {

        }
    }
}

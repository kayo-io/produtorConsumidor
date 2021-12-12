package com.company;

import java.util.ArrayList;

public class Buffer<Integer> {
    private ArrayList<java.lang.Integer> dadosInternos;
    int TAMANHO_MAX = 10;

    public Buffer() {
        this.dadosInternos = new ArrayList<java.lang.Integer>();
    }

    public void produzir(int x) {
        synchronized (this.dadosInternos) {
            if (this.dadosInternos.size() == TAMANHO_MAX) {
                try {
                    System.out.println("A Thread(PRODUZIR) foi posta para Dormir (Wait) ");
                    this.dadosInternos.wait(); //Nao faz nada pq ele esta produzindo e o buffer esta cheio - Dormi(Wait)
                    System.out.println("A Thread(PRODUZIR) acordou (saiu do estado Wait) ");
                } catch (InterruptedException e) {
                }
            } else {
                this.dadosInternos.add(x);
                this.dadosInternos.notifyAll(); //Enviar sinal para acordar os outros;
            }
        }
//        System.out.println("Tamanho Buffer: " + this.dadosInternos.size());

    }

    public int consumir() {
        int v = -1;
        synchronized (this.dadosInternos) {
            if (this.dadosInternos.size() == 0) {
                try {
                    System.out.println("A Thread(CONSUMIR) foi posta para Dormir (Wait) ");
                    this.dadosInternos.wait(); //Nao faz nada pq ele está consumindo e o buffer está vazio - Dormir (Wait);
                    System.out.println("A Thread(CONSUMIR) acordou (saiu do estado Wait) ");
                } catch (InterruptedException e) {
                }
            } else {
                v = this.dadosInternos.remove(0); //FIFO
                this.dadosInternos.notifyAll();
            }
        }
        System.out.println("Tamanho Buffer: " + this.dadosInternos.size());
        return v;
    }
}


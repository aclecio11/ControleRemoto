package com.controle;

public class ControleRemoto implements Controlador {
    private boolean ligado;
    private boolean tocando;
    private int volume;

    public ControleRemoto() {
        this.ligado = true;
        this.tocando = false;
        this.volume = 50;
    }

    private boolean getLigado() {
        return ligado;
    }

    private void setLigado(boolean ligado) {
        this.ligado = ligado;
    }

    private boolean getTocando() {
        return tocando;
    }

    private void setTocando(boolean tocando) {
        this.tocando = tocando;
    }

    private int getVolume() {
        return volume;
    }

    private void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public void ligar() {
        this.setLigado(true);
    }

    @Override
    public void desligar() {
        this.setLigado(false);
    }

    @Override
    public void abrirMenu() {
        if (!this.getLigado()) {
            System.out.println("O aparelho está desligado");
        }
        System.out.println("Está ligado? "+getLigado());
        System.out.println("Está tocando? "+getTocando());
        System.out.print("Volume:  "+getVolume());
        for (int i = 0; i <= getVolume(); i+=10){
            System.out.print("|");
        }
    }

    @Override
    public void fecharMenu() {
        System.out.println("Fechando Menu...");
    }

    @Override
    public void maisVolume() {
        if (this.getLigado()) {
            this.setVolume(this.getVolume() + 5);
        } else{
            System.out.println("Impossivel aumentar volume!");
        }
    }

    @Override
    public void menosVolume() {
        if(this.getLigado()){
            this.setVolume(getVolume() - 5);
        }else {
            System.out.println("Impossivel diminuir volume");
        }
    }

    @Override
    public void ligarMudo() {
        if(getLigado() && this.getVolume() >0) {
            this.setVolume(0);
        }
    }

    @Override
    public void desligarMudo() {
        if(this.getLigado() && this.getVolume() == 0) {
            this.setVolume(50);
        }

    }

    @Override
    public void play() {
        if(getLigado() && !(this.getTocando())) {
            this.setTocando(true);
        }else {
            System.out.println("Não consegui reproduzir");
        }

    }

    @Override
    public void pausa() {
        if(getLigado() && this.getTocando()) {
            this.setTocando(false);
        } else {
            System.out.println("Não consegui pausar");
        }
    }
}

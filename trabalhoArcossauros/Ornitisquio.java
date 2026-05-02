package br.com.unipar.poo.trabalhoArcossauros;

public class Ornitisquio extends Dinossauro{
    public Ornitisquio(String alimentacao, String locomocao, String tamanho, boolean predador, boolean oviparo) {
        super(alimentacao, locomocao, tamanho, predador, oviparo);
    }

    public Ornitisquio() {
        super();
        setAlimentacao("Herbívoros");
        setPredador(false);
    }

    @Override
    public void dados(){
        System.out.println("Os Ornitisuios se caracterizam por: ");
        System.out.println("Alimentação: " + getAlimentacao() + "  |  Locomoção: " + getLocomocao() + "  |  Tamanho: " + getTamanho() + "  |  Predador: " + isPredador() + "  |  Oviparo: " + isOviparo() + "\n");

    }
}

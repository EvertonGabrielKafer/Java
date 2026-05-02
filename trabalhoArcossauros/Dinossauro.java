package br.com.unipar.poo.trabalhoArcossauros;

public class Dinossauro extends Arcossauro{
    public Dinossauro(String alimentacao, String locomocao, String tamanho, boolean predador, boolean oviparo) {
        super(alimentacao, locomocao, tamanho, predador, oviparo);
    }

    public Dinossauro() {
        super();
        setTamanho("Médio/Grande");
    }

    @Override
    public void dados(){
        System.out.println("Os Dinossauros se caracterizam por: ");
        System.out.println("Alimentação: " + getAlimentacao() + "  |  Locomoção: " + getLocomocao() + "  |  Tamanho: " + getTamanho() + "  |  Predador: " + isPredador() + "  |  Oviparo: " + isOviparo() + "\n");

    }
}

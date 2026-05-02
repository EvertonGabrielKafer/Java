package br.com.unipar.poo.trabalhoArcossauros;

public class Saurisquio extends Dinossauro{
    public Saurisquio(String alimentacao, String locomocao, String tamanho, boolean predador, boolean oviparo) {
        super(alimentacao, locomocao, tamanho, predador, oviparo);
    }

    public Saurisquio() {
        super();
        setAlimentacao("Carnívoro");
        setTamanho("Grande");

    }

    @Override
    public void dados(){
        System.out.println("Os Saurisquios se caracterizam por: ");
        System.out.println("Alimentação: " + getAlimentacao() + "  |  Locomoção: " + getLocomocao() + "  |  Tamanho: " + getTamanho() + "  |  Predador: " + isPredador() + "  |  Oviparo: " + isOviparo() + "\n");

    }
}

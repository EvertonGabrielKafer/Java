package main.trabalhoArcossauros;

public class Pterossauro extends Arcossauro{

    public Pterossauro(String alimentacao, String locomocao, String tamanho, boolean predador, boolean oviparo) {
        super(alimentacao, locomocao, tamanho, predador, oviparo);
    }

    public Pterossauro() {
        super();
        setAlimentacao("Carnívoro");
        setLocomocao("Voador");
        setTamanho("Médio/Grande");
    }

    @Override
    public void dados(){
        System.out.println("Os Pterossauros se caracterizam por: ");
        System.out.println("Alimentação: " + getAlimentacao() + "  |  Locomoção: " + getLocomocao() + "  |  Tamanho: " + getTamanho() + "  |  Predador: " + isPredador() + "  |  Oviparo: " + isOviparo() + "\n");

    }
}

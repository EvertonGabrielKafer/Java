package main.trabalhoArcossauros;

public class Crocodilo extends Arcossauro{
    public Crocodilo(String alimentacao, String locomocao, String tamanho, boolean predador, boolean oviparo) {
        super(alimentacao, locomocao, tamanho, predador, oviparo);
    }

    public Crocodilo() {
        super();
        setAlimentacao("Carnívoro");
        setLocomocao("Semi-auático");
        setTamanho("Médio/Grande");
    }

    @Override
    public void dados(){
        System.out.println("Os Crocodilos se caracterizam por: ");
        System.out.println("Alimentação: " + getAlimentacao() + "  |  Locomoção: " + getLocomocao() + "  |  Tamanho: " + getTamanho() + "  |  Predador: " + isPredador() + "  |  Oviparo: " + isOviparo() + "\n");

    }
}

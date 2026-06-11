package main.trabalhoArcossauros;

public class Tecnodonte extends Arcossauro{
    public Tecnodonte(String alimentacao, String locomocao, String tamanho, boolean predador, boolean oviparo) {
        super(alimentacao, locomocao, tamanho, predador, oviparo);
    }

    public Tecnodonte() {
        super();
        setAlimentacao("Carnívoro");
        setTamanho("Médio");
    }



    @Override
    public void dados(){
        System.out.println("Os Tecnodontes se caracterizam por: ");
        System.out.println("Alimentação: " + getAlimentacao() + "  |  Locomoção: " + getLocomocao() + "  |  Tamanho: " + getTamanho() + "  |  Predador: " + isPredador() + "  |  Oviparo: " + isOviparo() + "\n");

    }
}

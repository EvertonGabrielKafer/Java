package br.com.unipar.poo.trabalhoArcossauros;

public class Arcossauro {
    private String alimentacao = "Onívoro";
    private String locomocao = "Terrestre";
    private String tamanho = "Variado";
    private boolean predador = true;
    private boolean oviparo = true;

    public Arcossauro(String alimentacao, String locomocao, String tamanho, boolean predador, boolean oviparo) {
        this.alimentacao = alimentacao;
        this.locomocao = locomocao;
        this.tamanho = tamanho;
        this.predador = predador;
        this.oviparo = oviparo;
    }

    public Arcossauro() {}

    public String getAlimentacao() {
        return alimentacao;
    }

    public String getLocomocao() {
        return locomocao;
    }

    public String getTamanho() {
        return tamanho;
    }

    public boolean isPredador() {
        return predador;
    }

    public boolean isOviparo() {
        return oviparo;
    }

    public void setAlimentacao(String alimentacao) {
        this.alimentacao = alimentacao;
    }

    public void setLocomocao(String locomocao) {
        this.locomocao = locomocao;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public void setPredador(boolean predador) {
        this.predador = predador;
    }

    public void setOviparo(boolean oviparo) {
        this.oviparo = oviparo;
    }

    public void dados(){
        System.out.println("Os Arcossauros se caracterizam por: ");
        System.out.println("Alimentação: " + alimentacao + "  |  Locomoção: " + locomocao + "  |  Tamanho: " + tamanho + "  |  Predador: " + predador + "  |  Oviparo: " + oviparo + "\n");

    }
}

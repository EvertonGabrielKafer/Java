package br.com.unipar.poo.batalha;

public enum Mascote {
    GUE_LOBO(5, 0, "Lobo"),
    GUE_URSO(0, 4, "Urso"),
    MAGO_GNOMO(4, 0, "Gnomo"),
    MAGO_ZUMBI(0, 6, "Zumbi");

    private int ataque;
    private int defesa;
    private String nome;

    Mascote(int ataque, int defesa, String nome) {
        this.ataque = ataque;
        this.defesa = defesa;
        this.nome = nome;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    public String getNome() {
        return nome;
    }
}

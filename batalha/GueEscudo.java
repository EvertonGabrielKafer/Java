package br.com.unipar.poo.batalha;

public class GueEscudo {
    private int vida = 45;
    private int Ataque = 11;
    private String Classe = "Guerreiro";
    private int Ponto = 0;
    private String Nome = "Guerreiro do Escudo";

    public GueEscudo(int vida, String classe, int ataque, int ponto, String nome) {
        this.vida = vida;
        Classe = classe;
        Ataque = ataque;
        Ponto = ponto;
        Nome = nome;
    }

    public GueEscudo() {
    }

    public int getVida() {
        return vida;
    }

    public String getClasse() {
        return Classe;
    }

    public int getAtaque() {
        return Ataque;
    }

    public int getPonto() {return Ponto;}

    public String getNome() {return Nome;}


    public void setVida(int vida) {
        this.vida = vida;
    }

    public void setClasse(String classe) {
        Classe = classe;
    }

    public void setAtaque(int ataque) {Ataque = ataque;
    }

    public void setPonto(int ponto) {Ponto = ponto;
    }

    public void setNome(String nome) {Nome = nome;
    }
}

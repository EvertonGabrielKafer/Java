package br.com.unipar.poo.batalha;

public class MagoCajado {
    private int vida = 28;
    private int Ataque = 18;
    private String Classe = "Mago";
    private int Ponto = 0;
    private String Nome = "Mago do Cajado";

    public MagoCajado(int vida, String classe, int ataque, int ponto, String nome) {
        this.vida = vida;
        Classe = classe;
        Ataque = ataque;
        Ponto = ponto;
        Nome = nome;
    }

    public MagoCajado() {
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

    public void setNome(String nome) {Nome = nome;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public void setClasse(String classe) {
        Classe = classe;
    }

    public void setAtaque(int ataque) {Ataque = ataque;}

    public void setPonto(int ponto) {Ponto = ponto;
    }

    public String getNome() {return Nome;
    }
}

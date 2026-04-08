package br.com.unipar.poo.batalha;

public class MagoMagia {
    private int vida = 25;
    private int Ataque = 20;
    private String Classe = "Mago";
    private int Ponto = 0;
    private String Nome = "Mago Magico";

    public MagoMagia(int vida, String classe, int ataque, int ponto, String nome) {
        this.vida = vida;
        Classe = classe;
        Ataque = ataque;
        Ponto = ponto;
        Nome = nome;
    }

    public MagoMagia() {
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

    public String getNome() {return Nome;
    }

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

package br.com.unipar.poo.batalha;

public class Mascotes {
    public Mascote mascote;
    private int ataque;
    private int defesa;
    private String nome;

    public Mascotes(){
        ataque = 0;
        defesa = 0;
        nome = "";
    }

    public void setAtaque(int ataque){ this.ataque = ataque; }
    public void setDefesa(int defesa){ this.defesa = defesa; }
    public void setNome(String nome){ this.nome = nome; }

    public int getAtaque(){ return ataque; }
    public int getDefesa(){ return defesa; }
    public String getNome(){ return nome; }
}

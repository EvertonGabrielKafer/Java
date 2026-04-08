package br.com.unipar.poo.batalha;


import java.util.Random;

//Guerreiro da Espada = 1
//Guerreiro do Escudo = 2

public class Personagem {

    private int vida;
    private int ataque;
    public Tipo tipo;
    private int ponto;
    private String nome;
    private String classe;


    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getPonto() {
        return ponto;
    }

    public int getAtaque() {
        return ataque;
    }

    public String getClasse() {
        return classe;
    }

    public String getNome() {
        return nome;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public void setPonto(int ponto) {
        this.ponto = ponto;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }
}
    /*public int personagem1;
    public int vida1;
    public int pontos1;
    public int golpe;
    public boolean acabar;

    public Tipo tipo;

    public Personagem(){};

    public int getVida1() {return vida1;}
    public int getVida2() {return vida2;}
    public int getPontos1() {return pontos1;}
    public int getPontos2() {return pontos2;}
    public int getGolpe() {return golpe;}
    public boolean getAcabar() {return acabar;}

    public String definir(int personagem1, int personagem2){
        if(personagem1 == 1){

        }
    }

    public String ataque1(){
        if(vida2 > 0){
            this.golpe = new Random().nextInt(16);
            if(golpe != 0){
                this.vida2 -= golpe;
                this.pontos1 += golpe;
                if(vida2 <= 0){
                    return "\nGuerreiro do Escudo  Morreu!!  |  Pontos do Guerreiro da Espada: "+ this.pontos1 + "  |  Vida do Guerreiro do Escudo: 0";
                }
                return "\nSucesso!!  |  Total do ataque: "+ this.golpe +"  |  Pontos do Guerreiro da Espada: "+ this.pontos1 + "  |  Vida do Guerreiro do Escudo: "+ this.vida2;
            }
            return "\nErrou!!  |  Total do ataque: "+ this.golpe +"  |  Pontos do Guerreiro da Espada: "+ this.pontos1 + "  |  Vida do Guerreiro do Escudo: "+ this.vida2;
        }
        return "\nGuerreiro do Escudo Já esta morto";
    }


    public String aumentarVida1(){
        this.vida1 += 5;
        return "\nVida atual do Guerreiro da Espada é: "+ this.vida1;
    }


    public String ataque2(){
        if(vida1 > 0){
            this.golpe = new Random().nextInt(11);
            if(golpe != 0){
                this.vida1 -= golpe;
                this.pontos2 += golpe;
                if(vida1 <= 0){
                    return "\nGuerreiro da Espada  Morreu!!  |  Pontos do Guerreiro do Escudo: "+ this.pontos2 + "  |  Vida do Guerreiro da Espada: 0";
                }
                return "\nSucesso!!  |  Total do ataque: "+ this.golpe +"  |  Pontos do Guerreiro do Escudo: "+ this.pontos2 + "  |  Vida do Guerreiro da Espada: "+ this.vida1;
            }
            return "\nErrou!!  |  Total do ataque: "+ this.golpe +"  |  Pontos do Guerreiro do Escudo: "+ this.pontos2 + "  |  Vida do Guerreiro da Espada: "+ this.vida1;
        }
        return "\nGuerreiro da Espada Já esta morto";
    }


    public String aumentarVida2(){
        this.vida2 += 5;
        return "\nVida atual do Guerreiro do Escudo é: "+ this.vida2;
    }


    public boolean fim(){
        if(vida1 > 0 && vida2 > 0){
            this.acabar = true;
            return this.acabar;
        }
        this.acabar = false;
        return this.acabar;*/

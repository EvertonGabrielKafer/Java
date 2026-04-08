package br.com.unipar.poo.batalha;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        Personagem personagem1 = new Personagem();
        Personagem personagem2 = new Personagem();
        Mascotes mascote1 = new Mascotes();
        Mascotes mascote2 = new Mascotes();
        boolean looping = true;


        System.out.println("----------Seleção de personagem----------");
        System.out.println("\n---------------Personagem 1---------------");
        System.out.println("1 - Guerreiro da Espada");
        System.out.println("2 - Guerreiro do Escudo");
        System.out.println("3 - Mago da Magia");
        System.out.println("4 - Mago do Cajado");
        switch (ler.nextInt()){
            case 1:
            default:
                personagem1.tipo = Tipo.GUE_ESPADA;

                GueEspada gEspada = new GueEspada();

                personagem1.setVida(gEspada.getVida());
                personagem1.setAtaque(gEspada.getAtaque());
                personagem1.setPonto(gEspada.getPonto());
                personagem1.setNome(gEspada.getNome());
                personagem1.setClasse(gEspada.getClasse());
                break;
            case 2:
                personagem1.tipo = Tipo.GUE_ESCUDO;

                GueEscudo gEscudo = new GueEscudo();

                personagem1.setVida(gEscudo.getVida());
                personagem1.setAtaque(gEscudo.getAtaque());
                personagem1.setPonto(gEscudo.getPonto());
                personagem1.setNome(gEscudo.getNome());
                personagem1.setClasse(gEscudo.getClasse());
                break;
            case 3:
                personagem1.tipo = Tipo.MAGO_MAGIA;

                MagoMagia mMagia = new MagoMagia();

                personagem1.setVida(mMagia.getVida());
                personagem1.setAtaque(mMagia.getAtaque());
                personagem1.setPonto(mMagia.getPonto());
                personagem1.setNome(mMagia.getNome());
                personagem1.setClasse(mMagia.getClasse());
                break;
            case 4:
                personagem1.tipo = Tipo.MAGO_CAJAD0;

                MagoCajado mCajado = new MagoCajado();

                personagem1.setVida(mCajado.getVida());
                personagem1.setAtaque(mCajado.getAtaque());
                personagem1.setPonto(mCajado.getPonto());
                personagem1.setNome(mCajado.getNome());
                personagem1.setClasse(mCajado.getClasse());

                break;
        }

        if(personagem1.getClasse().equals("Guerreiro")){
            System.out.println("\n----------Mascotes para Guerreiros----------");
            System.out.println("1 - Lobo (Fornece um leve aumento de ataque)");
            System.out.println("2 - Urso (Fornece um leve aumento de defesa)");

            switch (ler.nextInt()){
                case 1:
                default:
                    mascote1.mascote = Mascote.GUE_LOBO;

                    mascote1.setAtaque(Mascote.GUE_LOBO.getAtaque());
                    mascote1.setNome(Mascote.GUE_LOBO.getNome());
                    break;
                case 2:
                    mascote1.mascote = Mascote.GUE_URSO;

                    mascote1.setDefesa(Mascote.GUE_URSO.getDefesa());
                    mascote1.setNome(Mascote.GUE_URSO.getNome());
                    break;
            }
        }else{
            System.out.println("\n-----------Mascotes para Magos-----------");
            System.out.println("1 - Gnomo (Fornece um leve aumento de ataque)");
            System.out.println("2 - Zumbi (Fornece um leve aumento de defesa)");

            switch (ler.nextInt()){
                case 1:
                default:
                    mascote1.mascote = Mascote.MAGO_GNOMO;

                    mascote1.setAtaque(Mascote.MAGO_GNOMO.getAtaque());
                    mascote1.setNome(Mascote.MAGO_GNOMO.getNome());
                    break;
                case 2:
                    mascote1.mascote = Mascote.MAGO_ZUMBI;

                    mascote1.setDefesa(Mascote.MAGO_ZUMBI.getDefesa());
                    mascote1.setNome(Mascote.MAGO_ZUMBI.getNome());
                    break;
            }
        }


        System.out.println("\n---------------Personagem 2---------------");
        System.out.println("1 - Guerreiro da Espada");
        System.out.println("2 - Guerreiro do Escudo");
        System.out.println("3 - Mago da Magia");
        System.out.println("4 - Mago do Cajado");
        switch (ler.nextInt()){
            case 1:
                personagem2.tipo = Tipo.GUE_ESPADA;

                GueEspada gEspada = new GueEspada();

                personagem2.setVida(gEspada.getVida());
                personagem2.setAtaque(gEspada.getAtaque());
                personagem2.setPonto(gEspada.getPonto());
                personagem2.setNome(gEspada.getNome());
                personagem2.setClasse(gEspada.getClasse());
                break;
            case 2:
            default:
                personagem2.tipo = Tipo.GUE_ESCUDO;

                GueEscudo gEscudo = new GueEscudo();

                personagem2.setVida(gEscudo.getVida());
                personagem2.setAtaque(gEscudo.getAtaque());
                personagem2.setPonto(gEscudo.getPonto());
                personagem2.setNome(gEscudo.getNome());
                personagem2.setClasse(gEscudo.getClasse());
                break;
            case 3:
                personagem2.tipo = Tipo.MAGO_MAGIA;

                MagoMagia mMagia = new MagoMagia();

                personagem2.setVida(mMagia.getVida());
                personagem2.setAtaque(mMagia.getAtaque());
                personagem2.setPonto(mMagia.getPonto());
                personagem2.setNome(mMagia.getNome());
                personagem2.setClasse(mMagia.getClasse());
                break;
            case 4:
                personagem2.tipo = Tipo.MAGO_CAJAD0;

                MagoCajado mCajado = new MagoCajado();

                personagem2.setVida(mCajado.getVida());
                personagem2.setAtaque(mCajado.getAtaque());
                personagem2.setPonto(mCajado.getPonto());
                personagem2.setNome(mCajado.getNome());
                personagem2.setClasse(mCajado.getClasse());
                break;
        }
        ler.nextLine();

        if(personagem2.getClasse().equals("Guerreiro")){
            System.out.println("\n----------Mascotes para Guerreiros----------");
            System.out.println("1 - Lobo (Fornece um leve aumento de ataque)");
            System.out.println("2 - Urso (Fornece um leve aumento de defesa)");

            switch (ler.nextInt()){
                case 1:
                    mascote2.mascote = Mascote.GUE_LOBO;

                    mascote2.setAtaque(Mascote.GUE_LOBO.getAtaque());
                    mascote2.setNome(Mascote.GUE_LOBO.getNome());
                    break;
                case 2:
                default:
                    mascote2.mascote = Mascote.GUE_URSO;

                    mascote2.setDefesa(Mascote.GUE_URSO.getDefesa());
                    mascote2.setNome(Mascote.GUE_URSO.getNome());
                    break;
            }
        }else{
            System.out.println("\n-----------Mascotes para Magos-----------");
            System.out.println("1 - Gnomo (Fornece um leve aumento de ataque)");
            System.out.println("2 - Zumbi (Fornece um leve aumento de defesa)");

            switch (ler.nextInt()){
                case 1:
                    mascote2.mascote = Mascote.MAGO_GNOMO;

                    mascote2.setAtaque(Mascote.MAGO_GNOMO.getAtaque());
                    mascote2.setNome(Mascote.MAGO_GNOMO.getNome());
                    break;
                case 2:
                default:
                    mascote2.mascote = Mascote.MAGO_ZUMBI;

                    mascote2.setDefesa(Mascote.MAGO_ZUMBI.getDefesa());
                    mascote2.setNome(Mascote.MAGO_ZUMBI.getNome());
                    break;
            }
        }


        ler.nextLine();
        do{
            System.out.println("\n\n\n---------------Turno 1---------------");
            System.out.println("\nPara atacar o com "+personagem1.getNome()+" e seu "+mascote1.getNome()+" digite: atacar");
            System.out.println("Para aumentar a vida do "+personagem1.getNome()+" digite: curar");
            switch (ler.nextLine()) {

                case "atacar":
                default:
                    if(personagem2.getVida() > 0){
                        int golpe = new Random().nextInt(personagem1.getAtaque() + mascote1.getAtaque());
                        if(golpe != 0){
                            personagem1.setPonto(personagem1.getPonto() + golpe);
                            golpe -= mascote2.getDefesa();
                            if(golpe > 0) {
                                personagem2.setVida(personagem2.getVida() - golpe);
                                if (personagem2.getVida() <= 0) {
                                    looping = false;
                                    System.out.println("\n" + personagem2.getNome() + "  Morreu!!  |  Pontos do " + personagem1.getNome() + ": " + personagem1.getPonto() + "  |  Vida do " + personagem2.getNome() + ": 0");
                                    break;
                                }
                                System.out.println("\nSucesso!!  |  Total do ataque: " + golpe + "  |  Pontos do " + personagem1.getNome() + ": " + personagem1.getPonto() + "  |  Vida do " + personagem2.getNome() + ": " + personagem2.getVida());
                                break;
                            }
                            System.out.println("\nErrou!!  |  Total do ataque: "+ golpe +"  |  Pontos do "+personagem1.getNome()+": "+ personagem1.getPonto() + "  |  Vida do "+personagem2.getNome()+": "+ personagem2.getVida());
                            break;
                        }
                        System.out.println("\nErrou!!  |  Total do ataque: "+ golpe +"  |  Pontos do "+personagem1.getNome()+": "+ personagem1.getPonto() + "  |  Vida do "+personagem2.getNome()+": "+ personagem2.getVida());
                    }
                    break;

                case "curar":
                    personagem1.setVida(personagem1.getVida() + 5);
                    System.out.println("\nVida atual do "+personagem1.getNome()+" é: "+ personagem1.getVida());
                    break;
            }

            if(looping == false){
                continue;
            }

            System.out.println("\n\n\n---------------Turno 2---------------");
            System.out.println("\nPara atacar o com "+personagem2.getNome()+" e seu "+mascote2.getNome()+" digite: atacar");
            System.out.println("Para aumentar a vida do "+personagem2.getNome()+" digite: curar");
            switch (ler.nextLine()) {

                case "atacar":
                default:
                    if(personagem1.getVida() > 0){
                        int golpe = new Random().nextInt(personagem2.getAtaque() + mascote2.getAtaque());
                        if(golpe != 0){
                            personagem2.setPonto(personagem2.getPonto() + golpe);
                            golpe -= mascote1.getDefesa();
                            if(golpe > 0) {
                                personagem1.setVida(personagem1.getVida() - golpe);
                                if (personagem1.getVida() <= 0) {
                                    looping = false;
                                    System.out.println("\n" + personagem1.getNome() + "  Morreu!!  |  Pontos do " + personagem2.getNome() + ": " + personagem2.getPonto() + "  |  Vida do " + personagem1.getNome() + ": 0");
                                    break;
                                }
                                System.out.println("\nSucesso!!  |  Total do ataque: " + golpe + "  |  Pontos do " + personagem2.getNome() + ": " + personagem2.getPonto() + "  |  Vida do " + personagem1.getNome() + ": " + personagem1.getVida());
                                break;
                            }
                            System.out.println("\nErrou!!  |  Total do ataque: "+ golpe +"  |  Pontos do "+personagem2.getNome()+": "+ personagem2.getPonto() + "  |  Vida do "+personagem1.getNome()+": "+ personagem1.getVida());
                            break;
                        }
                        System.out.println("\nErrou!!  |  Total do ataque: "+ golpe +"  |  Pontos do "+personagem2.getNome()+": "+ personagem2.getPonto() + "  |  Vida do "+personagem1.getNome()+": "+ personagem1.getVida());
                    }
                    break;

                case "curar":
                    personagem2.setVida(personagem2.getVida() + 5);
                    System.out.println("\nVida atual do "+personagem2.getNome()+" é: "+ personagem2.getVida());
                    break;
            }

        }while (looping == true);
    }
}

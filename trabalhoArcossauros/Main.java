package main.trabalhoArcossauros;

public class Main {
    public static void main(String[] args) {
        Arcossauro arcossauro = new Arcossauro();
        Tecnodonte tecnodonte = new Tecnodonte();
        Pterossauro pterossauro = new Pterossauro();
        Dinossauro dinossauro = new Dinossauro();
        Crocodilo crocodilo = new Crocodilo();
        Saurisquio saurisquio = new Saurisquio();
        Ornitisquio ornitisquio = new Ornitisquio();

        arcossauro.dados();
        tecnodonte.dados();
        pterossauro.dados();
        dinossauro.dados();
        crocodilo.dados();
        saurisquio.dados();
        ornitisquio.dados();
    }
}

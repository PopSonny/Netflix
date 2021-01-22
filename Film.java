package test;


import java.util.ArrayList;

public class Film extends FilmAndSerial{
    private String durataFilm; //in minute

    public Film(String nume, String gen, String descriere, ArrayList<Actor> actori, String limitaDeVarsta, int anAparitie, String durataFilm) {
        super(nume, gen, descriere, actori, limitaDeVarsta, anAparitie);
        this.durataFilm = durataFilm;
    }

    public String getDurataFilm() {
        return durataFilm;
    }

    public void setDurataFilm(String durataFilm) {
        this.durataFilm = durataFilm;
    }
}

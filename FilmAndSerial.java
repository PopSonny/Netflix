package test;


import java.util.ArrayList;

public class FilmAndSerial {
    private String nume;
    private String gen;
    private String descriere;
    private ArrayList<Actor> actori;
    private String limitaDeVarsta;
    private int anAparitie;

    public FilmAndSerial(String nume, String gen, String descriere, ArrayList<Actor> actori, String limitaDeVarsta, int anAparitie) {
        this.nume = nume;
        this.gen = gen;
        this.descriere = descriere;
        this.actori = actori;
        this.limitaDeVarsta = limitaDeVarsta;
        this.anAparitie = anAparitie;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getGen() {
        return gen;
    }

    public void setGen(String gen) {
        this.gen = gen;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public ArrayList<Actor> getActori() {
        return actori;
    }

    public void setActori(ArrayList<Actor> actori) {
        this.actori = actori;
    }

    public String getLimitaDeVarsta() {
        return limitaDeVarsta;
    }

    public void setLimitaDeVarsta(String limitaDeVarsta) {
        this.limitaDeVarsta = limitaDeVarsta;
    }

    public int getAnAparitie() {
        return anAparitie;
    }

    public void setAnAparitie(int anAparitie) {
        this.anAparitie = anAparitie;
    }
}

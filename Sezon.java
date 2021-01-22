package test;



import java.util.ArrayList;

public class Sezon {
    private int numarSezon;
    private int numarEpisoade;
    private ArrayList<Episod> listaEpisoade;

    public Sezon(int numarSezon, int numarEpisoade,ArrayList<Episod> ep) {
        this.numarSezon = numarSezon;
        this.numarEpisoade = numarEpisoade;
        this.listaEpisoade=ep;
    }

    public int getNumarSezon() {
        return numarSezon;
    }

    public void setNumarSezon(int numarSezon) {
        this.numarSezon = numarSezon;
    }

    public int getNumarEpisoade() {
        return numarEpisoade;
    }

    public void setNumarEpisoade(int numarEpisoade) {
        this.numarEpisoade = numarEpisoade;
    }

    public ArrayList<Episod> getListaEpisoade() {
        return listaEpisoade;
    }

    public void setListaEpisoade(ArrayList<Episod> listaEpisoade) {
        this.listaEpisoade = listaEpisoade;
    }
}

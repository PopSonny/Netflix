package test;

public class Episod {
    private int numarEpisod;
    private String numeEpisod;
    private String durataEpisod;

    public Episod(int numarEpisod, String numeEpisod, String durataEpisod) {
        this.numarEpisod = numarEpisod;
        this.numeEpisod = numeEpisod;
        this.durataEpisod = durataEpisod;
    }

    public int getNumarEpisod() {
        return numarEpisod;
    }

    public void setNumarEpisod(int numarEpisod) {
        this.numarEpisod = numarEpisod;
    }

    public String getNumeEpisod() {
        return numeEpisod;
    }

    public void setNumeEpisod(String numeEpisod) {
        this.numeEpisod = numeEpisod;
    }

    public String getDurataEpisod() {
        return durataEpisod;
    }

    public void setDurataEpisod(String durataEpisod) {
        this.durataEpisod = durataEpisod;
    }
}

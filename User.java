package test;



import java.awt.*;
import java.util.ArrayList;

public class User {
    private String nume;
    private ArrayList<FilmAndSerial> myList =new ArrayList<>();
    private ArrayList<FilmAndSerial> vazute =new ArrayList<>();
    private Color culoare=Color.white;

    public User(String nume) {
        this.nume = nume;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public Color getCuloare() {
        return culoare;
    }

    public void setCuloare(Color culoare) {
        this.culoare = culoare;
    }
}

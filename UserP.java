package test;


import java.util.ArrayList;

public class UserP {
    private ArrayList<User> users=new ArrayList<>(4);
    private String email;
    private String parola;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public UserP(ArrayList<User> users, String email, String parola) {
        this.users = users;
        this.email = email;
        this.parola = parola;
    }
}
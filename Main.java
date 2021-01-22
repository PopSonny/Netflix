package test;

import java.util.ArrayList;

/*
-lista de useri
-user personalizat
-categorii de filme
-my list
-trending ?
-watch it again
-lista filme vizionate care nu mai apar
-setari
-notificare
-ce poate face useru (interfata user)
-clasa film
-clasa serial
 */
public class Main {

    public static void main(String[] args) {
        ArrayList<User> u = new ArrayList<>();
        u.add(new User("A"));
        u.add(new User("B"));
        u.add(new User("C"));
        u.add(new User("D"));

        UserP p1 = new UserP(u, "1234a", "1234");
        ClasaStaticaDate.adaugareActori();
        ClasaStaticaDate.adaugareFilme();
        ClasaStaticaDate.adaugareSeriale();
        ClasaStaticaDate.users.add(p1);
        LoginScreen login = new LoginScreen();

        login.start();

    }
}

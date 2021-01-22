package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginScreen extends JFrame {
    public void start() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(200, 300);
        this.setLocationRelativeTo(null);

        JPanel total = new JPanel();
        total.setLayout(new BoxLayout(total, BoxLayout.Y_AXIS));

        //panel ptr user/parola
        JPanel userParola = new JPanel();
        userParola.setLayout(new FlowLayout());
        JLabel user = new JLabel("E-mail");
        JTextField userText = new JTextField("1234a", 10);

        userParola.add(user);
        userParola.add(userText);

        JLabel pass = new JLabel("Password");
        JPasswordField passText = new JPasswordField("1234", 10);
        passText.setEchoChar('*');

        userParola.add(pass);
        userParola.add(passText);

        //buton ptr sign in
        JPanel loginP = new JPanel();
        JButton login = new JButton("Sign in");
        loginP.add(login);



        //panelul ptr afisarea mesajului incorrect
        JPanel verificareP=new JPanel();
        JLabel incorect = new JLabel("E-mail or password incorrect!");
        verificareP.add(incorect);
        verificareP.setVisible(false);


        //logare nu merge altfel
        final String[] parrT = new String[1];
        final String[] emailT = new String[1];

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                emailT[0] = userText.getText();
                parrT[0] = passText.getText();
                for (UserP p : ClasaStaticaDate.users) {
                    if (p.getEmail().equals(emailT[0]) && p.getParola().equals(parrT[0])) {
                        LoginScreen.super.setVisible(false);
                        HomePage h = new HomePage();
                        h.go(p.getUsers());
                    }
                }
                verificareP.setVisible(true);
            }
        });

        //button de inregistrare
        JButton inregistrare=new JButton("Create account");
        userParola.add(inregistrare);

        inregistrare.addActionListener(new CreateAccountActionListener(this));

        total.add(userParola);
        total.add(loginP);
        total.add(verificareP);

        this.setContentPane(total);
        this.setVisible(true);


    }
}

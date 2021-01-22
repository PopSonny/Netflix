package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CreateAccountActionListener implements ActionListener {
    private JFrame framexit;

    public CreateAccountActionListener(JFrame f) {
        this.framexit = f;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        framexit.setVisible(false);
        JFrame inregistrare = new JFrame();
        inregistrare.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inregistrare.setSize(300, 400);
        inregistrare.setLocationRelativeTo(null);
        inregistrare.setResizable(false);

        JPanel total = new JPanel();
        total.setLayout(new BoxLayout(total, BoxLayout.Y_AXIS));

        //panel ptr email
        JPanel emailP = new JPanel();
        emailP.setLayout(new FlowLayout());
        JLabel email = new JLabel("E-mail");
        JTextField emailT = new JTextField("Insert e-mail", 10);
        emailP.add(email);
        emailP.add(emailT);

        //panel ptr pass 1

        JPanel pass1P = new JPanel();
        pass1P.setLayout(new FlowLayout());
        JLabel pass1L = new JLabel("Type your password");
        JTextField pass1T = new JTextField("", 10);
        pass1P.add(pass1L);
        pass1P.add(pass1T);

        //panel ptr pass2
        JPanel pass2P = new JPanel();
        pass2P.setLayout(new FlowLayout());
        JLabel pass2L = new JLabel("Re-type your password");
        JTextField pass2T = new JTextField("", 10);
        pass2P.add(pass2L);
        pass2P.add(pass2T);


        //Label ptr informare nicknames
        JLabel utilizatori = new JLabel("Insert the users nicknames");

        //panel ptr nicknames
        JPanel nickname = new JPanel();
        nickname.setLayout(new FlowLayout());

        JTextField nick1 = new JTextField(10);
        JTextField nick2 = new JTextField(10);
        JTextField nick3 = new JTextField(10);
        JTextField nick4 = new JTextField(10);

        nickname.add(nick1);
        nickname.add(nick2);
        nickname.add(nick3);
        nickname.add(nick4);


        //button ptr confirmare

        JButton confirmare = new JButton("Confirm");

        final boolean[] verificare = {false, false, false};


        //panel greseala
        JPanel gresealaP = new JPanel();
        JLabel greseala = new JLabel();

        gresealaP.add(greseala);
        gresealaP.setVisible(false);


        confirmare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean ok = false;
                for (UserP p : ClasaStaticaDate.users) {
                    if (p.getEmail().equals(emailT.getText()) || emailT.getText().equals("")) {
                        verificare[0] = true;
                        greseala.setText("This e-mail is already used");
                        gresealaP.setVisible(true);
                        ok = true;
                        break;
                    }
                }
                if (!ok) {
                    if (!pass1T.getText().equals(pass2T.getText()) || pass1T.getText().equals("") || pass2T.getText().equals("")) {
                        verificare[1] = true;
                        greseala.setText("The passwords don't match");
                        gresealaP.setVisible(true);
                        ok = true;
                    }
                    if (!ok) {
                        String nume1 = nick1.getText();
                        String nume2 = nick2.getText();
                        String nume3 = nick3.getText();
                        String nume4 = nick4.getText();
                        if (nume1.equals("") || nume2.equals("") || nume3.equals("") || nume4.equals("")) {
                            verificare[2] = true;
                            greseala.setText("Please insert all the nicknames");
                            gresealaP.setVisible(true);
                            ok = true;
                        }
                        if (!ok) {
                            ArrayList<User> useraux = new ArrayList<>();
                            useraux.add(new User(nume1));
                            useraux.add(new User(nume2));
                            useraux.add(new User(nume3));
                            useraux.add(new User(nume4));
                            ClasaStaticaDate.users.add(new UserP(useraux, emailT.getText(), pass1T.getText()));
                            inregistrare.setVisible(false);
                            LoginScreen l = new LoginScreen();
                            l.start();

                        }
                    }
                }
            }
        });


        total.add(emailP);
        total.add(pass1P);
        total.add(pass2P);
        total.add(utilizatori);
        total.add(nickname);

        total.add(gresealaP);

        total.add(confirmare);

        inregistrare.setContentPane(total);
        inregistrare.setVisible(true);

    }
}

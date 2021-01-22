package test;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class HomePage extends JFrame {
    public void go(ArrayList<User> users)
    {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000,500);
        this.setLocationRelativeTo(null);

        JPanel sigla = new JPanel();
        JPanel profil=new JPanel();
        JPanel total=new JPanel();

        JLabel titluSigla =new JLabel("NETFLIX");


        sigla.add(titluSigla);

        JButton profil1=new JButton(users.get(0).getNume());
        profil1.setBackground(users.get(0).getCuloare());
        JButton profil2=new JButton(users.get(1).getNume());
        profil2.setBackground(users.get(1).getCuloare());
        JButton profil3=new JButton(users.get(2).getNume());
        profil3.setBackground(users.get(2).getCuloare());
        JButton profil4=new JButton(users.get(3).getNume());
        profil4.setBackground(users.get(3).getCuloare());
        profil.setLayout(new FlowLayout());

        JLabel whos =new JLabel("Who's watching?");
        JPanel whosP=new JPanel();
        whosP.add(whos);


        profil.add(profil1);
        profil.add(profil2);
        profil.add(profil3);
        profil.add(profil4);

        profil1.addActionListener(new ActionListenerProfil(this,users.get(0)));
        profil2.addActionListener(new ActionListenerProfil(this,users.get(1)));
        profil3.addActionListener(new ActionListenerProfil(this,users.get(2)));
        profil4.addActionListener(new ActionListenerProfil(this,users.get(3)));


        total.setLayout(new BoxLayout(total,BoxLayout.Y_AXIS));


        //buton ptr exit
        JButton exit=new JButton("Exit");

        exit.addActionListener(new ExitToSignInActionListener(this));

        total.add(sigla);
        total.add(whosP);
        total.add(profil);
        total.add(exit);

        this.setContentPane(total);
        this.setVisible(true);

    }

    public static void main(String[] args) {
        HomePage p=new HomePage();
        ArrayList<User> u=new ArrayList<>();
        u.add(new User("A"));
        u.add(new User("B"));
        u.add(new User("C"));
        u.add(new User("D"));
        p.go(u);
    }

}

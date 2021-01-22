package test;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfilePage extends JFrame {
    private User u;
    private JFrame home;

    public ProfilePage(User u, JFrame h) throws HeadlessException {
        this.u = u;
        this.home=h;
    }

    public void button()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000,750);
        this.setLocationRelativeTo(null);

        JPanel total=new JPanel();
        total.setLayout(new BoxLayout(total,BoxLayout.Y_AXIS));

        JPanel sigla = new JPanel();
        JLabel titluSigla =new JLabel("NETFLIX");
        sigla.add(titluSigla);


        JPanel meniu=new JPanel();
        meniu.setLayout(new FlowLayout());

        //butoanele meniu utilizator
        JButton tvShows =new JButton("TV Shows");
        JButton movies =new JButton("Movies");
       // JButton myList =new JButton("My List");


        //panel ptr searchbox
        JPanel searchP =new JPanel();
        searchP.setLayout(new FlowLayout());
        JTextField searchT= new JTextField("Insert here",30);
        JButton searchB =new JButton("Search");


        searchB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String numeCautat=searchT.getText();
                boolean merge=false;
                for(Film f: ClasaStaticaDate.filme)
                {
                    if(f.getNume().equals(numeCautat))
                    {
                        JOptionPane.showMessageDialog(null, "Film a fost gasit!", "Info", JOptionPane.INFORMATION_MESSAGE);
                        merge=true;
                        break;
                    }
                }
                if(!merge)
                {
                    for(Serial s:ClasaStaticaDate.seriale)
                    {
                        if(s.getNume().equals(numeCautat))
                        {
                            JOptionPane.showMessageDialog(null, "Serialul a fost gasit!", "Info", JOptionPane.INFORMATION_MESSAGE);

                            merge=true;
                            break;
                        }
                    }
                }
                if(!merge)
                {
                    JOptionPane.showMessageDialog(null, "Nu exista filmul/serialul introdus!", "Info", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        //adaugare la search
        searchP.add(searchT);
        searchP.add(searchB);

        //adaugare combobox profil
        JComboBox<String> searchCombo=new JComboBox<>(new String[]{u.getNume(),"Settings", "Sign out"});
        searchP.add(searchCombo);
        searchCombo.addActionListener(new ComboBobProfileActionListener(searchCombo,home,this,u));


        //adaugare la meniu
        meniu.add(tvShows);

        tvShows.addActionListener(new ActionListenerSeriale(this));



        meniu.add(movies);

        //adaugare actiune la butonul movies
        movies.addActionListener(new ActionListenerMovie(this));

       // meniu.add(myList);



        //ptr imagine
        JPanel img=new JPanel();
        JLabel label=new JLabel();
        ImageIcon imagine=new ImageIcon("imagine.jpg");
        label.setIcon(imagine);

        img.add(label);

        //adaugare paneluri la panel Total
        total.add(sigla);
        total.add(meniu);
        total.add(searchP);
        total.add(label);

        this.setContentPane(total);
        this.setVisible(true);
    }
}

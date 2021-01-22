package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionListenerMovie implements ActionListener {
    private JFrame frameP = new JFrame();
    public ActionListenerMovie(JFrame j){
        this.frameP=j;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        frameP.setVisible(false);
        JFrame movieF = new JFrame();
        movieF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        movieF.setSize(1000,500);
        movieF.setLocationRelativeTo(null);

        JPanel totalM = new JPanel();
        totalM.setLayout(new GridLayout(2,1));

        //panel cu butonul back
        JPanel m = new JPanel();
        JButton back = new JButton("BACK");

        m.add(back);

        JPanel movieP = new JPanel();
        movieP.setLayout(new GridLayout(4,2));

       for(Film f : ClasaStaticaDate.filme){
           JButton bf = new JButton(f.getNume());
           bf.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                   movieF.setVisible(false);
                   JFrame movieNew = new JFrame();
                   movieNew.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                   movieNew.setSize(1000,500);
                   movieNew.setLocationRelativeTo(null);

                   JPanel totalF = new JPanel();
                   totalF.setLayout(new BoxLayout(totalF,BoxLayout.Y_AXIS));

                   JPanel numePanel = new JPanel();
                   JLabel numeFilm = new JLabel(f.getNume());






                   ///TREBUIE ICOANE PENTRU FILM !!!!



                   numePanel.add(numeFilm);

                   JPanel detalii = new JPanel();
                   detalii.setLayout(new GridLayout(2,2));
                   JLabel gen = new JLabel("Genul filmului este " + f.getGen(),SwingConstants.CENTER);
                   JLabel limitaVarsta = new JLabel("Limita de varsta este: " + f.getLimitaDeVarsta(),SwingConstants.CENTER);
                   JLabel anAparitie = new JLabel(("Anul aparitiei este: " + Integer.toString(f.getAnAparitie())),SwingConstants.CENTER);
                   JLabel durata = new JLabel("Durata: " + f.getDurataFilm(),SwingConstants.CENTER);


                   JPanel descriere = new JPanel();
                   JLabel descr = new JLabel(f.getDescriere());

                   descriere.add(descr);

                   JPanel actori = new JPanel();
                   actori.setLayout(new GridLayout(1,3));

                   JLabel act = new JLabel("Actorii sunt: ",SwingConstants.CENTER);
                   actori.add(act);
                   for(Actor a:f.getActori()){
                       JLabel actor = new JLabel(a.getNumeActor(),SwingConstants.CENTER);
                       actori.add(actor);
                   }

                   detalii.add(gen);
                   detalii.add(limitaVarsta);
                   detalii.add(anAparitie);
                   detalii.add(durata);


                   JPanel m = new JPanel();
                   m.setLayout(new FlowLayout());
                   JButton back = new JButton("BACK");
                   //buton ptr play
                   JButton play =new JButton("Play");
                   m.add(play);
                   m.add(back);
                   back.addActionListener(new ActionListener() {
                       @Override
                       public void actionPerformed(ActionEvent e) {
                           movieF.setVisible(true);
                           movieNew.setVisible(false);
                       }
                   });

                   play.addActionListener(new ActionListener() {
                       @Override
                       public void actionPerformed(ActionEvent e) {
                           JOptionPane.showMessageDialog(null, "Se vizioneaza "+f.getNume(), "Info", JOptionPane.INFORMATION_MESSAGE);
                       }
                   });


                   totalF.add(numePanel);
                   totalF.add(detalii);
                   totalF.add(descriere);
                   totalF.add(actori);
                   totalF.add(m);
                   movieNew.setContentPane(totalF);
                   movieNew.setVisible(true);

               }
           });
           movieP.add(bf);
       }
       totalM.add(movieP);
       totalM.add(m);




        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameP.setVisible(true);
                movieF.setVisible(false);
            }
        });
        movieF.setContentPane(totalM);
        movieF.setVisible(true);

    }
}

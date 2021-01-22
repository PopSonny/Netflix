package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class ComboBobProfileActionListener implements ActionListener {

    private JFrame closeFrame;
    private JFrame openFrame;

    private User u;

    private JComboBox<String> jcombo;
    public ComboBobProfileActionListener(JComboBox<String> j,JFrame open,JFrame close,User primit) {
        this.jcombo=j;
        this.closeFrame=close;
        this.openFrame=open;
        this.u=primit;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String choice= (String) jcombo.getSelectedItem();
        switch (Objects.requireNonNull(choice)){
            case "Sign out":
            {
                this.closeFrame.setVisible(false);
                this.openFrame.setVisible(true);
                break;
            }
            case "Settings":
            {
                this.closeFrame.setVisible(false);
                JFrame setariFrame=new JFrame();
                setariFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setariFrame.setSize(500,400);
                setariFrame.setLocationRelativeTo(null);
                setariFrame.setResizable(false);

                JPanel masterPanel=new JPanel();
                masterPanel.setLayout(new BoxLayout(masterPanel,BoxLayout.Y_AXIS));

                JPanel antetPanel=new JPanel();
                antetPanel.setLayout(new BoxLayout(antetPanel,BoxLayout.Y_AXIS));

                JPanel numePanel=new JPanel();
                numePanel.setLayout(new FlowLayout());

                JPanel culoarePanel=new JPanel();
                culoarePanel.setLayout(new FlowLayout());

                JPanel butoanePanel=new JPanel();
                butoanePanel.setLayout(new FlowLayout());

                //panel antet
                JLabel settingsLabel=new JLabel("Settings");
                settingsLabel.setFont(new Font("Arial", Font.BOLD, 30));
                JLabel numeUserLabel=new JLabel("Numele utilizatorului este "+u.getNume());
                numeUserLabel.setFont(new Font("Arial", Font.BOLD, 15));
                numeUserLabel.setForeground(Color.blue);

                settingsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                antetPanel.add(settingsLabel);
                numeUserLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                antetPanel.add(numeUserLabel);

                //nume panel
                JLabel schimbaNumeLabel=new JLabel("Noul nume este: ");
                JTextField schimbaNumeText=new JTextField(10);
                numePanel.add(schimbaNumeLabel);
                numePanel.add(schimbaNumeText);

                //culoare Aura
                JLabel schimbaCuloareaLabel=new JLabel("Seteaza culoarea dorita: ");
                JComboBox<String> culoriDisponibile=new JComboBox<>(new String[]{"Albastru", "Turcoaz", "Verde","Rosu","Galben"});
                culoarePanel.add(schimbaCuloareaLabel);
                culoarePanel.add(culoriDisponibile);

                //butoane panel
                JButton aplicareButon=new JButton("Aplicare modificari");
                JButton backButon=new JButton("Back");
                butoanePanel.add(aplicareButon);
                butoanePanel.add(backButon);

                backButon.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        closeFrame.setVisible(true);
                        setariFrame.dispose();
                    }
                });

                aplicareButon.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String numeNou=schimbaNumeText.getText();
                        String culoare= (String) culoriDisponibile.getSelectedItem();
                        u.setNume(numeNou);
                        switch (Objects.requireNonNull(culoare)){
                            case "Albastru":
                            {
                                u.setCuloare(Color.BLUE);
                                break;
                            }
                            case "Turcoaz":
                            {
                                u.setCuloare(Color.CYAN);
                                break;
                            }
                            case "Verde":
                            {
                                u.setCuloare(Color.GREEN);
                                break;
                            }
                            case "Rosu":
                            {
                                u.setCuloare(Color.RED);
                                break;
                            }
                            case "Galben":
                            {
                                u.setCuloare(Color.YELLOW);
                                break;
                            }
                        }
                        JOptionPane.showMessageDialog(null, "Setarile au fost modificate! Va rugam sa va reconectati!", "Info", JOptionPane.INFORMATION_MESSAGE);
                    }
                });



                antetPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
                masterPanel.add(antetPanel);
                masterPanel.add(Box.createRigidArea(new Dimension(0, 40)));
                numePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
                masterPanel.add(numePanel);
                culoarePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
                masterPanel.add(culoarePanel);
                butoanePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
                masterPanel.add(butoanePanel);

                setariFrame.setContentPane(masterPanel);
                setariFrame.setVisible(true);
                break;
            }
            default:
            {
                break;
            }
        }

    }
}

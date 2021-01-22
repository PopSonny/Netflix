package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionListenerSeriale implements ActionListener {
    private JFrame deInchis;

    public ActionListenerSeriale(JFrame deInchis) {
        this.deInchis = deInchis;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        deInchis.setVisible(false);
        JFrame serialeFrame=new JFrame();
        serialeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        serialeFrame.setSize(500,400);
        serialeFrame.setLocationRelativeTo(null);
        serialeFrame.setResizable(false);


        JPanel masterPanel=new JPanel();
        masterPanel.setLayout(new BoxLayout(masterPanel,BoxLayout.Y_AXIS));

        JPanel serialePanel=new JPanel();
        serialePanel.setLayout(new GridLayout(4,4));

        JPanel butonPanel=new JPanel();

        for(Serial s : ClasaStaticaDate.seriale)
        {
            JButton serialButon=new JButton(s.getNume());
            serialePanel.add(serialButon);

            serialButon.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    serialeFrame.setVisible(false);
                    JFrame framePtrSerial=new JFrame();
                    framePtrSerial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    framePtrSerial.setResizable(false);
                    framePtrSerial.setSize(1000,800);
                    framePtrSerial.setLocationRelativeTo(null);

                    JPanel masterPanelSerial=new JPanel();
                    masterPanelSerial.setLayout(new BoxLayout(masterPanelSerial,BoxLayout.Y_AXIS));

                    JPanel antetPanel=new JPanel();
                    antetPanel.setLayout(new FlowLayout());

                    JLabel numeLabel=new JLabel(s.getNume()+" si serialul are "+s.getNumarSezoane()+" sezoane");
                    antetPanel.add(numeLabel);


                    JPanel genSiLimitaPanel=new JPanel();
                    genSiLimitaPanel.setLayout(new FlowLayout());


                    JLabel genLabel=new JLabel("Genul serialului este: "+s.getGen());
                    JLabel limitaLabel=new JLabel("Limita de varsta este: "+s.getLimitaDeVarsta());
                    genSiLimitaPanel.add(genLabel);
                    genSiLimitaPanel.add(limitaLabel);


                    JPanel aparitiePanel=new JPanel();
                    aparitiePanel.setLayout(new FlowLayout());

                    JLabel anAparitieLabel=new JLabel("Anul aparitiei este: "+String.valueOf(s.getAnAparitie()));
                    aparitiePanel.add(anAparitieLabel);




                    JPanel descrierePanel=new JPanel();
                    descrierePanel.setLayout(new FlowLayout());
                    JLabel descriereLabel=new JLabel(s.getDescriere());
                    descrierePanel.add(descriereLabel);

                    JPanel actoriPanel=new JPanel();
                    actoriPanel.setLayout(new GridLayout(1,4));

                    JLabel act = new JLabel("Actorii sunt: ",SwingConstants.CENTER);
                    actoriPanel.add(act);
                    for(Actor a:s.getActori()){
                        JLabel actor = new JLabel(a.getNumeActor(),SwingConstants.CENTER);
                        actoriPanel.add(actor);
                    }



                    JPanel sezonSiEpisoadePanel=new JPanel();
                    sezonSiEpisoadePanel.setLayout(new FlowLayout());


                    JLabel nSez=new JLabel("Sezonul: ");

                    JComboBox<Integer> sezonCombo=new JComboBox<>();
                    for(Sezon sezon:s.getSezoane())
                    {
                        sezonCombo.addItem(sezon.getNumarSezon());
                    }
                    JComboBox<String> episodCombo=new JComboBox<>();


                    sezonCombo.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            episodCombo.removeAllItems();
                            int sezonNumar= (Integer) sezonCombo.getSelectedItem();
                            //System.out.println(sezonNumar);
                            Sezon sezonCautat=s.getSezoane().get(sezonNumar-1);
                            for(Episod epi:sezonCautat.getListaEpisoade())
                            {
                                episodCombo.addItem(epi.getNumeEpisod());
                            }
                        }
                    });

                    JLabel nEpLabel=new JLabel(" are episoadele: ");


                    sezonSiEpisoadePanel.add(nSez);
                    sezonSiEpisoadePanel.add(sezonCombo);
                    sezonSiEpisoadePanel.add(nEpLabel);
                    sezonSiEpisoadePanel.add(episodCombo);




                    JPanel butoanePanel=new JPanel();
                    butoanePanel.setLayout(new FlowLayout());

                    JButton bacKButton=new JButton("Back");
                    JButton playButton=new JButton("Play");

                    playButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JOptionPane.showMessageDialog(null, "Se vizioneaza episodul "+String.valueOf(episodCombo.getSelectedItem()), "Info", JOptionPane.INFORMATION_MESSAGE);

                        }
                    });

                    bacKButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            serialeFrame.setVisible(true);
                            framePtrSerial.setVisible(false);

                        }
                    });
                    butoanePanel.add(playButton);
                    butoanePanel.add(bacKButton);




                    antetPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
                    masterPanelSerial.add(antetPanel);
                    genSiLimitaPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
                    masterPanelSerial.add(genSiLimitaPanel);
                    aparitiePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
                    masterPanelSerial.add(aparitiePanel);
                    descrierePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
                    masterPanelSerial.add(descrierePanel);
                    actoriPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
                    masterPanelSerial.add(actoriPanel);
                    sezonSiEpisoadePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
                    masterPanelSerial.add(sezonSiEpisoadePanel);
                    butoanePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
                    masterPanelSerial.add(butoanePanel);

                    framePtrSerial.setContentPane(masterPanelSerial);
                    framePtrSerial.setVisible(true);
                }
            });

        }

        JButton backButton=new JButton("Back");

        butonPanel.add(backButton);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deInchis.setVisible(true);
                serialeFrame.setVisible(false);
            }
        });


        masterPanel.add(serialePanel);
        masterPanel.add(butonPanel);

        serialeFrame.setContentPane(masterPanel);
        serialeFrame.setVisible(true);

    }
}

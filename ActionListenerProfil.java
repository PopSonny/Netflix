package test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionListenerProfil implements ActionListener {
    private User u;
    private JFrame jf;
    public ActionListenerProfil(JFrame j,User u) {
        this.jf=j;
        this.u=u;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.jf.setVisible(false);
        ProfilePage p=new ProfilePage(this.u,jf);
        p.button();
    }
}

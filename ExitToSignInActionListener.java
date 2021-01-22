package test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitToSignInActionListener implements ActionListener {
    private JFrame f;

    public ExitToSignInActionListener(JFrame f) {
        this.f = f;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        f.setVisible(false);
        LoginScreen l=new LoginScreen();
        l.start();
    }
}

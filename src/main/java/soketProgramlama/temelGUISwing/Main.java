package soketProgramlama.temelGUISwing;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Deneme deneme=new Deneme();
                deneme.setVisible(true);
            }
        });

    }
}

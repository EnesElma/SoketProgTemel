package soketProgramlama.temelGUISwing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Deneme extends JFrame{
    private JPanel panel1;
    private JLabel isim_text;
    private JLabel soyisim_text;
    private JTextField text_isim;
    private JTextField text_soyisim;
    private JButton tikla;

    public Deneme() {
        add(panel1);
        setSize(500,400);
        setTitle("Deneme Uygulaması");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        tikla.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text="İsim: "+text_isim.getText()+"\n"
                        +"Soyisim: "+text_soyisim.getText();
                JOptionPane.showMessageDialog(panel1,text);
            }
        });
    }
}

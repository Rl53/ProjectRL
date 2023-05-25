import javax.swing.*;
import java.awt.*;


public class GUI {
    GameManager g;
    JFrame window;
    public JPanel background[] = new JPanel[10];
    public JLabel backgroundLabel[] = new JLabel[10];

    public JTextArea message;
    public GUI(GameManager g){
        this.g = g;
        createField();
        makeBG();
        window.setVisible(true);
    }

    public void createField() {
        window = new JFrame();
        window.setSize(900,700);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.gray);
        window.setLayout(null);

        message = new JTextArea("  TestT Imdwjdk");
        message.setBounds(50,35,800,150);
        message.setBackground(Color.darkGray);
        message.setForeground(Color.white);
        message.setEditable(false);
        message.setLineWrap(true);
        message.setWrapStyleWord(true);
        message.setFont(new Font("Times New Roman", Font.PLAIN,28));
        window.add(message);
    }

    public void makeBG(){

        background[1] = new JPanel();
        background[1].setBounds(50,185,800,350);
        background[1].setBackground(Color.orange);
        background[1].setLayout(null);
        window.add(background[1]);
        backgroundLabel[1] = new JLabel();
        backgroundLabel[1].setBounds(0,0,800,350);
    }
}





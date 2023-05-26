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
        makeScreen();
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

    public void makeBG(int num, String bgFile){

        background[num] = new JPanel();
        background[num].setBounds(50,185,800,350);
        background[num].setBackground(Color.black);
        background[num].setLayout(null);
        window.add(background[1]);
        backgroundLabel[1] = new JLabel();
        backgroundLabel[1].setBounds(0,0,800,350);

        ImageIcon bgI = new ImageIcon(getClass().getClassLoader().getResource(bgFile));
        backgroundLabel[1].setIcon(bgI);
    }

    public void createObj(int num, int x, int y, int width, int height, String fileName) {

        JLabel objLabel = new JLabel();
        objLabel.setBounds(x,y,width,height);


        ImageIcon objIcon = new ImageIcon(getClass().getClassLoader().getResource(fileName));
        objLabel.setIcon(objIcon);

        background[num].add(objLabel);
        background[num].add(backgroundLabel[1]);
    }

    public void makeScreen(){
        makeBG(1,"wood-3072434_1280.jpg");
        createObj(1,100,0,600,800,"bagi652r8p5rtheitedk0vmidk.png");
    }
}





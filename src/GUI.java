import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

// at 18:05 part 4 !!!!

public class GUI {
    GameManager g;
    JFrame window;
    public JPanel background[] = new JPanel[10];
    public JLabel backgroundLabel[] = new JLabel[10];

    public JTextArea message;
    public GUI(GameManager g){
        this.g = g;
        createField();
        makeScene();
        window.setVisible(true);
    }

    public void createField() {
        window = new JFrame();
        window.setSize(900,700);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.gray);
        window.setLayout(null);

        message = new JTextArea("  Test 0");
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
        window.add(background[num]);
        backgroundLabel[num] = new JLabel();
        backgroundLabel[num].setBounds(0,0,800,350);

        ImageIcon bgI = new ImageIcon(getClass().getClassLoader().getResource(bgFile));
        backgroundLabel[num].setIcon(bgI);
    }

    public void createObj(int num, int x, int y, int width, int height, String fileName,String command) {

        ImageIcon image = new ImageIcon(getClass().getClassLoader().getResource(fileName));
        JButton objButton = new JButton();
        objButton.setBounds(x,y,width,height);
        objButton.setBackground(null);
        objButton.setContentAreaFilled(false);
        objButton.setFocusPainted(false);
        objButton.setIcon(image);
        objButton.addActionListener(g.handler);
        objButton.setActionCommand(command);
        objButton.setBorderPainted(false);

        background[num].add(objButton);

    }

    public void addArrow(int num, int x, int y, int width, int height, String fileName, String command) {
        ImageIcon arrow = new ImageIcon(getClass().getClassLoader().getResource(fileName));
        JButton arrowButton = new JButton();
        arrowButton.setBounds(x,y,width,height);
        arrowButton.setBackground(null);
        arrowButton.setContentAreaFilled(false);
        arrowButton.setFocusPainted(false);
        arrowButton.setIcon(arrow);
        arrowButton.addActionListener(g.handler);
        arrowButton.setActionCommand(command);
        arrowButton.setBorderPainted(false);

        background[num].add(arrowButton);

    }

    public void makeScene(){
        makeBG(1,"wood-3072434_1280_40.jpg");
        createObj(1,450,20,350,400,"bagi652r8p5rtheitedk0vmidk_50.png","talkMore");
        addArrow(1,275,170,100,100,"clipart21503_1_15.png","goBG2");
        background[1].add(backgroundLabel[1]);

        makeBG(2, "cave-2604672_1280.jpg");
//        addArrow(1,-85,-200,800,800,"clipart21503_1_15.png","goBG1");
        background[2].add(backgroundLabel[2]);
    }


}






import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.*;

import static java.awt.Font.BOLD;

// a subclass of JPanel; this panel has been designed entirely in code (not using the UI designer)
public class AnimationPanel extends JPanel implements ActionListener, MouseListener, MouseMotionListener {
    private int movingMessageX;

    private boolean won;
    private boolean gameOver;

    private Upgrades upgrades;
    private Timer timer;

    private Rectangle button1;

    private Rectangle button2;

    private Rectangle button3;

    private boolean upgrading;

    private Room[] rooms;

    private Player player;

    private boolean selecting;

    private int currentRoom;

    private String message;

    private int action;





    // constructor
    public AnimationPanel() {
        // initialize variables
        makeButtons();

        message = "";
        won = false;
        gameOver = false;
        player = new Player();
        addMouseListener(this);
        selecting = false;
        upgrading = false;
        upgrades = new Upgrades(player);

        // initialize Timer object, responsible for the animation
        timer = new Timer(10, this); // set timer to have 10ms pulses; each pulse triggers an ActionEvent
        timer.start();

        rooms = new Room[10];
        for (int i = 0; i < 10; i++){
            rooms[i] = new Room(i +1);
        }
        currentRoom = 0;
        game();


    }
    public void makeButtons(){
        button1 = new Rectangle(225,775,200,75);
        button2 = new Rectangle(475,775,200,75);
        button3 = new Rectangle(725,775,200,75);


    }
    public void game() {
        write("You descend into a massive, scorched cavern, and encounter your first dragon. Press any button to begin");



//                combatTurn(rooms[i].getDragons(),i);




//            Upgrades.rewards(player);
//            introduction(i);


    }

    public void write(String actualwords){
        message = actualwords;
    }

    // important method that is inherited from JComponent and overridden;
    // this method automatically gets called by the graphics engine
    // when the engine it detects that the panel needs to be redrawn/updated
    @Override
    public void paint(Graphics gp) {
        super.paint(gp); // must do this!
        Graphics2D g2d = (Graphics2D) gp; // cast gp to a 2D graphics object so we can do more advanced stuff

        // draw blue message on screen
        g2d.setColor(Color.blue);
        Font myFont = new Font("Arial", BOLD, 14);
        g2d.setFont(myFont);
//         message = "Move orange square to gray! Dodge the red enemy!";
//        if (won) {
//            message = "YOU WIN!!!!";
//        }
//        if (gameOver) {
//            message = "YOU LOSE!!!";
//        }
         // write message at location: (x, 100)

        // draw gray target rectangle on the screen
        // since it doesn't move, we can use a simple fillRect rather than create a Rectangle object
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, 1200, 100);
        g2d.fillRect(0, 750, 1200, 150);// draw the top border
        g2d.setColor(Color.darkGray);
        g2d.fillRect(225,775,200,75);
        g2d.fillRect(475,775,200,75);
        g2d.fillRect(725,775,200,75);

        g2d.draw(button1);
        g2d.draw(button2);
        g2d.draw(button3);
        g2d.setColor(Color.LIGHT_GRAY);
        g2d.drawString(message, 50, 50);


    }


    // updates the x value for the string message by adding a small increment each time,
    // and resetting back to the left edge when it moves off the screen

    // updates the x and y values for the red rectangle by adding a small increment each time,
    // and resetting to edges when it goes off the screen


    // there is no easy way to automatically detect if two rectangles touch,
    // so we must write a method to do that



    // -------------- ActionListener interface method --------------
    // called for each Timer event (occurs every 10ms)
    // The timer + this method causes the animation to occur!
    @Override
    public void actionPerformed(ActionEvent e) {
        // only move the message and the red enemy if the game is not over

        repaint(); // forces the "paint" method above to be re-queued in the graphics engine
    }

    // -------------- MouseListener interface methods (5 required, only 2 used) --------------
    // called when the mouse button is pressed in
    @Override
    public void mousePressed(MouseEvent e) {
        if (selecting) {
            write("Please choose the dragon to target.");
            if (button1.contains(e.getPoint())) {
                write(rooms[currentRoom].getDragons()[0].takeDamage(player.getSword().dealDamage(rooms[currentRoom].getDragons()[0].getElement())));
                selecting = false;


            }
            //defend
            if (button2.contains(e.getPoint())&&(rooms[currentRoom].getDragons().length>1)) {
                write(rooms[currentRoom].getDragons()[1].takeDamage(player.getSword().dealDamage(rooms[currentRoom].getDragons()[1].getElement())));
                selecting = false;


            }
            //evade
            if (button3.contains(e.getPoint())&&(rooms[currentRoom].getDragons().length>2)) {
                write(rooms[currentRoom].getDragons()[2].takeDamage(player.getSword().dealDamage(rooms[currentRoom].getDragons()[2].getElement())));
                selecting = false;

            }
            //check for upgradin time
            if (rooms[currentRoom].dragonsDead()){
                write("You have slain all the dragons in the room and move to and find one of three rewards:");
                upgrading = true;

            }

        } else if (upgrading){
            System.out.println("kk");
            write(upgrades.rewards());

            if (button1.contains(e.getPoint())) {
                write(upgrades.doItem(upgrades.getOptions()[0]));


            }
            //defend
            if (button2.contains(e.getPoint())) {
                write(upgrades.doItem(upgrades.getOptions()[1]));

            }
            //evade
            if (button3.contains(e.getPoint())) {
                write(upgrades.doItem(upgrades.getOptions()[2]));


            }
            upgrading = false;
            currentRoom++;


        } else {
            write("Choose to attack, defend, or start evading.");
            //attack
            if (button1.contains(e.getPoint())) {
                action = 1;
                selecting = true;
                write("Please choose the dragon to target.");


            }
            //defend
            if (button2.contains(e.getPoint())) {
                write("You chose to defend");

            }
            //evade
            if (button3.contains(e.getPoint())) {
                write("You have begun to evade");


            }

        }

    }

    // called when the mouse button is released
    @Override
    public void mouseReleased(MouseEvent e) {
          // (335, 365) is center point of gray target rect

        // check if the orange rectangle contains the center point of the gray target, if so, the player
        // has won and the orange rectangle should "snap" around the gray square

    }
    @Override
    public void mouseClicked(MouseEvent e) { } // unused but needed for interface

    @Override
    public void mouseEntered(MouseEvent e) { } // unused but needed for interface

    @Override
    public void mouseExited(MouseEvent e) { } // unused but needed for interface

    // -------------- MouseMotionListener interface methods (2 required, only 1 used) --------------
    // called when user has clicked in and is dragging the mouse
    @Override
    public void mouseDragged(MouseEvent e) { }

    @Override
    public void mouseMoved(MouseEvent e) { } // unused but needed for interface
}
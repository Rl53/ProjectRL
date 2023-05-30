import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionHandler implements ActionListener {
    private static int text = 0;
    GameManager g;
    public ActionHandler(GameManager g) {
        this.g = g;
    }
    public void actionPerformed(ActionEvent e) {
        String dialouge = "Welcome, your objective is to fight";
        if (text == 1) {
            dialouge = "Text 222";
        }
        if (text == 2) {
            dialouge = "63818";
        }
        String myChoice = e.getActionCommand();
        switch (myChoice) {
            case "talkMore": g.ui.message.setText(dialouge);
            text++;
        }
    }
}

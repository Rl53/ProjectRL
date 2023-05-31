import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionHandler implements ActionListener {
    private static int text = 0;
    GameManager g;
    public ActionHandler(GameManager g) {
        this.g = g;
    }
    public void actionPerformed(ActionEvent e) {
        String dialogue = "Text 1";
        if (text % 1 == 0) {
            dialogue = "Text 2";
        }
        if (text % 2 == 0) {
            dialogue = "Text 3";
        }
        if (text % 3 == 0) {
            dialogue = "Text 4";
        }
        String myChoice = e.getActionCommand();
        switch (myChoice) {
            case "talkMore":
                g.ui.message.setText(dialogue);
                text++;
                break;
            case "goBG2":
                g.sceneChanger.showScreen2();
                break;


//            if (text < 4) {
               // text++;
            //}

        }


    }
}

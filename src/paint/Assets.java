package paint;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class Assets implements ActionListener {

    MainExe ven;

    public Assets(MainExe ven) {
        this.ven = ven;
    }

    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < ven.stringColors.length; i++) {
            if (ven.stringColors[i].equals(e.getActionCommand())) {
                ven.jlcolor.setForeground(ven.colors[i]);

                break;
            }
        }
    }
}

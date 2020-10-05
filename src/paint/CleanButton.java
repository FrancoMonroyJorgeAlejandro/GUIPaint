package paint;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class CleanButton implements ActionListener {

    DrawCanvas canbas;

    public CleanButton(DrawCanvas lienzo) {
        this.canbas = lienzo;
    }

    public void actionPerformed(ActionEvent ae) {
        canbas.repaint();
    }
}

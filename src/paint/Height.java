package paint;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JSlider;

public class Height implements ChangeListener {

    DrawCanvas canbas;

    public Height(DrawCanvas lienzo) {
        this.canbas = lienzo;
    }

    public void stateChanged(ChangeEvent e) {
        JSlider slider = (JSlider) e.getSource();
        canbas.height = slider.getValue();
    }
}
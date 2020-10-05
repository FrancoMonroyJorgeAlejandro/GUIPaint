package paint;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JSlider;

public class Width implements ChangeListener {

    DrawCanvas canbas;

    public Width(DrawCanvas lienzo) {
        this.canbas = lienzo;
    }

    public void stateChanged(ChangeEvent e) {
        JSlider slider = (JSlider) e.getSource();
        canbas.width = slider.getValue();
    }
}
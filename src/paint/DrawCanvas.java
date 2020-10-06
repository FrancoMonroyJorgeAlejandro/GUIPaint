package paint;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

class DrawCanvas extends Canvas implements MouseListener, MouseMotionListener {

    int mx;
    int my;
    int x2;
    int y2;
    int op;
    int height, width;
    String posX, posY;
    MainExe ven;
    private Color color = Color.black;

    public DrawCanvas(MainExe ven) {
        super();
        setBackground(Color.WHITE);
        addMouseListener(this);
        addMouseMotionListener(this);
        this.ven = ven;
        ven.clean.addActionListener(new CleanButton(this));
        ven.sliderHeight.addChangeListener(new Height(this));
        ven.sliderWidth.addChangeListener(new Width(this));
    }

    public void mouseClicked(MouseEvent e) {
        if (op == 2 || op == 3) {
            ven.sliderHeight.setEnabled(true);
            ven.sliderWidth.setEnabled(true);
        }
    }

    public void mousePressed(MouseEvent e) {

        mx = e.getX();
        my = e.getY();
        op = ven.i;
        Graphics g = getGraphics();
        color = ven.jlcolor.getForeground();
        g.setColor(color);
        if (op == 2) {
            g.drawRect(mx, my, width, height);
        } else if (op == 3) {

            g.drawOval(mx, my, width, height);
        }
    }

    public void mouseReleased(MouseEvent e) {
        op = ven.i;
        color = ven.jlcolor.getForeground();
        Graphics g = getGraphics();
        g.setColor(color);
        if (op == 1) {
            g.drawLine(mx, my, e.getX(), e.getY());
        }
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseDragged(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        op = ven.i;
        Graphics g = getGraphics();
        g.setColor(color);
        if (op == 4) {
            g.drawLine(mx, my, x, y);
            mx = x;
            my = y;
            g.dispose();
        }
        posX = "X: " + String.valueOf(e.getX());
        ven.xpos.setText(posX);
        posY = "Y: " + String.valueOf(e.getY());
        ven.ypos.setText(posY);

    }

    public void mouseMoved(MouseEvent e) {
        posX = "X: " + String.valueOf(e.getX());
        ven.xpos.setText(posX);
        posY = "Y: " + String.valueOf(e.getY());
        ven.ypos.setText(posY);

    }

    public void paint(Graphics g) {
        super.paint(g);
    }

    public void update(Graphics g) {

        super.update(g);
        paint(g);
    }

    public void nuevoColor() {
        this.color = ven.color;
    }
}


package paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;


public class MainExe extends JFrame{
    int i = -1;
    JPanel Draw, Buttons, Colors;
    JButton exit, clean, drawing;
    JComboBox option;
    JLabel jl, jlcolor, jlHeight, jlWidth, xpos, ypos, jlpos;
    JSlider sliderHeight, sliderWidth;
    String[] stringColors = null;
    Color[] colors = null;
    Container cp = getContentPane();
    Color color;
    DrawCanvas canvas;
    public MainExe(){
        super("Paint");
        this.setLayout(new BorderLayout());
        stringColors = new String[]{"Black", "Red", "Pink", "Blue", "Green"};
        colors = new Color[]{Color.BLACK, Color.RED, Color.PINK, Color.BLUE, Color.GREEN};
        Buttons = new JPanel();
        Colors = new JPanel();
        Colors.setLayout(new BoxLayout(Colors, BoxLayout.Y_AXIS));
        xpos = new JLabel("X:");
        ypos = new JLabel("Y:");
        jlpos = new JLabel("Cursor pos");
        jl = new JLabel("Draw");
        jlcolor = new JLabel("Color");
        jlcolor.setForeground(Color.BLACK);
        jlcolor.setFont(new Font("Arial", Font.BOLD, 15));
        jlHeight = new JLabel("Height");
        jlHeight.setAlignmentY(Component.CENTER_ALIGNMENT);
        jlHeight.setFont(new Font("Arial", Font.BOLD, 15));
        jlWidth = new JLabel("Width");
        jlWidth.setAlignmentY(Component.CENTER_ALIGNMENT);
        jlWidth.setFont(new Font("Arial", Font.BOLD, 15));

        int initValue = 1;
        int minimum = 1;
        int maximum = 700;
        sliderWidth = new JSlider(minimum, maximum, initValue);
        sliderWidth.setPaintTicks(true);
        sliderWidth.setBounds(250, 50, 150, 30);
        sliderHeight = new JSlider(minimum, maximum, initValue);
        sliderHeight.setPaintTicks(true);
        sliderHeight.setBounds(250, 50, 150, 30);

        JRadioButton rbColores[] = new JRadioButton[stringColors.length];
        ButtonGroup grup = new ButtonGroup();
        for (int i = 0; i < stringColors.length; i++) {
            rbColores[i] = new JRadioButton(stringColors[i]);
            rbColores[i].setActionCommand(stringColors[i]);
            rbColores[i].setAlignmentY(Component.CENTER_ALIGNMENT);
            grup.add(rbColores[i]);
            Colors.add(rbColores[i]);
			rbColores[i].addActionListener(new Assets(this));
        }
        exit = new JButton("Close");
        clean = new JButton("Clean");
        drawing = new JButton("Draw");

        option = new JComboBox();
        option.addItem("");
        option.addItem("Line");
        option.addItem("Square/Rectangle");
        option.addItem("Circle/Ellipse");
        option.addItem("Free Draw");
        option.setEnabled(false);
        cp.add(new DrawCanvas(this), BorderLayout.CENTER);
        cp.add(Colors, BorderLayout.EAST);
        cp.add(Buttons, BorderLayout.SOUTH);
        Buttons.add(drawing);
        Buttons.add(jl);
        Buttons.add(option);
        Buttons.add(clean);
        Buttons.add(exit);

        Colors.add(jlcolor);
        Colors.add(jlHeight);
        Colors.add(sliderHeight);
        Colors.add(jlWidth);
        Colors.add(sliderWidth);
        Colors.add(jlpos);
        Colors.add(xpos);
        Colors.add(ypos);
        sliderHeight.setEnabled(false);
        sliderWidth.setEnabled(false);
        Colors.setVisible(false);
        drawing.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                option.setEnabled(true);
                Colors.setVisible(true);
            }


            
        });
        option.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                JComboBox fuente = (JComboBox) ie.getSource();
                i = fuente.getSelectedIndex();
            }
        });
        exit.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        dispose();
                    }
        });
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setUndecorated(true);
        this.setResizable(false);
    }
    public static void main(String[] args) {
        new MainExe().setVisible(true);
    }
}

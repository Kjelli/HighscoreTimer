package studentapplication;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Time;

public class ClockPanel extends JPanel implements MouseListener{
    public ClockPanel(){
        setPreferredSize(new Dimension(200, 200));
        setBackground(Color.BLUE);
        addMouseListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        //g2d.translate(getHeight()/2, getWidth()/2);
        g2d.setFont(new Font("Arial", Font.BOLD, 20));
        g2d.setColor(Color.WHITE);
        //System.out.println(getWidth()/2);
        FontMetrics fm = g2d.getFontMetrics();
        long t = System.currentTimeMillis();

        int str = fm.stringWidth();
        g2d.drawString((t/3600000) + " : " + (t/60000) + " : " + (t/1000), getWidth()/2 - str/2, getHeight()/2);
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println(e.getX() + " : " + e.getY());
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

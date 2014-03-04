package studentapplication;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Time;

public class ClockPanel extends JPanel implements MouseListener{
    long t = 300000;
    public ClockPanel(){
        setPreferredSize(new Dimension(200, 200));
        setBackground(Color.BLUE);
        addMouseListener(this);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while(t >= 0){
                    Thread.currentThread().sleep(1000);
                        t -= 1000;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        //g2d.translate(getHeight()/2, getWidth()/2);
        g2d.setFont(new Font("Arial", Font.BOLD, 25));
        g2d.setColor(Color.WHITE);
        System.out.println(t);
        FontMetrics fm = g2d.getFontMetrics();
        //long t = System.currentTimeMillis();

        long min = (t/60000);
        long sec = (t % 60000)/1000 ;
        int str = fm.stringWidth(min + " : " + sec);
        g2d.drawString(min + " : " + sec, getWidth()/2 - str/2, getHeight()/2);
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

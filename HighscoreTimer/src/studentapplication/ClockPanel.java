package studentapplication;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Time;

public class ClockPanel extends JPanel{
    long t = 300000;
    Thread th;
    public ClockPanel(){
        setPreferredSize(new Dimension(200, 200));
        setBackground(Color.BLUE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        //g2d.translate(getHeight()/2, getWidth()/2);
        g2d.setFont(new Font("Arial", Font.BOLD, 25));
        g2d.setColor(Color.WHITE);
        //System.out.println(t);
        FontMetrics fm = g2d.getFontMetrics();
        //long t = System.currentTimeMillis();

        long min = (t/60000);
        long sec = (t % 60000)/1000 ;
        int str = fm.stringWidth(min + " : " + sec);
        g2d.drawString(min + " : " + sec, getWidth()/2 - str/2, getHeight()/2);
        repaint();
    }

    public void startClockMin(int min){
        if(th != null){
            th.stop();
        }
        t = 0;
        t = min*60*1000;
        th = new Thread(new Runner());
        th.start();
    }

    public void startClockSec(int sec){
        if(th != null){
            th.stop();
        }
        t = 0;
        t = sec*1000;
        th = new Thread(new Runner());
        th.start();
    }

    class Runner implements Runnable{

        @Override
        public void run() {
            try {
                while(t > 0){
                    Thread.currentThread().sleep(1000);
                    t -= 1000;
                }
                Toolkit.getDefaultToolkit().beep();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

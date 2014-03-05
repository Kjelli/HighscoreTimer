package studentapplication;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class ClockPanel extends JPanel {
	long t = 300000;
	Thread th;

	private Font font = new Font("Arial", Font.BOLD, 30);
	private Color bgColor = new Color(255, 255, 255);
	private Color fgColor = new Color(100, 100, 255);

	public ClockPanel() {
		setPreferredSize(new Dimension(200, 200));
		setBackground(bgColor);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		// g2d.translate(getHeight()/2, getWidth()/2);
		g2d.setFont(font);
		g2d.setColor(fgColor);
		// System.out.println(t);
		FontMetrics fm = g2d.getFontMetrics();
		// long t = System.currentTimeMillis();

		long min = (t / 60000);
		String minstr = (min > 9 ? String.valueOf(min) : ("0" + min));
		long sec = (t % 60000) / 1000;
		String secstr = (sec > 9 ? String.valueOf(sec) : ("0" + sec));
		int str = fm.stringWidth(minstr + " : " + secstr);
		g2d.drawString(minstr + " : " + secstr, getWidth() / 2 - str / 2,
				getHeight() / 2);
		repaint();
	}

	public void startClockMin(int min) {
		if (th != null) {
			th.stop();
		}
		t = 0;
		t = min * 60 * 1000;
		th = new Thread(new Runner());
		th.start();
	}

	public void startClockSec(int sec) {
		if (th != null) {
			th.stop();
		}
		t = 0;
		t = sec * 1000;
		th = new Thread(new Runner());
		th.start();
	}

	class Runner implements Runnable {

		@Override
		public void run() {
			try {
				while (t > 0) {
					if (t < 10000)
						Toolkit.getDefaultToolkit().beep();
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

package studentapplication;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class StudentApplication extends JFrame {

	HighScorePanel highscore;
	ClockPanel clockPanel;
	JTextField textfield;

	public StudentApplication() {

		highscore = new HighScorePanel();
		clockPanel = new ClockPanel();
		textfield = new JTextField("...");

		setLayout(new BorderLayout());

		add(clockPanel, BorderLayout.EAST);
		add(highscore, BorderLayout.WEST);
		add(textfield, BorderLayout.SOUTH);

		setSize(640, 480);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new StudentApplication();
	}
}

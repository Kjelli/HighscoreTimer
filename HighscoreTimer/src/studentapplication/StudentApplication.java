package studentapplication;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class StudentApplication extends JFrame {

	HighScorePanel highscore;
	JTextField textfield;

	public StudentApplication() {

		highscore = new HighScorePanel();
		textfield = new JTextField("...");

		setLayout(new BorderLayout());

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

package studentapplication;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class StudentApplication extends JFrame {

	HighScorePanel highscore;
	ClockPanel clockPanel;
	JTextField input;

	public StudentApplication() {

		highscore = new HighScorePanel();

		clockPanel = new ClockPanel();

		input = new JTextField();
		input.addActionListener(new InputListener());

		setLayout(new BorderLayout());

		add(clockPanel, BorderLayout.EAST);
		add(highscore, BorderLayout.WEST);
		add(input, BorderLayout.SOUTH);

		setSize(640, 480);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new StudentApplication();
	}

	class InputListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String line = input.getText().trim().toUpperCase();
			String[] arguments = line.split("[ ]+");
			int antall_argumenter = arguments.length;

			// Kommandoer

			switch (arguments[0]) {
			case "-":
				if (antall_argumenter > 1)
					for (int i = 1; i < antall_argumenter; i++)
						highscore.updateContestant(arguments[i], -1);
				break;
			case "+":
				if (antall_argumenter > 1)
					for (int i = 1; i < antall_argumenter; i++)
						highscore.updateContestant(arguments[i], 1);
				break;
			case "X":
				if (antall_argumenter == 2 && arguments[1].equals("*"))
					highscore.clear();

				else if (antall_argumenter > 1)
					for (int i = 1; i < antall_argumenter; i++)
						highscore.removeContestant(arguments[i]);
				break;
			case "CLOCK":
				if (antall_argumenter == 2) {
					try {
						int minutter = Integer.parseInt(arguments[1]);
						if (minutter > 0 && minutter < 3600) {
							// clockpanel.startClock(minutter);
						} else
							JOptionPane.showConfirmDialog(null, arguments[1]
									+ " minutter? wot.", "", -1, 0);
					} catch (NumberFormatException nfe) {
						JOptionPane.showConfirmDialog(null, arguments[1]
								+ " minutter? wot.", "", -1, 0);
					}
					break;
				}

			default:
				JOptionPane.showConfirmDialog(null, "Dafuq?", "Dafuq", -1, 0);
			}

			input.setText("");
		}
	}
}

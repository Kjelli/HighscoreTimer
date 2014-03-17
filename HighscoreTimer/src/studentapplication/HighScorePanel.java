package studentapplication;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JPanel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class HighScorePanel extends JPanel {

	private ArrayList<Contestant> contestantList = new ArrayList<Contestant>();

	private Font font = new Font("Arial", Font.BOLD, 30);
	private Color bgColor = new Color(130, 130, 255);
	private Color fgColor = new Color(255, 255, 255);

	JTextArea highscore;

	public HighScorePanel() {
		setFont(font);
		setBackground(bgColor);

		highscore = new JTextArea();

		highscore.setFont(font);
		highscore.setEditable(false);
		highscore.setFocusable(false);
		highscore.setBackground(bgColor);
		highscore.setForeground(fgColor);
		highscore.setAlignmentX(LEFT_ALIGNMENT);

		setLayout(new BorderLayout());

		add(highscore, BorderLayout.WEST);

		/*
		 * TEST: addContestant("FS"); addContestant("KA"); addContestant("FS");
		 * addContestant("PF"); addContestant("PF"); addContestant("PF");
		 */
	}

	public void addContestant(String name) {
		contestantList.add(new Contestant(name));
		updateContestantList();
	}

	public void updateContestantList() {
		highscore.setText("");
		StringBuilder sb = new StringBuilder("");

		Collections.sort(contestantList);

		for (Contestant contestant : contestantList) {
			sb.append(contestant.getName() + "\t" + contestant.getPoints()
					+ "\n");
		}
		highscore.setText(sb.toString());
		highscore.repaint();
	}

	public boolean contestantExists(String name) {
		return !(findContestant(name) == null);
	}

	public void updateContestant(String name, int score) {
		if (contestantExists(name))
			updateContestant(findContestant(name), score);
		else
			addContestant(name);

	}

	public void updateContestant(Contestant contestant, int score) {
		contestant.score(score);
		updateContestantList();
	}

	public Contestant findContestant(String name) {
		for (Contestant contestant : contestantList) {
			if (contestant.getName().equals(name))
				return contestant;
		}
		return null;
	}

	public void removeContestant(String name) {
		if (contestantExists(name))
			removeContestant(findContestant(name));
	}

	public void removeContestant(Contestant contestant) {
		contestantList.remove(contestant);
		updateContestantList();
	}

	public void setFont(Font font) {
		this.font = font;
	}

	public void clear() {
		contestantList.clear();
		updateContestantList();
	}

	public void announceWinners() {
		for (int i = 0; i < 20; i++) {
			Collections.shuffle(contestantList);
		}

		while (contestantList.size() > 3) {
			contestantList.remove(contestantList.size() - 1);
		}
		updateContestantList();
	}

}

package studentapplication;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JPanel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class HighScorePanel extends JPanel {

	private ArrayList<Contestant> contestantList = new ArrayList<Contestant>();

	private Font font = new Font("Arial", Font.BOLD, 30);
	private Color bgColor = new Color(230, 230, 255);
	private Color fgColor = new Color(0, 0, 0);
	private Dimension panelSize = new Dimension(320, 460);

	JTextArea highscore;

	public HighScorePanel() {
		setFont(font);
		setMinimumSize(panelSize);
		setPreferredSize(panelSize);
		setMaximumSize(panelSize);

		highscore = new JTextArea();

		highscore.setFont(font);
		highscore.setEditable(false);
		highscore.setFocusable(false);
		highscore.setMinimumSize(panelSize);
		highscore.setPreferredSize(panelSize);
		highscore.setMaximumSize(panelSize);
		highscore.setBackground(bgColor);
		highscore.setForeground(fgColor);
		highscore.setAlignmentX(LEFT_ALIGNMENT);

		setLayout(new BorderLayout());

		add(highscore, BorderLayout.NORTH);

		/*
		 * TEST: addContestant("FS"); addContestant("KA"); addContestant("FS");
		 * addContestant("PF"); addContestant("PF"); addContestant("PF");
		 */
	}

	public void addContestant(String name) {
		contestantList.add(new Contestant(name));
		updateContestantList();
	}

	private void updateContestantList() {
		highscore.setText("");
		StringBuilder sb = new StringBuilder("");

		Collections.sort(contestantList);

		for (Contestant contestant : contestantList) {
			sb.append(contestant.getName() + "\t" + contestant.getPoints()
					+ "\n");
		}
		highscore.setText(sb.toString());
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

}

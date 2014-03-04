package studentapplication;

public class Contestant implements Comparable<Contestant> {

	private final String name;
	private int points;

	public Contestant(String name) {
		this(name, 1);
	}

	public Contestant(String name, int points) {
		this.name = name;
		this.points = points;
	}

	public int getPoints() {
		return points;
	}

	public String getName() {
		return name;
	}

	public void score() {
		points += 1;
	}

	@Override
	public int compareTo(Contestant that) {
		return -Integer.compare(this.points, that.points);
	}

}

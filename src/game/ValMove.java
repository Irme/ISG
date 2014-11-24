package game;

public class ValMove {

	/**
	 * @param args
	 */
	private int [] move = new int [4];
	private int score = -10;
	public int [] getMove() {
		return move;
	}
	public void setMoveX(int move) {
		this.move[0] = move;
	}
	public void setMoveY(int move) {
		this.move[1] = move;
	}
	public void setNewMoveX(int move) {
		this.move[2] = move;
	}
	public void setNewMoveY(int move) {
		this.move[3] = move;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}

}

package game;

import java.io.IOException;

public class tester {
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws IOException {
		int player = 1;
		GameFrame frame = new GameFrame();
		Board board = new Board();
		//while(board.isFinished() == 0){
		System.out.println("Player " + player + " is playing");
		board.printBoard();
		player = (player+1)%2;
		//}
		frame.repaint();

		// TODO Auto-generated method stub

	}

}

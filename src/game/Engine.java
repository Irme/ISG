package game;

import java.io.IOException;
import java.util.Scanner;

public class Engine {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public void engine() throws IOException, InterruptedException{
		Scanner in = new Scanner(System.in);
		GameFrame frame = new GameFrame();
		frame.setAlwaysOnTop( true );
		Board board = new Board();
		boolean validselec = false;

		


		while(board.isFinished() == 0){
			boolean validmove = false;

			int xtemp = 0;
			int ytemp = 0;
			while(!validmove){
				System.out.println("Player " + Board.player + " is playing");
				System.out.println("Please select a piece to move:");
				

					xtemp = in.nextInt();
					ytemp = in.nextInt();


				
				if (Board.board[xtemp][ytemp] == Board.player)
					validmove =true;
			}
			Board.Move(xtemp, ytemp);


			System.out.println("Possible moves are: ");
			for(int i = 0; i < Board.moves.size(); i = i+2){
				System.out.println(Board.moves.get(i) + " " +Board.moves.get(i+1));
			}
			System.out.println("Please select one");
			
			int xnew = 0;
			int ynew = 0;
			while(!validselec){
				xnew = in.nextInt();
				ynew = in.nextInt();
				for(int i = 0; i < Board.moves.size(); i = i +2){
					if(Board.moves.get(i) == xnew && Board.moves.get(i+1) == ynew){
						Board.Moving(xtemp, ytemp, xnew, ynew);
						validselec = true;
					}
				}
				//System.out.println("Invalid move, please try again.");
				
					
				
			} 
			validselec= false;
			//Board.Moving(xtemp, ytemp, xnew, ynew);
			board.printBoard();
			Board.player = (Board.player%2+1);
			frame.repaint();
		}
		System.out.println("Game over");
		in.close();
		// TODO Auto-generated method stub
		
	}

}

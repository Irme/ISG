package game;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.sun.swing.internal.plaf.metal.resources.metal;

public class Engine {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	Minimax m = new Minimax();
	AlphaBeta ab = new AlphaBeta();
	boolean Player1Human;
	boolean Player2Human;

	public void engine() throws IOException, InterruptedException{
		Scanner in = new Scanner(System.in);
		System.out.println("Player 1 type: 0 = AI, 1 = human.");
		int t = in.nextInt();
		if (t == 0){
			Player1Human = false;
		} else {
			Player1Human = true;
		}
		System.out.println("Player 2 type: 0 = AI, 1 = human.");
		int temp2 = in.nextInt();
		if (temp2 == 0){
			Player2Human = false;
		} else {
			Player2Human = true;
		}
		GameFrame frame = new GameFrame();
		frame.setAlwaysOnTop( true );
		Board board = new Board();
		boolean validselec = false;




		while(board.isFinished(Board.board) == 0){
			boolean validmove = false;
			int xtemp = 0;
			int ytemp = 0;
			if(Board.player == 1){
				if(Player1Human){
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
					} 
					validselec= false;
					validmove = false;
				} else {
					int [] temp = new int [4];
					int [][] state = board.clone(Board.board);
					temp = ab.AlphaBetaSearch(true, state, Board.player, 5);
					System.out.println("Moving from " + temp[0]  +","  +temp[1] + " to " + temp[2] + "," + temp[3]);
					Board.Moving(temp[0], temp[1], temp[2], temp[3]);
				}

			} else {
				if(Player2Human){
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
					} 
					validselec= false;
					validmove = false;
				}else {
					int [] temp = new int [4];
					int [][] state = board.clone(Board.board);
					
					temp = m.MinimaxDecision(true,state, Board.player, 4);
					System.out.println("Moving from " + temp[0]  +","  +temp[1] + " to " + temp[2] + "," + temp[3]);
					Board.Moving(temp[0], temp[1], temp[2], temp[3]);
				}
			}

			Board.printBoard(Board.board);
			Board.player = (Board.player%2+1);
			frame.repaint();
		}
		System.out.println("Game over");
		in.close();
		// TODO Auto-generated method stub

	}

}

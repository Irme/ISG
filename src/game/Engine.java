package game;

import game.Tree.Node;

import java.io.IOException;
import java.util.ArrayList;
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
		Minimax mini = new Minimax();




		while(board.isFinished() == 0){
			boolean validmove = false;
			int xtemp = 0;
			int ytemp = 0;
			if(Board.player == 1){
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
			} else {
				//ArrayList<Integer> temp3 = Board.getAllMoves(Board.board);
				//System.out.println(temp3.size());
				int [] temp = new int [4];
				Node<Integer> root = new Node<Integer>();
				int [][] state = board.clone(Board.board);
				root.setState(state);
				System.out.println("Minimax");
				ValMove temp2 = mini.minimax(false, root, 1);
				temp = temp2.getMove();
				System.out.println("Moving from " + temp[0]  +","  +temp[1] + " to " + temp[2] + "," + temp[3]);
				Board.Moving(temp[0], temp[1], temp[2], temp[3]);
			}
			validselec= false;
			//Board.Moving(xtemp, ytemp, xnew, ynew);
			Board.printBoard(Board.board);
			Board.player = (Board.player%2+1);
			frame.repaint();
		}
		System.out.println("Game over");
		in.close();
		// TODO Auto-generated method stub

	}

}

package game;

import java.util.ArrayList;


public class Minimax {

	Board b = new Board();



	public int MaxValue(int state [][], int player, int depth){
		int score = Integer.MIN_VALUE;
		if(depth == 0){
			return evalFunc(state, player);
		}
		else{
			ArrayList<Integer> moves = new ArrayList<Integer>();
			moves = b.getAllMoves(state, player);
			for(int i = 0; i < moves.size(); i = i + 4){
				score = Math.max(score, MinValue(Board.Moving2(state, moves.get(i), moves.get(i+1), moves.get(i+2), moves.get(i+3)), player%2+1, depth-1));
			}
			return score;
		}

	}


	public int MinValue(int [][] state, int player, int depth){
		int score = Integer.MAX_VALUE;
		if (depth == 0){
			return evalFunc(state, player);
		}
		else{
			ArrayList<Integer> moves = new ArrayList<Integer>();
			moves = b.getAllMoves(state, player);
			for(int i = 0; i < moves.size(); i = i + 4){
				score = Math.min(score, MaxValue(Board.Moving2(state, moves.get(i), moves.get(i+1), moves.get(i+2), moves.get(i+3)), player%2+1, depth-1));
			}
			return score;
		}

	}



	private int evalFunc(int [][] board, int pl){
		//Count pieces
		int countOwn = 0;
		int countOp = 0;
		int eval = 0;
		//		ArrayList<Integer> m = new ArrayList<Integer>();
		//		m = b.getAllMoves(board, pl);//Get all the moves for the current player
		//		for(int k = 0; k < m.size(); k = k + 4){
		//			if(board[m.get(k+2)][m.get(k+3)] == pl%2+1 ){
		//				System.out.println("Possible capture");
		//				//Possible capture
		//				eval = eval + 4;
		//			}
		//		}
		if(b.isFinished(board)  == pl)
			eval = eval + 100;
		for (int i = 0; i< 8 ; i ++){
			for(int j = 0; j < 8; j++){
				if(board[i][j] == pl){
					countOwn++;
				}
				if (board[i][j] == (pl%2+1)){

					countOp++;
				}

			}

		}
		eval = eval + countOwn + 2*(16-countOp);
		//Count possible moves

		//Count opponent's possible moves


		//System.out.println("Current f(state): " + eval);
		return eval;
	}

	public int[] MinimaxDecision(boolean max,int [][] state, int currentPlayer, int depth) {
		int [] nextMove = new int [4];
		if (max){
			int score = Integer.MIN_VALUE;
			ArrayList<Integer> moves = new ArrayList<Integer>();
			moves = b.getAllMoves(state, currentPlayer);
			for(int i = 0; i < moves.size(); i = i + 4){
				int value = MinValue(Board.Moving2(state, moves.get(i), moves.get(i+1), moves.get(i+2), moves.get(i+3)), currentPlayer%2+1, depth-1);
				if( value > score){
					score = value;
					nextMove [0] = moves.get(i);
					nextMove [1] = moves.get(i+1);
					nextMove [2] = moves.get(i+2);
					nextMove [3] = moves.get(i+3);
				}
			}
		} else {
			int score = Integer.MAX_VALUE;
			ArrayList<Integer> moves = new ArrayList<Integer>();
			moves = b.getAllMoves(state, currentPlayer);
			for(int i = 0; i < moves.size(); i = i + 4){
				int value = MaxValue(Board.Moving2(state, moves.get(i), moves.get(i+1), moves.get(i+2), moves.get(i+3)), currentPlayer%2+1, depth-1);
				if( value < score){
					score = value;
					nextMove [0] = moves.get(i);
					nextMove [1] = moves.get(i+1);
					nextMove [2] = moves.get(i+2);
					nextMove [3] = moves.get(i+3);
				}			
			}
		}
		return nextMove;

	}




}


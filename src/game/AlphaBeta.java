package game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;



public class AlphaBeta {

	Board b = new Board();
	EvaluationFunction eval = new EvaluationFunction();
	Map<String, Integer> statesmap = new HashMap<>();
	boolean win = false;

	public int ABMaxValue(int board [][], int alpha, int beta, int player, int depth){
		int score = Integer.MIN_VALUE;
		if (Board.isFinished(board) == player){
			if(player == Board.player){
				win = true;
				return eval.evaluate(board, player)-depth;
			}
			return eval.evaluate(board, player)+depth;
		} else if (Board.isFinished(board) == player%2+1){
			if(player != Board.player){
				win = true;
				return eval.evaluate(board, player)-depth;
			}
			return eval.evaluate(board, player)+depth;
		} else if (depth == 0){
			return eval.evaluate(board, player);
		}
		else{
			ArrayList<Integer> moves = new ArrayList<Integer>();
			moves = b.getAllMoves(board, player);
			moves = b.moveOrdering(board, player, moves);
			for(int i = 0; i < moves.size(); i = i + 4){
				int [][] newstate = Board.Moving2(board, moves.get(i), moves.get(i+1), moves.get(i+2), moves.get(i+3));
				score = Math.max(score, ABMinValue(newstate,alpha, beta, player%2+1, depth-1));
				if(score >= beta){
					return score;
				}
				alpha = Math.max(alpha, score);
			}

			return score;
		}

	}


	public int ABMinValue(int [][] board,int alpha, int beta, int player, int depth){
		int score = Integer.MAX_VALUE;
		if (Board.isFinished(board) == player){
			if(player == Board.player){
				win = true;
				return eval.evaluate(board, player)-depth;
			}
			return eval.evaluate(board, player)+depth;
		} else if (Board.isFinished(board) == player%2+1){
			if(player != Board.player){
				win = true;
				return eval.evaluate(board, player)-depth;
			}
			return eval.evaluate(board, player)+depth;
		} else if (depth == 0){
			return eval.evaluate(board, player);
		}
		else{
			ArrayList<Integer> moves = new ArrayList<Integer>();
			moves = b.getAllMoves(board, player);
			moves = b.moveOrdering(board, player, moves);
			for(int i = 0; i < moves.size(); i = i + 4){
				int [][] newstate = Board.Moving2(board, moves.get(i), moves.get(i+1), moves.get(i+2), moves.get(i+3));
				score = Math.min(score, ABMaxValue(newstate,alpha, beta, player%2+1, depth-1));
				if(score <= alpha){
					return score;
				}
				beta = Math.min(beta, score);
			}
			return score;

		}

	}





	public int[] AlphaBetaSearch(boolean max,int board [][], int currentPlayer, int depth) {
		int [] nextMove = new int [4];
		//for(int k = 1; k <= depth; k++){
			win = false;
			//System.out.println("Currenlty searching at ply " + k);
			int alpha = Integer.MIN_VALUE;
			int beta = Integer.MAX_VALUE;
			if (max){
				int score = Integer.MIN_VALUE;
				ArrayList<Integer> moves = new ArrayList<Integer>();
				moves = b.getAllMoves(board, currentPlayer);
				moves = b.moveOrdering(board, currentPlayer, moves);
				for(int i = 0; i < moves.size(); i = i + 4){
					int value;
					int [][] newstate = Board.Moving2(board, moves.get(i), moves.get(i+1), moves.get(i+2), moves.get(i+3));
					value = ABMinValue(newstate,alpha, beta, currentPlayer%2+1, depth-1);
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
				moves = b.getAllMoves(board, currentPlayer);
				moves = b.moveOrdering(board, currentPlayer, moves);
				for(int i = 0; i < moves.size(); i = i + 4){
					int value;
					int [][] newstate = Board.Moving2(board, moves.get(i), moves.get(i+1), moves.get(i+2), moves.get(i+3));
					value = ABMaxValue(newstate,alpha,beta, currentPlayer%2+1, depth-1);
					if( value < score){
						score = value;
						nextMove [0] = moves.get(i);
						nextMove [1] = moves.get(i+1);
						nextMove [2] = moves.get(i+2);
						nextMove [3] = moves.get(i+3);
					}			
				}
			}
		
		//if(win){
			//break;
	//	}
		//System.out.println("Moving from " +nextMove[0]+ "," +nextMove[1]+ " to " +nextMove[2]+ "," + +nextMove[3] );
		
		//}
		return nextMove;
	}



	public String toString(int b [][]){
		String s = new String();
		for(int i = 0; i < b.length; i++){
			for(int j = 0; j < b.length; j++){
				int t= b[i][j];
				String temp = Integer.toString(t);
				s = s + temp;
			}
		}
		return s;
	}

}


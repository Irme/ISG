package game;

import java.util.ArrayList;


public class Minimax {

	Board b = new Board();
	EvaluationFunction eval = new EvaluationFunction();


	public int MaxValue(int state [][], int player, int depth){
		int score = Integer.MIN_VALUE;
		if(depth == 0){
			return eval.evaluate(state, player);
		} else if (b.isFinished(state) == player){
			return eval.evaluate(state, player);
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
			return eval.evaluate(state, player);
		} else if (b.isFinished(state) == player){
			return eval.evaluate(state, player);
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


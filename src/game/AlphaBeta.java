package game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;



public class AlphaBeta {

	Board b = new Board();
	EvaluationFunction eval = new EvaluationFunction();
	Map<int [][], Integer> statesmap = new HashMap<>();

	public int ABMaxValue(int state [][], int alpha, int beta, int player, int depth){
		int score = Integer.MIN_VALUE;
		if(depth == 0){
			return eval.evaluate(state, player);
		} else if (b.isFinished(state) == player){
			return eval.evaluate(state, player);
		}
		else{
			ArrayList<Integer> moves = new ArrayList<Integer>();
			moves = b.moveOrdering(state, player, moves);
			moves = b.getAllMoves(state, player);
			for(int i = 0; i < moves.size(); i = i + 4){
				int [][] newstate = Board.Moving2(state, moves.get(i), moves.get(i+1), moves.get(i+2), moves.get(i+3));
				if(statesmap.containsKey(newstate)){
					score = statesmap.get(newstate);
				}else{
					score = Math.max(score, ABMinValue(newstate,alpha, beta, player%2+1, depth-1));
					statesmap.put(newstate,score);
				}
				//score = Math.max(score, ABMinValue(newstate,alpha, beta, player%2+1, depth-1));
				if(score >= beta){
					//System.out.println("Cut off");
					return score;
				}
				alpha = Math.max(alpha, score);
			}
			
			return score;
		}

	}


	public int ABMinValue(int [][] state,int alpha, int beta, int player, int depth){
		int score = Integer.MAX_VALUE;
		if (depth == 0){
			return eval.evaluate(state, player);
		} else if (b.isFinished(state) == player){
			return eval.evaluate(state, player);
		}
		else{
			ArrayList<Integer> moves = new ArrayList<Integer>();
			moves = b.moveOrdering(state, player, moves);
			moves = b.getAllMoves(state, player);
			for(int i = 0; i < moves.size(); i = i + 4){
				int [][] newstate = Board.Moving2(state, moves.get(i), moves.get(i+1), moves.get(i+2), moves.get(i+3));
				if(statesmap.containsKey(newstate)){
					score = statesmap.get(newstate);
				}else{
					score = Math.min(score, ABMaxValue(newstate,alpha, beta, player%2+1, depth-1));
					statesmap.put(newstate, score);
				}
				//score = Math.min(score, ABMaxValue(newstate,alpha, beta, player%2+1, depth-1));
				if(score <= alpha){
					//System.out.println("Cut-off");
					return score;
				}
				beta = Math.min(beta, score);
			}
			return score;

		}

	}





	public int[] AlphaBetaSearch(boolean max,int [][] state, int currentPlayer, int depth) {
		int alpha = Integer.MIN_VALUE;
		int beta = Integer.MAX_VALUE;
		int [] nextMove = new int [4];
		if (max){
			int score = Integer.MIN_VALUE;
			ArrayList<Integer> moves = new ArrayList<Integer>();
			moves = b.moveOrdering(state, currentPlayer, moves);
			moves = b.getAllMoves(state, currentPlayer);
			for(int i = 0; i < moves.size(); i = i + 4){
				int value;
				int [][] newstate = Board.Moving2(state, moves.get(i), moves.get(i+1), moves.get(i+2), moves.get(i+3));
				if(statesmap.containsKey(newstate)){
					value = statesmap.get(newstate);
				} else {
					value = ABMinValue(newstate,alpha, beta, currentPlayer%2+1, depth-1);
					statesmap.put(newstate, value);
				}
				//value = ABMinValue(newstate,alpha, beta, currentPlayer%2+1, depth-1);

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
			moves = b.moveOrdering(state, currentPlayer, moves);
			for(int i = 0; i < moves.size(); i = i + 4){
				int value = ABMaxValue(Board.Moving2(state, moves.get(i), moves.get(i+1), moves.get(i+2), moves.get(i+3)),alpha,beta, currentPlayer%2+1, depth-1);
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


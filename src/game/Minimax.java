package game;

import game.Tree.Node;

public class Minimax {

	private int bestValue;
	
	public ValMove minimax(boolean max, Node<Integer> node, int depth){
		if (depth == 0){
				System.out.println("Depth reached");
				node.setScore(evalFunc(node.getState()));
				return node.getValmov();
		}
		//System.out.println(node.getData());
		if (max){ //Maximising player
			System.out.println("Max");
			if(node.getScore() == -10){
				bestValue = Integer.MIN_VALUE;
				node.setMoves(Board.getAllMoves(node.getState()));
				for(int i = 0; i < node.getMoves().size(); i = i + 4){
					System.out.println("One ply deeper");
					int [][] bo = Board.Moving2(node.getState(), node.getMoves().get(i), node.getMoves().get(i+1), node.getMoves().get(i+2), node.getMoves().get(i+3));
					Node n = new Node<Integer>(bo);
					ValMove temp = new ValMove();
					bestValue = Math.max(bestValue,minimax(false,n, depth-1).getScore());
					temp.setScore(bestValue);
					temp.setMoveX(node.getMoves().get(i));
					temp.setMoveY(node.getMoves().get(i+1));
					temp.setNewMoveX(node.getMoves().get(i+2));
					temp.setNewMoveY(node.getMoves().get(i+3));
				}
				node.setScore(bestValue);
				return node.getValmov();
			}
			else {
				return node.getValmov();
			}
		}else{ //minimising player
			//System.out.println("Min");
			if(node.getScore() == -10){
			//	System.out.println("Plied here");
				node.setMoves(Board.getAllMoves(node.getState()));
				System.out.println(node.getMoves().size());
				bestValue = Integer.MIN_VALUE;
				for(int i = 0; i < node.getMoves().size(); i = i + 4){
					System.out.println("One ply deeper for min");
					
					int [][] bo = Board.Moving2(node.getState(), node.getMoves().get(i), node.getMoves().get(i+1), node.getMoves().get(i+2), node.getMoves().get(i+3));
					ValMove temp = new ValMove();
					Node n = new Node<Integer>(bo);
					bestValue = Math.min(bestValue,minimax(true,n, depth-1).getScore());
					temp.setScore(bestValue);
					temp.setMoveX(node.getMoves().get(i));
					temp.setMoveY(node.getMoves().get(i+1));
					temp.setNewMoveX(node.getMoves().get(i+2));
					temp.setNewMoveY(node.getMoves().get(i+3));
				}
				node.setScore(bestValue);
				return node.getValmov();
			}
			else {
				return node.getValmov();
			}

		}

	}

	private int evalFunc(int [][] board){
		//Count pieces
		int countOwn = 0;
		int countOp = 0;
		int eval = 0;
		
		for (int i = 0; i< 8 ; i ++){
			for(int j = 0; j < 8; j++){
				if(board[i][j] == Board.player){
					countOwn++;
				}
				if (board[i][j] == (Board.player%2+1)){
					countOp++;
				}
				
			}
		
		}
		eval = eval + countOwn*2 + (16-countOp);
		//Count possible moves
		
		//Count opponent's possible moves
					
		
		
		return eval;
	}
}


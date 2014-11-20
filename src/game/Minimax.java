package game;

import game.Tree.Node;

public class Minimax {
	
	
	private int [][] miniboard; 
	private double bestValue;
	public double minimax(boolean max, Node<Double> node, int depth){
		miniboard = Board.board;
		if (depth == 0){
				return evalFunc(node.getData());
		}
		//System.out.println(node.getData());
		if (max){ //Maximising player
			if(node.getData() == null){
				bestValue = Double.MIN_VALUE;
				for(Node n : node.getChildren()){
					//System.out.println("One ply deeper");
					bestValue = Math.max(bestValue,minimax(false,n));
				}
				node.setData(bestValue);
				return bestValue;
			}
			else {
				return node.getData();
			}
		}else{ //minimising player
			if(node.getData() == null){
				bestValue = Double.MAX_VALUE;
				for(Node n : node.getChildren()){
					//System.out.println("One ply deeper");
					bestValue = Math.min(bestValue, minimax(true,n));
				}
				node.setData(bestValue);
				return bestValue;
			}
			else {
				return node.getData();
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


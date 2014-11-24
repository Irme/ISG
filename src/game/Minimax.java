package game;

import game.Tree.Node;

public class Minimax {

	private int bestValue;
	Board b = new Board();
	
	public ValMove minimax(boolean max, Node<Integer> node, int depth){
		if (depth == 0){
				node.setScore(evalFunc(node.getState()));
				return node.getValmov();
		}
		if (max){ //Maximising player
			System.out.println("Max");
			if(node.getScore() == -10){
				bestValue = Integer.MIN_VALUE;
				int [][] bo = b.clone(node.getState());
				node.setMoves(Board.getAllMoves(node.getState()));
				for(int i = 0; i < node.getMoves().size(); i = i + 4){
					System.out.println("One ply deeper");
					bo = Board.Moving2(node.getState(), node.getMoves().get(i), node.getMoves().get(i+1), node.getMoves().get(i+2), node.getMoves().get(i+3));
					Node<Integer> n = new Node<Integer>(bo);
					node.addChild(n);
					ValMove temp = new ValMove();
					temp.setMoveX(node.getMoves().get(i));
					temp.setMoveY(node.getMoves().get(i+1));
					temp.setNewMoveX(node.getMoves().get(i+2));
					temp.setNewMoveY(node.getMoves().get(i+3));
					n.setValmov(temp);
					n.setScore(Math.max(bestValue,minimax(false,n, depth-1).getScore()));
					bestValue = n.getScore();
					
				}
				node.setScore(bestValue);
				return node.getValmov();
			}
			else {
				return node.getValmov();
			}
		}else{ //minimising player
			if(node.getScore() == -10){
				node.setMoves(Board.getAllMoves(node.getState()));
				int bo [][] = b.clone(node.getState());
				bestValue = Integer.MIN_VALUE;
				for(int i = 0; i < node.getMoves().size(); i = i + 4){
					ValMove temp = new ValMove();
					Node<Integer> n = new Node<Integer>();
					n.setState(Board.Moving2(node.getState(), node.getMoves().get(i), node.getMoves().get(i+1), node.getMoves().get(i+2), node.getMoves().get(i+3)));

					temp.setMoveX(node.getMoves().get(i));
					temp.setMoveY(node.getMoves().get(i+1));
					temp.setNewMoveX(node.getMoves().get(i+2));
					temp.setNewMoveY(node.getMoves().get(i+3));
					n.setValmov(temp);
					n.setScore(Math.min(bestValue,minimax(true,n, depth-1).getScore()));
					bestValue = n.getScore();
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


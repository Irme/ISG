package game;

import java.util.ArrayList;

import game.Tree.Node;

public class Minimax {

	private int bestValue;
	Board b = new Board();

	public ValMove minimax(boolean max, Node<Integer> node, int depth, int pla){
		if (depth == 0){
			node.setScore(evalFunc(node.getState(),pla));
			return node.getValmov();
		}
		int [][] bo = new int [8][8];
		node.setMoves(b.getAllMoves(node.getState(), pla));
		ValMove vm = new ValMove();
		
		
		if (max){ //Maximising player
			if(node.getScore() == -10){
				bestValue = Integer.MIN_VALUE;
				for(int i = 0; i < node.getMoves().size(); i = i + 4){
					bo = Board.Moving2(node.getState(), node.getMoves().get(i), node.getMoves().get(i+1), node.getMoves().get(i+2), node.getMoves().get(i+3));
					Node<Integer> n = new Node<Integer>(bo);
					node.addChild(n);
					int temp2 = minimax(false,n, depth-1, pla%2+1).getScore();
					if(temp2 > bestValue){
						bestValue = temp2;
						vm.setMoveX(node.getMoves().get(i));
						vm.setMoveY(node.getMoves().get(i+1));
						vm.setNewMoveX(node.getMoves().get(i+2));
						vm.setNewMoveY(node.getMoves().get(i+3));
						vm.setScore(bestValue);
					}
				}
				node.setValmov(vm);
				return node.getValmov();
			}
			else {
				return node.getValmov();
			}
			
			
		}else{ //minimising player
			if(node.getScore() == -10){
				bestValue = Integer.MAX_VALUE;
				for(int i = 0; i < node.getMoves().size(); i = i + 4){
					Node<Integer> n = new Node<Integer>();
					n.setState(Board.Moving2(node.getState(), node.getMoves().get(i), node.getMoves().get(i+1), node.getMoves().get(i+2), node.getMoves().get(i+3)));
					int temp2 = minimax(true,n, depth-1,pla%2+1).getScore();
					if(temp2 < bestValue){
						bestValue = temp2;
						vm.setMoveX(node.getMoves().get(i));
						vm.setMoveY(node.getMoves().get(i+1));
						vm.setNewMoveX(node.getMoves().get(i+2));
						vm.setNewMoveY(node.getMoves().get(i+3));
						vm.setScore(bestValue);
					}

				}
				node.setValmov(vm);
				return node.getValmov();
			}
			else {
				return node.getValmov();
			}

		}

	}

	private int evalFunc(int [][] board, int pl){
		//Count pieces
		int countOwn = 0;
		int countOp = 0;
		int eval = 0;
		ArrayList<Integer> m = new ArrayList<Integer>();
		for(int k = 0; k < m.size(); k = k + 4){
			if(board[m.get(k+2)][m.get(k+3)] == pl%2+1 ){
				//Possible capture
				eval = eval + 4;
			}
		}
		m = b.getAllMoves(board, pl);
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
		eval = eval + countOwn*2 + (16-countOp);
		//Count possible moves

		//Count opponent's possible moves



		return eval;
	}
}


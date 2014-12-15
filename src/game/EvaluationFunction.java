package game;

public class EvaluationFunction {
	
	Board b = new Board();
	public int evaluate(int [][] board, int pl){
			//Count pieces and opponent's pieces
			int countOwn = 0;
			int countOp = 0;
			int center = 0;
			int eval = 0;
			if(b.isFinished(board)  == pl)
				eval = eval + 100;
			if(b.isFinished(board)  == pl%2+1)
				eval = eval - 100;
			for (int i = 0; i< 8 ; i ++){
				for(int j = 0; j < 8; j++){
					if(board[i][j] == pl){
						countOwn++;
					}
					if (board[i][j] == (pl%2+1)){

						countOp++;
					}
					if(i < 6 && i > 2 && j < 6 && j > 2 && board[i][j] == pl){
						center++;
					}

				}

			}
			eval = eval + countOwn + (16-countOp)+ center;
			//Count possible moves

			//Count opponent's possible moves
			return eval;
	}

}
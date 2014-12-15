package game;

public class EvaluationFunction {

	Board b = new Board();
	public int evaluate(int [][] board, int pl){
		//Count pieces and opponent's pieces
		int countOwn = 0;
		int eval = 0;

		if(b.isFinished(board)  == pl)
		{
			eval = -10000;
			//System.out.println(eval);
			return eval;
		}
		if(b.isFinished(board)  == pl%2+1){
			eval = 10000;
			//System.out.println(eval + " Opponents win");
			return eval;
		}
		//		if(b.isAlmostFinished(board)== pl%2+1){
		//			eval = eval + 1000;
		//		}
		for (int i = 0; i< 8 ; i ++){
			for(int j = 0; j < 8; j++){
				if(board[i][j] == pl%2+1){
					countOwn++;
					//Progression
					if(pl == 1){
						if(j == 6){
							eval = eval + 300;
						}
						if(j == 5){
							eval = eval + 200;
						}
						if (j == 4){
							eval = eval + 100;
						}
					}else {
						if(j == 1){
							eval = eval + 300;
						}
						if(j == 2){
							eval = eval + 200;
						}
						if (j == 3){
							eval = eval + 100;
						}
					}
				} 
//				else {
//					if(board[i][j] == pl){
//						if(pl == 1){
//							if(j == 1){
//								eval = eval - 30;
//							}
//							if(j == 2){
//								eval = eval - 20;
//							}
//							if (j == 3){
//								eval = eval - 10;
//							}
//						}else {
//							if(j == 6){
//								eval = eval - 30;
//							}
//							if(j == 5){
//								eval = eval - 20;
//							}
//							if (j == 4){
//								eval = eval - 10;
//							}
//						}
//
//					}
			
				//}
			}
		}
		eval = eval + countOwn;


		//System.out.println(eval);
		return eval;
	}

}

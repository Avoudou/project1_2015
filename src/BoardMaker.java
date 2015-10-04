
public class BoardMaker 
{
	
		public static void main(String[] args){
			
		}
    
	private int[][] board;
	
	
	public BoardMaker(int x, int y) {
		board=new int[x][y];
		
	}
	public int getBoardRows(){
		return board.length;
	}
	public int getBoardCols(){
		return board[0].length;
	}
	public void printBoard() {
	
		for(int i=0;i<board.length;i++){
			System.out.println();
			for(int j=0;j<board[0].length;j++){
				System.out.print(board[i][j] + " ");
			}
	}
}
	public int[][] mBoardArr(){
		return board;
	}

}

	
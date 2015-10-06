import java.util.ArrayList;
public class Backtracking {

	public static void main(String[] args){
		ArrayList list= new ArrayList(3);
		ArrayList<int[][]> boardArrayList = new ArrayList<int[][]>();

	}

	public static boolean isNext(int[][] board){
		for (int i = 0; i <= board.length-1; i++){
			for (int j = 0; j < board.length; j++){
				if(board[i][j] == 0) return true;
				else return false;
			}
		}

	}

	public static int[] findEmptySq(int[][] board) {
		int[] blancCor = new int[2]; // please be more explicit with the variable name.
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 0) {
					blancCor[0] = i;
					blancCor[1] = j;
					return blancCor;
				}
			}

		}
		return blancCor;
	}

	// this function returns a boolean
	public static boolean shapeChecker(int x, int y, int[][] board, int[][] pentomino) {
		for (int i = x; i < x+pentomino.length; i++) {
			for (int j = y; j < y+pentomino[0].length; j++) {
				if(pentomino[i][j] != 0){
					if(board[i][j]==0){
						return true;
					} else {
						return false;
					}
				}

			}
		}
		// returns a board which is type array, not a boolean. !!!!!!!!!!
		return board;
	}

	public static boolean fullBoard(int[][] input){
		for(int i = 0; i < input.length; i++){
			for(int j = 0;j < input[0].length; j++){
				if(input[i][j] == 0){
					return false;
				}
			}
		}
		return true;
	}

  // I wrote the function like this so reader can easily see what parameters go into the function.
	// It does not matter if you split the code in several lines, observe that it is the same thing as one line, just split in several.
	// Check the comments down there and try to figure out which parameter you are missing.
	public static void recursive (
	 	ArrayList<int[][]> listOfBoards,
	 	ArrayList<int[][]> listOfPentominos,
		int r /* board arraylist index */,
		int p /* pentomino arraylist index */ ,
		int i /* pentomino rotation */ )
		{

		if (fullBoard(listOfBoards[r]))	System.out.println("Solution found!"); // coding tip: if you have only one statement to execute, you can just type it without {}.
		else if(shapeChecker(findEmpty(listOfBoards[r])[0], findEmpty(listOfBoards[r])[1], listOfBoards[r],listOfPentominos[p][i])){

					listOfBoards.add (r+1, shapePlacer(findEmpty(listOfBoards[r])[0]), findEmpty(listOfBoards[r][1]), listOfBoards[r], listOfPentominos[p][i]);
					recursive(listOfBoards, listOfPentominos, r+1, p+1,0);

			}
			else if (i<=listOfPentominos[p].size-1)	recursive(listOfBoards,listOfPentominos,r,p,i+1);
			else if(p<listOfPentominos.size) recursive(listOfBoards, listOfPentominos, r, p+1); // <==== missing a parameter (needs arraylist, arraylist, int, int, int), you got 2 ints only.
			else if(r!=0) recursive(listOfBoards, listOfPentominos, r-1,p);
			else { // if all fails this is the else
				System.out.println("Solution not found!");
				System.exit(0);
			}
}
	// this needs a more explicit name for variable b.
	public static int[][] shapePlacer(int x, int y, int[][] board, int[][] b) {
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[0].length; j++) {
				board[x + i][y + j] += b[i][j];

			}
		}
		return board;
	}
}

import java.util.ArrayList;
import java.util.Collections;

public class TestBoard {
	public static void main(String[] args) {
		

		// testBoard.printBoard();//test
		Shape1 shape1 = new Shape1();
		Shape2 shape2A = new Shape2(0);
		Shape2 shape2B = new Shape2(1);
		Shape5 shape5A = new Shape5(0);
		Shape5 shape5B = new Shape5(1);
		Shape5 shape5C = new Shape5(2);
		Shape5 shape5D = new Shape5(3);

		
		

		ArrayList<int[][]> shape1ListA = new ArrayList<int[][]>();
		shape1ListA.add(shape1.mshape1Arr());
		ArrayList<int[][]> shape1ListB = new ArrayList<int[][]>();
		shape1ListB.add(shape1.mshape1Arr());
		ArrayList<int[][]> shape2List = new ArrayList<int[][]>();
		shape2List.add(shape2A.mshape2Arr());
		shape2List.add(shape2B.mshape2Arr());
		ArrayList<int[][]> shape5List = new ArrayList<int[][]>();
		shape5List.add(shape5A.mshape5Arr());
		shape5List.add(shape5B.mshape5Arr());
		shape5List.add(shape5C.mshape5Arr());
		shape5List.add(shape5D.mshape5Arr());

			ArrayList<ArrayList<int[][]>>  finalShapeList= new ArrayList<ArrayList<int[][]>>();
			finalShapeList.add(shape1ListA);
			finalShapeList.add(shape1ListB);
			finalShapeList.add(shape2List);
			finalShapeList.add(shape5List);
			BoardMaker board33obj = new BoardMaker(3, 3);
			int[][] board33=board33obj.mBoardArr();
			
			recAlgSolv(board33,finalShapeList);
			
	}
	
	public static void recAlgSolv(int[][] board,ArrayList<ArrayList<int[][]>> allShapes){
		if(fullBoard(board)){
			System.out.println();
			printArray(board);
		}
		
		
		for(int i=0;i<allShapes.size();i++){
			for(int j=0;j<allShapes.get(i).size();j++){
				int[] emptySqCoord=findEmptySq(board);//finds empy sqr coordinates and stores them into an array(one-dimentional)
				if(shapeValid(emptySqCoord[0],emptySqCoord[1],board,allShapes.get(i).get(j))){
					
					int[][] newboard= copyArray(board);
					shapePlacer(emptySqCoord[0],emptySqCoord[1],newboard,allShapes.get(i).get(j));
					ArrayList<int[][]> allShapesRemove=allShapes.remove(i);
					recAlgSolv(newboard,allShapes);
					allShapes.add(i,allShapesRemove);
					
					
				}
				
				
				
			}
		}
		
		
	}

	public static boolean shapeValid(int x, int y, int[][] board, int[][] b) {// tests
																				// if
																				// shapes
																				// can
																				// be
																				// places
																				// (hope
																				// so...)
		if (b.length > board.length - x) {
			return false;

		}
		if (b[0].length > board[0].length - y) {
			return false;
		}
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[0].length; j++) {
				if (b[i][j] != 0 && board[x + i][y + j] != 0) {
					return false;
				}
			}
		}

		return true;
	}

	public static ArrayList<int[][]> findRandomShapes(ArrayList<int[][]> a,
			ArrayList<int[][]> b, ArrayList<int[][]> c, ArrayList<int[][]> d) {
		ArrayList<int[][]> shapeFinalList = new ArrayList<int[][]>();
		int aPar = (int) (a.size() * Math.random());
		int bPar = (int) (b.size() * Math.random());
		int cPar = (int) (c.size() * Math.random());
		int dPar = (int) (d.size() * Math.random());
		shapeFinalList.add(a.get(aPar));
		shapeFinalList.add(b.get(bPar));
		shapeFinalList.add(c.get(cPar));
		shapeFinalList.add(d.get(dPar));
		return shapeFinalList;
	}

	public static int[] findEmptySq(int[][] board) {
		int[] blancCor = new int[2];
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

	public static int[][] shapePlacer(int x, int y, int[][] board, int[][] b) {
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[0].length; j++) {
				board[x + i][y + j] += b[i][j];

			}
		}
		return board;
	}

	public static void printArray(int[][] board) {

		for (int i = 0; i < board.length; i++) {
			System.out.println();
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
		}

	}
	public static boolean fullBoard(int[][] input){
		for(int i=0;i<input.length;i++){
			for(int j=0;j<input[0].length;j++){
				if(input[i][j]<=0){
					return false;
				}
			}
		}
		return true;
	}
	public static int[][] copyArray(int[][] array){
		int[][] copyOfarray= new int[array.length][array[0].length];
		for(int i=0;i<array.length;i++){
			for(int j=0;j<array[0].length;j++){
				copyOfarray[i][j]=array[i][j];
			}
			
		}
		return copyOfarray;
	}
}


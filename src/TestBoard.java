import java.util.ArrayList;
import java.util.Collections;

public class TestBoard {
	public static void main(String[] args) {
		

	
		Shape1 shape1 = new Shape1(); // Here we call each object as many times as its  rotations are to have each rotation of each object at least one/ can be improved by making 3d array
		Shape2 shape2A = new Shape2(0);
		Shape2 shape2B = new Shape2(1);
		Shape5 shape5A = new Shape5(0);
		Shape5 shape5B = new Shape5(1);
		Shape5 shape5C = new Shape5(2);
		Shape5 shape5D = new Shape5(3);

		
		
		// here we will store all the rotations of each object in a List for that object/ can change as soon as we have 3d array
		ArrayList<int[][]> shape1ListA = new ArrayList<int[][]>();//makes a list  for ALL shape 1 rotations
		shape1ListA.add(shape1.mshape1Arr());//adds  a specific rotation after it makes it an array with mshape1Arr
		ArrayList<int[][]> shape1ListB = new ArrayList<int[][]>();
		shape1ListB.add(shape1.mshape1Arr());
		ArrayList<int[][]> shape2List = new ArrayList<int[][]>();
		shape2List.add(shape2A.mshape2Arr());
		shape2List.add(shape2B.mshape2Arr());
		ArrayList<int[][]> shape5List = new ArrayList<int[][]>();//makes a list  for ALL  shape5 rotations
		shape5List.add(shape5A.mshape5Arr());// adds the shape 5 rotations  converted to arrays  into their list
		shape5List.add(shape5B.mshape5Arr());
		shape5List.add(shape5C.mshape5Arr());
		shape5List.add(shape5D.mshape5Arr());

		boolean solutionFound = false;// boolean to use  to stop while  when we find a solution
		while (solutionFound == false) {
			BoardMaker testBoard = new BoardMaker(3, 3);//// makes a board object  with 3x3 dimentions

			int[][] board1 = testBoard.mBoardArr();// // converts the board object into an array
			System.out.println(" me trys");
			ArrayList<int[][]> shapeFinalList = findRandomShapes(shape1ListA,// makes a list of random elements of the shapes Lists  above(look method find random shapes)
					shape1ListB, shape2List, shape5List);
			Collections.shuffle(shapeFinalList);// shuffles that list 

			for (int i = 0; i < shapeFinalList.size(); i++) {// for loop to use all the shapes  of the  Final random arrayList we have

				int[] cordinates = findEmptySq(board1);// we find the first empty  spacer/ store it as 2-size array with cordinates x, y  in its indexes.

				if (shapeValid(cordinates[0], cordinates[1], board1,//we check if  the choosen shape  can be placed into that empty space(out of bounds and  overlap covered)
						shapeFinalList.get(i))) {
					board1 = shapePlacer(cordinates[0], cordinates[1], board1,// we copy the chosen shape at the board array
							shapeFinalList.get(i));
					printArray(board1);
					System.out.println();
				} else {// if something doesnt fit we stop to start again
					break;
				}
			}
			if (fullBoard(board1)) {//if we manage to fill the board we return the solution fullboard method returns a boolean)
				solutionFound = true;
				printArray(board1);
			}
		}
	}

	public static boolean shapeValid(int x, int y, int[][] board, int[][] b) {// tests
																				// if
																				// shapes
																				// can
																				// be
																				// placed
																				
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

	public static ArrayList<int[][]> findRandomShapes(ArrayList<int[][]> a,// this makes an arrayList from random elements from the lists in the parameters
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

	public static int[] findEmptySq(int[][] board) {//this finds the first empty space at the board array 
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

	public static int[][] shapePlacer(int x, int y, int[][] board, int[][] b) {//this copys a given shape to a given  coordinates  in a board
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[0].length; j++) {
				board[x + i][y + j] += b[i][j];

			}
		}
		return board;
	}

	public static void printArray(int[][] board) {//method to print an array

		for (int i = 0; i < board.length; i++) {
			System.out.println();
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
		}

	}
	public static boolean fullBoard(int[][] input){// boolean  that returns true if a solution is found
		for(int i=0;i<input.length;i++){
			for(int j=0;j<input[0].length;j++){
				if(input[i][j]<=0){
					return false;
				}
			}
		}
		return true;
	}
}


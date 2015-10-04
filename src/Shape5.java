
public class Shape5 {
	private int[][] shape5;

	public Shape5(int x) {

		if (x == 0) {
			shape5 = new int[][] {  { 5, 0, 5 }, { 5, 5, 5 } };
		}
		if (x == 1) {
			shape5 = new int[][] { { 5, 5, 5 }, { 5, 0, 5 },};
		}
		if (x == 2) {
			shape5 = new int[][] { { 5, 5 }, { 5, 0}, { 5, 5 } };
		}
		if (x == 3) {
			shape5 = new int[][] { { 5, 5 }, { 0, 5 }, {  5, 5 } };

		}

	}

	public void printShape() {

		for (int i = 0; i < shape5.length; i++) {
			System.out.println();
			for (int j = 0; j < shape5[0].length; j++) {
				System.out.print(shape5[i][j] + " ");
			}
		}
	}
public Shape5[] rotOfshape5(){
	Shape5[] array5= new Shape5[4];
	for(int i=0;i<4;i++){
		Shape5 shape5 = new Shape5(i);
		array5[i]=shape5;
		
		
	}
	return array5;
}
public int[][] mshape5Arr(){
	return shape5;
}
}

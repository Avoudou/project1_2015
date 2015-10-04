public class Shape2 {
	private int[][] shape2;

	public Shape2(int x) {

		if (x == 0) {
			shape2 = new int[][] { { 2, 2 } };
		}
		if (x == 1) {
			shape2 = new int[][] { {2}, {2} };
		}
		

	}

	public void printShape() {

		for (int i = 0; i < shape2.length; i++) {
			System.out.println();
			for (int j = 0; j < shape2[0].length; j++) {
				System.out.print(shape2[i][j] + " ");
			}
		}
	}

	public Shape2[] rotOfshape2() {
		Shape2[] array2 = new Shape2[2];
		for (int i = 0; i < 2; i++) {
			Shape2 shape2 = new Shape2(i);
			array2[i] = shape2;

		}
		return array2;
	}
	public int[][] mshape2Arr(){
		return shape2;
	}
}



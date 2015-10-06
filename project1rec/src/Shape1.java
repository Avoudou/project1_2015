public class Shape1 {
	private int[][] shape1;

	public Shape1() {

		shape1 = new int[][] { { 1} };
	}

	public void printShape() {

		for (int i = 0; i < shape1.length; i++) {
			System.out.println();
			for (int j = 0; j < shape1[0].length; j++) {
				System.out.print(shape1[i][j] + " ");
			}
		}
	}

	public Shape1[] rotOfshape1() {
		Shape1[] array1 = new Shape1[1];

		return array1;
	}
	public int[][] mshape1Arr(){
		return shape1;
	}
}

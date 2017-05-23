package arrayExercise;

import java.util.Arrays;

public class arrayEx {

	public static void main(String[] args) {
		ex1();
		ex2();
	}

	private static void ex1() {
		int [][] intArr = new int [10][10];
		int row = 0;
		
		for (int i = 0; i < intArr.length; i++) {
			row++;
			int column = 0;
			for (int u = 0; u < intArr[i].length; u++) {
				column++;
				intArr[i][u] = row * column;
			}
			
		}
		print2dArray(intArr);
	}
	
	private static void ex2() {
		String[][] strArray = new String[3][3];
		int row = 0;
		for (int i = 0; i < strArray.length; i++) {
			row++;
			int column = 0;
			for (int u = 0; u < strArray[i].length; u++) {
				column++;
				String str = "(" + row + ","+ column + ")";
				strArray[i][u] = str;
			}
			
		}
		print2dArray(strArray);
	}
	
	private static void print2dArray(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(Arrays.toString(array[i]));
		}
	}
	
	private static void print2dArray(Object[][] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(Arrays.toString(array[i]));
		}
	}
}

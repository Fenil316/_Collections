package java8;



// FAILED ATTEMPT!!!
public class TwoDimArrays {

	public static void main(String[] args) {
		/*int counter = 0;

		int[][] arr = new int[3][4];
		System.out.println(arr.length);
		for(int i = 0; i < 3 ; i++) {
			for(int j = 0 ; j < 4 ; j++) {
				arr[i][j] = counter++;
			}
		}

		arr[1] = null;

		for(int i = 0; i < 3 ; i++) {
			for(int j = 0 ; j < 4 ; j++) {
				System.out.print((arr[i] == null) ? "x " :  arr[i][j] + " ");
			}
			System.out.println();
		}*/	
		String[] arr = {"fan", "facet", "cat", "face", "abc"};
		String[] result = sortStringArray(arr);

	}

	private static String[] sortStringArray(String[] arr) {
		String[] result = new String[arr.length];
		char[][] charArr = new char[5][5];
		for(int i = 0 ; i < arr.length ; i++ ) {
			charArr[i] = arr[i].toCharArray();
		}
		return compareAndReturn(charArr, result);
	}

	private static String[] compareAndReturn(char[][] charArr, String[] result) {

		int posToDelete = -1;
		int counter = 0;
		boolean flag;

		for(int i = 0 ; i < charArr.length ; i++) {
			flag = false;
			while(!flag) {
				posToDelete = -1;
				for(int j = 0 ; j < result.length - 1 ; j ++) {
					if(charArr[j] != null && charArr[j + 1] != null && charArr[j + 1][i] < charArr[j][i]) {
						posToDelete = j + 1;
					}
				}
				if(posToDelete >= 0) {
					result[counter] = new String(charArr[posToDelete]);
					counter++;
					charArr[posToDelete] = null;
				} else {
					flag = true;
				}
			}
		}
		return result;
	}

}

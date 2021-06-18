import java.util.Scanner;

public class Test3 {
	
	public static int backInput(int[][] arr, boolean[][] state, int i, int j, int sum, int flag){
		if(i >= 0 && i < arr.length && j >= 0 && j < arr[0].length){
			if(!state[i][j] && arr[i][j] == flag){
				state[i][j] = true;
				sum ++;
				sum = backInput(arr, state, i-1, j, sum, flag);
				sum = backInput(arr, state, i+1, j, sum, flag);
				sum = backInput(arr, state, i, j-1, sum, flag);
				sum = backInput(arr, state, i, j+1, sum, flag);
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 10;
		int[][] input = new int[n][n];
		boolean[][] state = new boolean[n][n];
		Scanner in = new Scanner(System.in);
		int i, j;
		for(i = 0; i < n; i++){
			for(j = 0; j < n; j++){
				input[i][j] = in.nextInt();
			}
		}
		
		int max1 = 0, max2 = 0;
		for(i = 0; i < n; i++){
			for(j = 0; j < n; j++){
				if(input[i][j] == 1 && !state[i][j]){
					max1 = Math.max(Test3.backInput(input, state, i, j, 0, 1), max1);
				}
				if(input[i][j] == 2 && !state[i][j]){
					max2 = Math.max(Test3.backInput(input, state, i, j, 0, 2), max2);
				}	
			}
		}
		System.out.println(max1);
		System.out.println(max2);
		String out = "equal";
		out = max1 > max2 ? "white" : "black";
		System.out.println(out);
	}
}

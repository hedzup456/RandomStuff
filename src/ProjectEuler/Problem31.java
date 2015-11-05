package ProjectEuler;

public class Problem31 {
	public static int count(int index, int remainder,  int[] coins){
		if(remainder == 1) return 1;
		if(remainder < 0 || index <= 0) return 0;
		return count(index-1, remainder, coins) + count(index, remainder - coins[index - 1], coins);
	}
	
	public static void main(String[] args) {
		int[] coins = {1,2,5,10,20,50,100,200};
		int res = 200;
		int[][] matrix = new int[coins.length][res+1];
		for (int y = 0; y < res+1; y++) matrix[0][y] = 1;
		for (int y = 0; y < res+1; y++){
			for (int x = 1; x < coins.length; x++){
				matrix[x][y] = 0;
				if (y >= coins[x]){
					matrix[x][y] += matrix[x-1][y];
					matrix[x][y] += matrix[x][y-coins[x]];
				} else {
					matrix[x][y] = matrix[x-1][y];
				}
			}
		}
		System.out.println(matrix[matrix[0].length][matrix.length]);
	}

}

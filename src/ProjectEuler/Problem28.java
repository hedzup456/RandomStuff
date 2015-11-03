package ProjectEuler;

public class Problem28 {
	public static int[][] populateSpiral(int dim) {
		// Adapted from the output code given here:
		// http://forum.codecall.net/topic/64777-printing-array-in-spiral-part-2-going-outward-from-center/
		
		int[][] spiralNums = new int[dim][dim];
		
		int levl;
		int c = dim/2;
		int x,y;
		x = y = c;
		int n = 1;
		
		for(levl = 1; c + levl <= dim; levl++) {
			for(; y<= c+levl && y < dim; y++) { // Go right
				spiralNums[x][y] = n++;
			}
			if (x == 0 && y == dim) break; // done
			
			for(x++, y--; x<= c+levl && x < dim; x++) spiralNums[x][y] = n++; // Go down
			for(x--, y--; y >=c-levl; y--) spiralNums[x][y] = n++; // Go left
			for(x--, y++; x>= c-levl; x--) spiralNums[x][y] = n++; // Go up
			x++;
			y++;
		}
		return spiralNums;
	}
	
	public static void main(String[] args) {
		int dim = 1001;
		int[][] spiralNums = populateSpiral(dim);
		
		int total = 0;
		for(int i = 0; i < dim/2; i++) {
			total += spiralNums[i][i];
			System.out.println(spiralNums[i][i]);
			total += spiralNums[i][dim - (i+1)];
			System.out.println(spiralNums[i][dim - (i+1)]);
			total += spiralNums[dim - (i+1)][i];
			System.out.println(spiralNums[dim - (i+1)][i]);
			total += spiralNums[dim - (i+1)][dim - (i+1)];
			System.out.println(spiralNums[dim - (i+1)][dim - (i+1)]);
		}
		total++;
		System.out.println(total);
		
	}

}

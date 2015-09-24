package ProjectEuler;

/* Only able to move right and down
 * Given a 2x2 grid, so vertices (0,0); (0,1); (0,2); (1,0); (2,0); (1,1); and (2,2)
 * There are six routes from 00 to 22.
 * There is only one route to any point on the left side or top side, so all of those are 1.
 * There are two routes from 00 to 11, so this is 2.
 * There are three routes from 00 to 12 (or 21) so these are filled in as 3. 
 * There are six routes from 00 to 22. This forms a Pascals Triangle.
 * 
 * 1
 * 1,1
 * 1,2,1
 * 1,3,3,1
 * 1,4,6,4,1
 * 
 * The 1s are the edges
 * 1	1	1	1	1
 * 1
 * 1
 * 1
 * 1
 * 
 * The next set in is the natural numbers; this is the routes from 00 to 12 (or 21) in the above example
 * 1	1	1	1	1
 * 1	2	3	4	5
 * 1	3
 * 1	4
 * 1	5
 * 
 * When filled in, this grid can be used to find out for a 4x4 - Each number is the sum of the one above it and to the left of it
 * 1	1	1	1	1
 * 1	2	3	4	5
 * 1	3	6	10	15
 * 1	4	10	20	35
 * 1	5	15	35	70
 * 
 * There are seventy routes from 00 to 44.
 * 
 * Do the same for 20x20.
 * 
 */


public class Problem15 {
	static int size = 20;
	static long[][] grid = new long[size+1][size+1]; // Grid used by all methods
	static public void whatNum(int x, int y){ // Get the value of the position x,y
		grid[x][y] = grid[x-1][y] + grid[x][y-1];
	}
	public static void main(String[] args){
		System.out.println("Filling in the 1s");
		// fill in the ones
		for(int i = 0; i <= size; i++){
			grid[i][0] = grid[0][i] = 1;
		} // finish populating the grid
		
		System.out.println("Filling in the rest");
		for(int x = 1; x <= size; x++){ // Starting at 1 because the 0s have been filled with ones
			for(int y = 1; y <= size; y++){
				whatNum(x,y);
			}
		}
		System.out.println(grid[size][size]);
	} // main
} //class

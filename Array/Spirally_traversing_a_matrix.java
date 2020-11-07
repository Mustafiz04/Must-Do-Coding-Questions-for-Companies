import java.util.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0){
		    int row = sc.nextInt();
		    int col = sc.nextInt();
		    int[][] mat = new int[row][col];
		    for(int i = 0; i<row; i++){
		        for(int j = 0; j<col; j++){
		            mat[i][j] = sc.nextInt();
		        }
		    }
		    spiral(mat, row, col);
		    System.out.println();
		}
	}
	
	public static void spiral(int[][] mat, int r, int c){
	    int top = 0, down = r-1, left = 0, right = c-1;
	    int dir = 0;
	    
	    while( top <= down && left <= right ){
	        if( dir == 0 ){
	            for(int i = left; i<=right; i++){
	                System.out.print(mat[top][i] + " ");
	            }
	            top += 1;
	        }else if( dir == 1 ){
	            for(int i = top; i<=down; i++){
	                System.out.print(mat[i][right] + " ");
	            }
	            right -= 1;
	        }else if( dir == 2 ){
	            for(int i = right; i>=left; i--){
	                System.out.print(mat[down][i] + " ");
	            }
	            down -= 1;
	        }else if( dir == 3 ){
	            for(int i = down; i>=top; i--){
	                System.out.print(mat[i][left] + " ");
	            }
	            left += 1;
	        }
	        dir = (dir + 1) % 4;
	    }
	    
	}
}
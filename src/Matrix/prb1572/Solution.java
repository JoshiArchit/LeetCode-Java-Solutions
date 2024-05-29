package Matrix.prb1572;
/**
  * Solution.java
  * Author : Archit Joshi
  * Version :
  * Revisions :
  */
 
public class Solution {
    public int diagonalSum(int[][] mat) {
        if(mat.length==1){
            return mat[0][0];
        }
        int sum = 0;
        int mat_size = mat.length;
        int mid = mat_size / 2;
        System.out.println(mid);
        int corner = mat_size;

        for(int i=0; i<mat_size; i++) {
            sum += mat[i][i];
            System.out.println("Adding element 1:" + mat[i][i]);
            sum += mat[i][corner-1];
            System.out.println("Adding element 2:" + mat[i][corner-1]);
            corner--;
        }

        // Odd needs to cut out the middle element thats added twice
        if ( !( (mat_size%2) == 0 ) ) {
            System.out.println("Deleting : "+mat[mid][mid]);
            return sum - mat[mid][mid];
        }
        return sum;
    }

    public static void main( String[] args ) {
        Solution sol = new Solution();
//        int[][] mat = {
//                {1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 9}
//        };
//        int[][] mat = {
//                {1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1}
//        };
        int[][] mat = {
                {6, 3, 1, 10, 7, 4},
                {4, 10, 1, 9, 5, 10},
                {5, 5, 7, 3, 8, 5},
                {2, 7, 6, 4, 7, 6},
                {7, 9, 6, 1, 8, 5},
                {1, 7, 9, 5, 8, 4}
        };
        int sum = sol.diagonalSum( mat );
        System.out.println(sum);
    }
}

// Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.

// A falling path starts at any element in the first row and chooses the element in the next row that is either directly below or diagonally left/right. Specifically, the next element from position (row, col) will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).

 

// Example 1:


// Input: matrix = [[2,1,3],[6,5,4],[7,8,9]]
// Output: 13
// Explanation: There are two falling paths with a minimum sum as shown.
// Example 2:


// Input: matrix = [[-19,57],[-40,-5]]
// Output: -59
// Explanation: The falling path with a minimum sum is shown.
//************************************************************************************//
// Success
// Details 
// Runtime: 5 ms, faster than 61.58% of Java online submissions for Minimum Falling Path Sum.
// Memory Usage: 48.4 MB, less than 11.13% of Java online submissions for Minimum Falling Path Sum.
//****************************************************************************************************************//
class Solution {//The dp bottom up approache
    public int minFallingPathSum(int[][] matrix) {
        
        int[][]dp = new int[matrix.length][matrix.length];
        int out = Integer.MAX_VALUE;
        
        for(int i = 0;i<dp.length;i++){
            for(int j = 0;j<dp.length;j++){
                if(i==0){
                    dp[i][j] = matrix[i][j];
                }
                else if(j==0){
                    dp[i][j] =Math.min(dp[i-1][j],dp[i-1][j+1])+matrix[i][j]; 
                    
                }
                else if(j==dp.length-1){
                     dp[i][j] =Math.min(dp[i-1][j],dp[i-1][j-1])+matrix[i][j]; 
                    
                }
                else{
                      dp[i][j] =Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i-1][j+1]))+matrix[i][j]; 
                    
                }
                if(i==dp.length-1){
                    out =Math.min(out,dp[i][j]);
                }
            }
        }//outer for
        
        
  
        return out;
        
    }
}
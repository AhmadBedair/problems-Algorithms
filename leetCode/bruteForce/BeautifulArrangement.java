// Suppose you have n integers labeled 1 through n. A permutation of those n integers perm (1-indexed) is considered a beautiful arrangement if for every i (1 <= i <= n), either of the following is true:

// perm[i] is divisible by i.
// i is divisible by perm[i].
// Given an integer n, return the number of the beautiful arrangements that you can construct.

 

// Example 1:

// Input: n = 2
// Output: 2
// Explanation: 
// The first beautiful arrangement is [1,2]:
//     - perm[1] = 1 is divisible by i = 1
//     - perm[2] = 2 is divisible by i = 2
// The second beautiful arrangement is [2,1]:
//     - perm[1] = 2 is divisible by i = 1
//     - i = 2 is divisible by perm[2] = 1
// Example 2:

// Input: n = 1
// Output: 1
 

// Constraints:

// 1 <= n <= 15

class Solution {
    public int countArrangement(int n) {
        if(n==1)
            return 1;
        if(n==2)
            return 2;
      int out=0;
        for(int i= 1;i<=n;i++){
            boolean[]memo = new boolean[n+1];
            memo[i] = true;
            out+=helper(memo,n,2);
        }
        return out;
        
    }
    
    public static int helper(boolean[]memo,int n,int index){
        if(index>n){
            return 0;
        }
        if(n==index){
            for(int i=1;i<=n;i++){
                if(memo[i]==false&&(i%index==0||index%i==0)){
                    
                    return 1;
                    
                }
            }
            return 0;
        }
        int out=0;
        for(int i = 1;i<=n;i++){
            if((i%index==0||index%i==0)&&memo[i]==false){
                memo[i] = true;
              
             
                out+=helper(memo,n,index+1);
                memo[i] = false;
       
        
            
            
        }
        }
        return out;
    }
}
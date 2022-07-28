// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 

// Example 1:

// Input: n = 3
// Output: ["((()))","(()())","(())()","()(())","()()()"]
// Example 2:

// Input: n = 1
// Output: ["()"]
 

// Constraints:

// 1 <= n <= 8
class Solution {
  
    
    public List<String> generateParenthesis(int n) {
         List<String>list=new ArrayList<>();
        String s = "(";
        
        
        helper(s,n-1,n,1,list);
        return list;
       
    }
    public static void helper(String s, int left ,int right,int i,List<String>list){
        
        if(left==0&&right==0){
            list.add(s);
      
        }
        else{
            if(left!=0){
                String s1 = s+"(";
                helper(s1,left-1,right,i+1,list);
              
            
            }
            if(right!=0&&i!=0){
                String s2 = s+")";
                helper(s2,left , right-1,i-1,list);
            }
        }
    }
}
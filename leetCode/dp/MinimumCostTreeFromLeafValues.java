// Given an array arr of positive integers, consider all binary trees such that:

// Each node has either 0 or 2 children;
// The values of arr correspond to the values of each leaf in an in-order traversal of the tree.
// The value of each non-leaf node is equal to the product of the largest leaf value in its left and right subtree, respectively.
// Among all possible binary trees considered, return the smallest possible sum of the values of each non-leaf node. It is guaranteed this sum fits into a 32-bit integer.

// A node is a leaf if and only if it has zero children.

 

// Example 1:


// Input: arr = [6,2,4]
// Output: 32
// Explanation: There are two possible trees shown.
// The first has a non-leaf node sum 36, and the second has non-leaf node sum 32.
class Solution {
    public int mctFromLeafValues(int[] arr) {
      
        int indexi = 0;
        int indexj = 0;
        int out = 0;
        int min = Integer.MAX_VALUE;
        int i = 0;
            int j = 1;
        while(j!=arr.length){
                if(arr[i]*arr[j]<min){
                    min = arr[i]*arr[j];
                    indexi = i;
                    indexj = j;
                }
            i++;
            j++;
                
                
            
            
        }//end outer for
        out+=min;
        ArrayList<Integer>list =new ArrayList<>();
        int delete = (arr[indexi]>arr[indexj]) ? indexj : indexi;
        for(int a=0;a<arr.length;a++){
            if(a!=delete)
                list.add(arr[a]);
            
        }
        
        while(list.size()!=1){
            min = Integer.MAX_VALUE;
            i = 0;
            j = i+1;
           
            while(j!=list.size()){

                   if(list.get(j)*list.get(i)<=min){
                       min = list.get(j)*list.get(i);
                       indexi = i;
                       indexj = j;
                   }
                i++;
                j++;
               
            }
              out+=min;
              
              delete = (list.get(indexi)>list.get(indexj)) ? indexj : indexi;
            list.remove(delete);
            
    
      
            
            
            
            
            
            
            
            
        }
        
        
        return out;
        
    }
}
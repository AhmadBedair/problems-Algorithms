 
//Category: Dynamic Programming Problem
// Description: 
// The power of an integer x is defined as the number of steps needed to transform x into 1 using the following steps:

// if x is even then x = x / 2
// if x is odd then x = 3 * x + 1
// For example, the power of x = 3 is 7 because 3 needs 7 steps to become 1 (3 --> 10 --> 5 --> 16 --> 8 --> 4 --> 2 --> 1).

// Given three integers lo, hi and k. The task is to sort all integers in the interval [lo, hi] by the power value in ascending order, if two or more integers have the same power value sort them by ascending order.

// Return the kth integer in the range [lo, hi] sorted by the power value.

// Notice that for any integer x (lo <= x <= hi) it is guaranteed that x will transform into 1 using these steps and that the power of x is will fit in a 32-bit signed integer.


// Outcome:
// Success
// Details 
// Runtime: 69 ms, faster than 82.34% of Java online submissions for Sort Integers by The Power Value.
// Memory Usage: 53.7 MB, less than 45.63% of Java online submissions for Sort Integers by The Power Value.




class Solution {
    
    //Implementing Class Pair which Implwmwnta Comp Interface
    
    class Pair implements Comparable<Pair>{
        int val;int pow;
        public Pair(int val,int pow){
            this.val = val;
            this.pow = pow;
        }
        public int compareTo(Pair p){
            if(this.pow==p.pow){
                return this.val-p.val;
            }
            return this.pow-p.pow;
        }
    }
        
        
        
        
        
        
        
        
        
      //The problem  
        
    public int getKth(int lo, int hi, int k) {
        k--;
        HashMap<Integer,Integer>map = new HashMap<>();
     
        map.put(4,2);
        map.put(3,7);
        map.put(2,1);
        map.put(1,0);
        ArrayList<Pair>list = new ArrayList<>();
        for(int i = lo;i<=hi;i++){
            if(map.containsKey(i)){
                Pair p = new Pair(i,map.get(i));
                list.add(p);
            }
            else{
                int count = 0;
                int temp = i;
                boolean flag = true;
                while(flag){
                    if(temp%2==0){
                        temp = temp/2;
                    }
                    else{
                        temp = temp*3+1;
                    }
                    count++;
                    if(map.containsKey(temp)){
                        Pair p = new Pair(i,map.get(temp)+count);
                        list.add(p);
                        map.put(p.val,p.pow);
                        break;
                    }
                    
                }
            }
        }
        Collections.sort(list);
        return list.get(k).val;
        
        
    }
}
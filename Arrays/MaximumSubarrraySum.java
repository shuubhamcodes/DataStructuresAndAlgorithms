package Arrays;

class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        
        int maxi = Integer.MIN_VALUE;
       for(int i =0;i<nums.length;i++){
           
           for(int j = i;j<nums.length;j++){
               int sum= 0;
               for(int k = i;k<=j;k++){
                
                sum = sum+nums[k];
            
               
               }
              maxi = Math.max(maxi,sum);
              
               
               
           }
           
       }
        return maxi;
    }
}



class MaximumSubarraySum {
    public int maxSubArray(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int maxi = Integer.MIN_VALUE;
        
        for(int i =0;i<nums.length;i++){
            int sum =0;
            for(int j = i;j<nums.length;j++){
                sum = sum+nums[j];
               maxi =  Math.max(maxi,sum);
            }
        }
        return maxi;
    }
}























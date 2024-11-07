package Arrays;

class Solution {
    public int majorityElement(int[] nums) {
          if(nums.length==1){
                return nums[0];
            }
        for(int i = 0;i<nums.length;i++){
           
         int count = 1;
            for(int j = i+1;j<nums.length;j++){
                if(nums[i]==nums[j]){
                    count++;
                }
                if(count >((nums.length)/2)){
                    return nums[i];
                }
            }
        }
             return -1;
    }
}





class MajorityElementMoore'sVotingAlgorit {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i =0;i<nums.length;i++){
            
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }
            else{

                map.put(nums[i],1);
                
            }
        }
            for (Integer key : map.keySet()){
        if(map.get(key)>nums.length/2){
            return key;
        }
    }
return -1;
       
}
    
    

    }

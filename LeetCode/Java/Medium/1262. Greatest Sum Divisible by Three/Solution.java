class Solution {
    public int maxSumDivThree(int[] nums) {
        int sum=0;
        for(int num:nums){
            sum+=num;
        }
        if(sum%3==0) return sum;
        int rem=sum%3;
        for(int i=0;i<nums.length;i++){
           if(nums[i]%3==sum%3){
            sum-=nums[i];
            break;
           }
        }
        return sum;
    }
}
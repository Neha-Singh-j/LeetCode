class Solution {
    
    public int maxCoins(int[] nums) {
        int n=nums.length;
        int[] arr=new int[nums.length+2];
        arr[0]=1;
        arr[arr.length-1]=1;
        int[][] dp=new int[nums.length+2][nums.length+2];
        for(int[]d:dp)
            Arrays.fill(d,-1);
        for(int i=0;i<n;i++){
            arr[i+1]=nums[i];
        }
        return solve(arr,0,arr.length-1,dp);

    }
    public int solve(int[] arr, int i, int j, int[][]dp){
        if(i+1==j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int ans=Integer.MIN_VALUE;
        for(int k=i+1;k<j;k++){
            int fs=solve(arr,i,k,dp);
            int ss=solve(arr,k,j,dp);
            int self=arr[i]*arr[j]*arr[k];
            ans=Math.max(ans,ss+fs+self);

        }
        return dp[i][j]=ans;
    }
}
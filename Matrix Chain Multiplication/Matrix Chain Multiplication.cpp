class Solution{
public:
    int matrixMultiplication(int n, int arr[])
    {
        // code here
        vector<vector<int>> dp(n,vector<int>(n,-1));
        int ans=mcm(dp,arr,1,n-1);
        return ans;
    }
    
    int mcm(vector<vector<int>> &dp,int arr[],int i,int j)
    {
        if(i==j)
            return 0;
            
        int min=INT_MAX;
        
        if(dp[i][j]!=-1)
            return dp[i][j];
            
        for(int k=i;k<j;k++)
        {
            int count=mcm(dp,arr,i,k)+
                        mcm(dp,arr,k+1,j)+
                            arr[i-1]*arr[k]*arr[j];
                            
            if(count<min)
                min=count;
        }
        
        return dp[i][j]=min;
    }
};
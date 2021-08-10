class Solution{
    public static int matrixMultiplication(int n, int arr[])
    {
        // code here
        int[][] dp=new int[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                dp[i][j]=-1;
        int ans=mcm(dp,arr,1,n-1);
        return ans;
    }
    
    public static int mcm(int[][] dp,int arr[],int i,int j)
    {
        if(i==j)
            return 0;
            
        int min=987456123;
        
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
}
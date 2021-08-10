class Solution:
    def matrixMultiplication(self, n, arr):
        # code here
        dp=[[-1 for i in range(n)]for i in range(n)]
    
        def mcm(dp,arr,i,j):
            if(i==j):
                return 0
        
            mini=9999999999
            if(dp[i][j]!=-1):
                return dp[i][j]
            
            for k in range(i,j):
                count=mcm(dp,arr,i,k)+mcm(dp,arr,k+1,j)+arr[i-1]*arr[k]*arr[j]
                            
                if(count<mini):
                    mini=count
        
            dp[i][j]=mini
            return dp[i][j]
        ans=mcm(dp,arr,1,n-1)
        return ans
class Leetcode3302 {
    public int[] validSequence(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        int count=0;
        int[] maximumSuffix=new int[n+1];
        int i=n-1;
        int j=m-1;
        while(i>0 && j>0)
        {
            if(word1.charAt(i)==word2.charAt(j))
            {
                count++;
                maximumSuffix[i]=count;
                i--;
                j--;
            }
            else
            {
                i--;
            }
        }
        for(i=n-2;i>=0;i--)
        {
            maximumSuffix[i]=Math.max(maximumSuffix[i],maximumSuffix[i+1]);
        }
        int[] ans =new int[m];
        int flag=0;
        count=0;
        i=0;j=0;
        while(i<n && j<m)
        {
            if(word1.charAt(i)==word2.charAt(j))
            {
                ans[j]=i;
                i++;
                j++;
                count++;
            }
            else{
                int remainingLength=(m-j-1);
                if(maximumSuffix[i+1]>=remainingLength && flag==0)
                {
                    ans[j]=i;
                    i++;
                    j++;
                    flag=1;
                    count++;
                }else{
                    i++;
                }
            }
        }
        if(count!=m)
        {
            return new int[0];
        } 
        
        return ans;
    }
}
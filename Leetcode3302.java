class Leetcode3302 {
    public int[] validSequence(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        int count=0;
        int[] maximumSuffix=new int[n];
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
                maximumSuffix[i]=count;
                i--;
            }
        }
        maximumSuffix[i]=count;
        i=0,j=0,count=0,flag=0;
        while(i<n && j<m)
        {
            if(word.charAt(i)==word2.charAt(j))
            {
                ans[j]=i;
                i++;
                j++;
            }
            else
            {
                if()
            }
        }
    }
}
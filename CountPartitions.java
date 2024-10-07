
import java.util.Arrays;
class CountPartitions{
    public static int countPartitions(int n, int d, int[] arr) {
        // code here
        int sum=0;
        int mod=1000000007;
        for(Integer i:arr)
        {
            sum+=i;
        }
        if ((sum - d) < 0 || (sum - d) % 2 != 0) {
            return 0;
        }
        sum=(sum-d)/2;
        int[] prev=new int[sum+1];
        if(arr[0]==0)
        {
            prev[0]=2;
        }
        else{
            prev[0]=1;
        }
        if(arr[0]!=0 && arr[0]<=sum)
        {
            prev[arr[0]]=1;
        }
        for(int i=1;i<n;i++)
        {
            int[] cur=new int[sum+1];
            for(int j=0;j<=sum;j++)
            {
                int notTake=prev[j];
                int take=0;
                if(arr[i]<=j)
                {
                    take=prev[j-arr[i]];
                }
                cur[j]=(take %mod+ notTake%mod)%mod;
            }
            //prev=cur;
            prev = Arrays.copyOf(cur, cur.length); 
        }
        return prev[sum];
    }
    public static void main(String[] args) {
        CountPartitions obj=new CountPartitions();
        int n=5;
        int[] arr={1,3,3,2,1};
        System.out.println(obj.countPartitions(n,5,arr));
    }
}
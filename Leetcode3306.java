import java.util.*;
class Leetcode3306{
    private long helper(String word,int k)
    {
        int n=word.length();
        int j=0;
        int i=0;
        long ans=0;
        int consonant=0;
        Map<Character,Integer>map=new HashMap<>();
        while(j<n)
        {
            if(word.charAt(j)=='a' || word.charAt(j)=='e' || word.charAt(j)=='i' || word.charAt(j)=='o' || word.charAt(j)=='u')
            {
                if(map.containsKey(word.charAt(j)))
                {
                    map.put(word.charAt(j),map.get(word.charAt(j))+1);
                }
                else
                {
                    map.put(word.charAt(j),1);
                }
            }
            else
            {
                consonant++;
            }
            while(map.size()==5 && consonant>=k)
            {
                ans+=n-j;
                if(map.containsKey(word.charAt(i)) && map.get(word.charAt(i))==1)
                {
                    map.remove(word.charAt(i));
                }
                else if (map.containsKey(word.charAt(i)) && map.get(word.charAt(i))>1){
                    map.put(word.charAt(i),map.get(word.charAt(i))-1);
                }
                else{
                    consonant--;
                }
                i++;
            }
            j++;
        }
        return ans;
    }
    public long countOfSubstrings(String word, int k) {
        return helper(word,k)-helper(word,k+1);
    }
    public static void main(String args[])
    {
        Leetcode3306 obj=new Leetcode3306();
        long k=obj.countOfSubstrings("eoeaui",0);
        System.out.println(k);
    }
}
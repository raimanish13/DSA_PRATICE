public class LeetCode3335 {
    public int lengthAfterTransformations(String s, int t) {
        int[] freq = new int[26];

        // Count the frequency of each character
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int mod = 1000000007;

        // Perform transformations
        for (int i = 0; i < t; i++) {
            int[] newFreq = new int[26];

            for (int j = 25; j >= 0; j--) {
                if (j == 25) { // If it's 'z'
                    newFreq[0] = (newFreq[0] + freq[j]) % mod; // 'z' becomes 'a'
                    newFreq[1] = (newFreq[1] + freq[j]) % mod; // 'z' also becomes 'b'
                } else {
                    newFreq[j + 1] = (newFreq[j + 1] + freq[j]) % mod; // Shift to the next character
                }
            }

            // Update freq to be newFreq for the next iteration
            freq = newFreq;
        }

        // Calculate the total remaining characters
        long ans = 0; // Use long to avoid overflow
        for (int count : freq) {
            ans = (ans + count) % mod; // Keep the result within the modulo
        }

        return (int) ans; // Return the result as an int
    }

    public static void main(String[] args) {
        LeetCode3335 obj = new LeetCode3335();
        System.out.println(obj.lengthAfterTransformations("k", 10)); // Example input
        System.out.println(obj.lengthAfterTransformations("jqktcurgdvlibczdsvnsg", 7517)); // Test case
    }
}

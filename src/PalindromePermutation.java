import java.lang.*;
public class PalindromePermutation
{ 
    
    public boolean checkPalindromPermutation(String str) {
        char [] charr = str.toCharArray();
        boolean [] states = new boolean[128];
        int countOdd=0;
        for(int i=0; i<str.length(); i++) {
            int val = charr[i] - 'a';
            states[val] = !states[val];
            //keep updating countOdd 
            countOdd = (states[val]==true) ? countOdd + 1 : countOdd -1;
        }
        return countOdd < 2;
    }
    
    public int toggle(int bVector, int idx) {
        int masking = 1 << idx; 
        if((bVector & masking) == 0) {
            bVector = bVector | masking;
        } else {
            bVector = bVector & ~masking;
        }
        return bVector;
    } 
    
    public boolean checkPalindromPermutationBitwise(String str) {
        char [] charr = str.toCharArray();
        int bitVector = 0;
        for (int i=0;i<str.length() ; i++ ) {
            int val = charr[i] - 'a';
            if(0 < val && val < 27) {
                bitVector = toggle(bitVector, val);
            }
        } 
        return (bitVector == 0) || (bitVector & (bitVector - 1)) == 0;
    }
    
    //Main program
    public static void main(String args[]) {
        PalindromePermutation pp = new PalindromePermutation();
        System.out.println("PalindromePermutation(bitwise): " + pp.checkPalindromPermutationBitwise("cprakashrphs"));
        System.out.println("PalindromePermutation: " + pp.checkPalindromPermutation("aabbccdd"));
    }
}
import java.util.Arrays;

public class StringPermutations // check whther given 2 strings aer permutations to each
{ 
    //sorting based method - O(nlog) + O(n) => O(nlog) w/o using extra space
    boolean checkStrPermutationsSortMethod(String str1, String str2) {
        //firtl level check
        if(str1.length() != str2.length()) return false;
        //performing sorting
        char[] charr1 = str1.toCharArray();
        char[] charr2 = str2.toCharArray();
        Arrays.sort(charr1);
        Arrays.sort(charr2);
        for (int i=0;i<charr1.length;i++ ) {
            if(charr1[i] != charr2[i])
            return false;
        } 
        return true;
    }
    //hash based method - O(n) with using fix size extra space
    boolean checkStrPermutationsEfficientMethod(String str1, String str2) {
        //firtl level check
        if(str1.length() != str2.length()) return false;
        char[] charr1 = str1.toCharArray();
        char[] charr2 = str2.toCharArray();
        int[] hash = new int[256];
        for (int i=0;i<charr1.length;i++ ) {
            int val = charr1[i] - 'A';
            hash[val]++;
        } 
        for (int i=0;i<charr2.length;i++ ) {
            int val = charr2[i] - 'A';
            hash[val]--;
            if(hash[val] < 0)
                return false;
        }
        return true;
    }
    
    //Main program
    public static void main(String args[]) {
        StringPermutations permutations = new StringPermutations();
        System.out.println("Strings are permuted(sortng): " + permutations.checkStrPermutationsSortMethod("Chhipa", "apiChh"));
        System.out.println("Strings are permuted(hashtable): " + permutations.checkStrPermutationsEfficientMethod("Chhipa", "apiChh"));
    }
}
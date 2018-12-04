
public class SubStringAnagramsSearch
{  
    public boolean helperCompare(int[] arr1, int[] arr2) {
        for (int i=0; i<256;i++ ) {
            if(arr1[i] != arr2[i])
                return false;
        } 
        return true;
    }
    
    public void searchAnagrams(String text, String pattern) {
        int N = text.length();
        int M = pattern.length();
        if(M>N)
            return;
        int[] countText = new int[256];
        int[] countPattern = new int[256];
        //initial feeds for frequencies
        for(int i=0; i< M ; i++) {
            int val = text.charAt(i) - 'A';
            int val1 = pattern.charAt(i) - 'A';
            countText[val]++;
            countPattern[val1]++;
        }
        
        for (int i =M; i< N; i++) {
            if(helperCompare(countText, countPattern))
                System.out.println((i-M));
            int val = text.charAt(i - M) - 'A';
            int val1 = text.charAt(i) - 'A';
            countText[val]--;
            countText[val1]++;
        }
        if(helperCompare(countText, countPattern))
                System.out.println((N-M));
    }
    
    //Main program
    public static void main(String args[]) {
       SubStringAnagramsSearch anagrams = new SubStringAnagramsSearch();
       anagrams.searchAnagrams("prakashchhipapraksh", "aks");
    }
}`
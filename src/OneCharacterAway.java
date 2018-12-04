
public class OneCharacterAway // supports three operations insert, removal & replacement of one character
{   //need to figure out if given two strings are one character away or not 
    
    boolean helperOneEditInsert(String str1, String str2) {
        int idx1=0, idx2=0;
        while(idx1 < str1.length() && idx2< str2.length()) {
            if(str1.charAt(idx1) != str2.charAt(idx2)) {
                if(idx1 != idx2)
                    return false;
                idx2++;
            } else {
                idx1++;
                idx2++;
            }
        } 
        return true;
    }
    
    boolean helperOneEditReplace(String str1, String str2) {
        boolean raiseFlag = false;
        for(int i=0 ; i< str1.length(); i++) {
            if(str1.charAt(i) != str2.charAt(i)) {
                if(raiseFlag) 
                    return false;
                raiseFlag = true;
            }
        }
        return true;
    }
    
    //Callee Function
    boolean oneEdit(String str1, String str2) {
        if(Math.abs(str1.length() - str2.length()) > 1)
            return false;
        if (str1.length() == str2.length()) 
            return helperOneEditReplace(str1, str2);
        if(str1.length() + 1 == str2.length()) 
            return helperOneEditInsert(str1, str2);
        if(str1.length() - 1 == str2.length()) 
            return helperOneEditInsert(str2, str1);
        return true;
    }
    
    
    //Main program
    public static void main(String args[]) {
        OneCharacterAway oneaway = new OneCharacterAway();
        System.out.println("Boths strings are one away: " + oneaway.oneEdit("chhipa", "chipa"));
        System.out.println("Boths strings are one away: " + oneaway.oneEdit("chhpa", "chhipa"));
        System.out.println("Boths strings are one away: " + oneaway.oneEdit("chhpa", "chhiipa"));
        System.out.println("Boths strings are one away: " + oneaway.oneEdit("chhipa", "chpipa"));
        System.out.println("Boths strings are one away: " + oneaway.oneEdit("chhipa", "chpiha"));
    }
}


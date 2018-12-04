
public class StringRotationCheckThroughSubStringMethod
{  
    //only subString exisit or not can be called once - in java ts contains method
    public boolean rotationExist(String str1, String str2) {
        if (str1.length() != str2.length())
            return false;
        //make it double - think like breaking a loop or circle made of two instance of string
        return (str1 + str1).contains(str2);
    }
    //Main program
    public static void main(String args[]) {
       StringRotationCheckThroughSubStringMethod rotation = new StringRotationCheckThroughSubStringMethod();
       System.out.println(rotation.rotationExist("prakashchhipa", "chhipaprakash"));
    }
}


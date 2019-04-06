package services;

public class Validator {

    public static boolean isNullOrEmpty(String str){
        if(str != null && !str.isEmpty())
            return false;
        return true;
    }
}

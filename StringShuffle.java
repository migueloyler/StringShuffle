
/**
 * A Dyncamic Programming implementation of string shuffle
 *
 * @author Miguel and Vincent
 * @version 1
 */
import java.util.List;
import java.util.ArrayList;

/**
 * StringShuffle's method isShuffle recursively determines wether string C is a shuffle of A and B by checking if the last char
 * of A or B matches the last char of C, if this is the case, then we can pop off the last char of whichever matched (A or B), 
 * if they both match, just give string A priority. The function then makes a recursive call to itself with the last char of 
 * C popped off and the last char of [A / B] (wichever matched) popped off. 
 */
public class StringShuffle
{
    /**
     * @param:
     * String A - one of the strings
     * String B - the other string
     * String C - the Shuffle of A and B that we will be testing
     * ArrayList<Boolean> T - the table we will use for dynamic programming to store our solutions so we don't solve the same
     * problem twice
     * 
     * @return
     * true if String C is a shuffle of A and B
     * false if C is not a shuffle of A and B
     */
    public boolean isShuffle(String A, String B, String C, ArrayList<Boolean> T){
        if (C.length() == 0 && (A.length() > 0 || B.length() > 0)) {
            T.add(C.length() - 1, false);
            return false;
        }
        if (C.length() == 0){
            T.add(C.length() - 1, true);
            return true;
        }
        if (T.size() >= C.length()) {
            if (T.get(C.length() - 1)) return true;
        }
        if(A.length() != 0) { //make sure A isn't empty string
            if(A.charAt(A.length() - 1) == (C.charAt(C.length() - 1))){
                if (isShuffle(A.substring(0, A.length() - 1), B, C.substring(0, C.length() - 1), T)) {
                    T.add(C.length() - 1, true);
                    return true;
                }
            }
        }
        if (B.length() != 0) { //make sure B isn't an empty string
            if(B.charAt(B.length() - 1) == (C.charAt(C.length() - 1))){
                if (isShuffle(A, B.substring(0, B.length() - 1), C.substring(0, C.length() - 1), T)) {
                    T.add(C.length() - 1, true);
                    return true;
                }
            }
        }
        T.add(C.length() - 1, false); //probably a good idea to store false so that we don't overlap
        return false;
    }
    
    public static void main(String[] args){
        StringShuffle shuff = new StringShuffle();
        //ArrayList<Boolean> T = new ArrayList<Boolean>();
        String C = "";
        String A = "";
        String B = "";
        ArrayList<Boolean> T = new ArrayList<Boolean>();
        if (shuff.isShuffle(A, B, C, T)) System.out.println("tru");
        else System.out.println("nah");
    }
}

package c03.ppl.hidupsehat.Tools;

/**
 * Created by wahyuoi on 08/04/15.
 */
public class Misc {
    public static boolean isPositiveNumeric(String str)
    {
        for (char c : str.toCharArray())
        {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }
}

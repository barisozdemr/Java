
import java.util.ArrayList;


public class Wrapper {
    
    private ArrayList<Integer> intList;
    private ArrayList<String> strList;
    
    public Wrapper(ArrayList<Integer> intList, ArrayList<String> strList)
    {
        this.intList = intList;
        this.strList = strList;
    }
    
    public ArrayList<Integer> getIntList()
    {
        return intList;
    }
    public ArrayList<String> getStrList()
    {
        return strList;
    }
}

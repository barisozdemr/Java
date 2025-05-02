
public class Main 
{
    public static void main(String[] args)
    {
        Thread mainThread = Thread.currentThread();
        
        String input = "HOOHHHOOOHHHHHHOHHHOHHHHOHO";
        
        BuildH2O build = new BuildH2O(input, mainThread);
        
        build.calistir();
    }
}

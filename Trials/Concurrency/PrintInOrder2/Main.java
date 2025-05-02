import java.util.logging.Level;
import java.util.logging.Logger;

public class Main 
{
    public static void main(String[] args)
    {
        int[] nums = {1, 2, 3};
        
        PrintInOrder print = new PrintInOrder();
        
        for(int i=0 ; i<nums.length ; i++)
        {
            if(nums[i] == 1)
            {
                try {
                    print.first(() -> {System.out.println("first");});
                }
                catch (InterruptedException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else if(nums[i] == 2)
            {
                try {
                    print.second(() -> {System.out.println("second");});
                }
                catch (InterruptedException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else if(nums[i] == 3)
            {
                try {
                    print.third(() -> {System.out.println("third");});
                }
                catch (InterruptedException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        System.out.println();
    }
}

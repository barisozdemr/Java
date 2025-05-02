
import java.util.LinkedList;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;


public class BuildH2O {
    
    private final String input;
    
    private final Semaphore sem1;
    private final Semaphore sem2;
    
    private final Thread mainThread;
    
    public BuildH2O(String input, Thread mainThread)
    {
        this.input = input;
        
        sem1 = new Semaphore(0);
        sem2 = new Semaphore(0);
        
        this.mainThread = mainThread;
    }
    
    Runnable releaseHydrogen = new Runnable() {
        @Override
        public void run() 
        {
            System.out.print("H");
        }
    };
    
    Runnable releaseOxygen = new Runnable() {
        @Override
        public void run()
        {
            System.out.print("O");
        }
    };
    
    Thread t1 = new Thread(new Runnable() {               // Thread 1 - Hydrogen "H"
        @Override
        public void run() 
        {
            try {
                hydrogen(releaseHydrogen);
            }
            catch (InterruptedException ex) {
                Logger.getLogger(BuildH2O.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    });
    
    Thread t2 = new Thread(new Runnable() {               // Thread 2 - Oxygen "O"
        @Override
        public void run() 
        {
            try {
                oxygen(releaseOxygen);
            }
            catch (InterruptedException ex) {
                Logger.getLogger(BuildH2O.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    });
    
    public void permits()
    {
        LinkedList<Character> list = new LinkedList();
        
        int h_count = 0;
        int o_count = 0;
        
        for(int i=0 ; i<input.length() ; i++)
        {
            list.add(input.charAt(i));
        }
        
        System.out.println(list);
        
        for(int i=0 ; i<input.length() ; i++)
        {
            if(h_count != 2 && list.get(i) == 'H')          // "H" Permit
            {
                h_count ++;
                i--;
                list.remove((Character)'H');
                
                sem1.release();
                
                while (true)
                {                    
                    try {
                        Thread.sleep(10000);
                    }
                    catch (InterruptedException ex) {
                        break;
                    }
                }
                
                if(list.isEmpty())
                {
                    t1.interrupt();
                    t2.interrupt();
                    break;
                }
                
                
            }
            else if(o_count != 1 && list.get(i) == 'O')          // "O" Permit
            {
                o_count ++;
                i--;
                
                sem2.release();
                
                while (true)
                {                    
                    try {
                        Thread.sleep(10000);
                    }
                    catch (InterruptedException ex) {
                        break;
                    }
                }
                
                list.remove((Character)'O');
                
                if(list.isEmpty())
                {
                    t1.interrupt();
                    t2.interrupt();
                    break;
                }
            }
            if(h_count == 2 && o_count == 1)
            {
                h_count = 0;
                o_count = 0;
                i=-1;
            }
        }
    }
    
    public void calistir()
    {
        t1.start();
        t2.start();
        
        permits();
    }
    
    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
		
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        while (true) 
        {
            try {
                sem1.acquire();
            }
            catch (InterruptedException e) {
                break;
            }
            
            releaseHydrogen.run();
            mainThread.interrupt();
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        while (true) 
        {
            try {
                sem2.acquire();
            }
            catch (InterruptedException e) {
                break;
            }
            
            releaseOxygen.run();
            mainThread.interrupt();
        }
    }
}

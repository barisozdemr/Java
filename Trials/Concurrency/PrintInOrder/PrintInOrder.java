import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PrintInOrder {
    private final int[] nums;
    
    private final Semaphore sem1;
    private final Semaphore sem2;
    private final Semaphore sem3;
    
    public PrintInOrder(int[] nums)
    {
        this.nums = nums;
        sem1 = new Semaphore(0);
        sem2 = new Semaphore(0);
        sem3 = new Semaphore(0);
    }
    
    Runnable printFirst = new Runnable(){
            
            @Override
            public void run()
            {
                System.out.println("first");
            }
        };
        
    Runnable printSecond = new Runnable(){

        @Override
        public void run()
        {
            System.out.println("second");
        }
    };

    Runnable printThird = new Runnable(){

        @Override
        public void run()
        {
            System.out.println("third");
        }
    };

    Thread t1 = new Thread(new Runnable(){               // Thread 1

        @Override
        public void run()
        {
            try {
                first(printFirst);
            }
            catch (InterruptedException ex) {
                Logger.getLogger(PrintInOrder.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    });

    Thread t2 = new Thread(new Runnable(){               // Thread 2

        @Override
        public void run()
        {
            try {
                second(printSecond);
            }
            catch (InterruptedException ex) {
                Logger.getLogger(PrintInOrder.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    });

    Thread t3 = new Thread(new Runnable(){               // Thread 3

        @Override
        public void run()
        {
            try {
                third(printThird);
            }
            catch (InterruptedException ex) {
                Logger.getLogger(PrintInOrder.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    });
    
    public void permits()                             // Permit Distribution
    {
        for(int i=0 ; i<nums.length ; i++)
        {
            if(nums[i] == 1)
            {
                sem1.release();
                
                try {
                    t1.join();
                }
                catch (InterruptedException ex) {
                    Logger.getLogger(PrintInOrder.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else if(nums[i] == 2)
            {
                sem2.release();
                
                try {
                    t2.join();
                }
                catch (InterruptedException ex) {
                    Logger.getLogger(PrintInOrder.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else if(nums[i] == 3)
            {
                sem3.release();
                
                try {
                    t3.join();
                }
                catch (InterruptedException ex) {
                    Logger.getLogger(PrintInOrder.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public void calistir()
    {
        t1.start();
        t2.start();
        t3.start();
        
        permits();
    }
    
    public void first(Runnable printFirst) throws InterruptedException {
        
        // printFirst.run() outputs "first". Do not change or remove this line.
        sem1.acquire();
        printFirst.run();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        
        // printSecond.run() outputs "second". Do not change or remove this line.
        sem2.acquire();
        printSecond.run();
    }

    public void third(Runnable printThird) throws InterruptedException {
        
        // printThird.run() outputs "third". Do not change or remove this line.
        sem3.acquire();
        printThird.run();
    }
}
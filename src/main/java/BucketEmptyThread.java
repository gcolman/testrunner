import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BucketEmptyThread implements Runnable {

	private int sleeptime;
	
 public BucketEmptyThread(){
	 
 }

 public BucketEmptyThread(int t){
	 sleeptime=t;
 }
 
  public void run() {
	  System.out.println("Thread " +Thread.currentThread() +" started emptying buckets");
	     while(true) {
	         Bucket.removeFromBucket();
	         try {
				Thread.sleep(sleeptime);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	         
	       }
	
  }
}

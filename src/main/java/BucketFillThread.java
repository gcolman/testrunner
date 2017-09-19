import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BucketFillThread implements Runnable {

	private int sleeptime;
	
 public BucketFillThread(){
	 
 }

 public BucketFillThread(int t){
	 sleeptime=t;
 }
 
  public void run() {
	     System.out.println("Thread " +Thread.currentThread() +" started filling buckets");
	     DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");


	     while(true) {
	       Calendar calobj = Calendar.getInstance();
	       String s = df.format(calobj.getTime());
	       Bucket.addToBucket(s);
	       try {
			Thread.sleep(sleeptime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       
	     }	
  }
}

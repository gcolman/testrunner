import java.util.ArrayList;

public class Bucket {

  public static ArrayList bucketlist = new ArrayList();
  public static int reportevery = 0;
  public static int count=0;


  public Bucket(){
  }

  public static void setReportEvery(int r){
	  reportevery = r;
  }
  
  public static void addToBucket(String item) {
      bucketlist.add(item);
      //System.out.println("add to bucket");
      statusout();
  }

  public static void removeFromBucket() {
	  if(bucketlist.size()>50){
		  bucketlist.remove(0);
		  //System.out.println("removed from bucket");
		  statusout();
	  }
  }
  
  private static void statusout(){
	  if(reportevery!=0) {
		  count++;
		  if(count>reportevery) {
			  System.out.println("Size of bucket = " +bucketlist.size());
			  count=0;
		  }
	  }
  }
  
}
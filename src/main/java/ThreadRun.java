public class ThreadRun {

    public static void main(String[] args) {

    int fillers = 40;
    int emptyers = 40;
    int wait = 100;
    int reportlen = 0;
    	
    if(args.length>=2) {	
      fillers = Integer.parseInt(args[0]);
      emptyers = Integer.parseInt(args[1]);
      if(args.length>=3){wait = Integer.parseInt(args[2]);}
      if(args.length>=4){reportlen = Integer.parseInt(args[3]);}
    }
    
    	Bucket.setReportEvery(reportlen);
    	
    
      for(int i=0; i<fillers;i++) {
    	  new Thread(new BucketFillThread(wait)).start();
      }
      
      for(int x=0; x<emptyers;x++) {
    	  new Thread(new BucketEmptyThread(wait)).start();
      }
      

    }

}

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class NMTReader {

    public static void main(String[] args) throws IOException {

        try {

            File f = new File("/home/gcolman/workspace/testrunner/src/main/resources/data.txt");

            BufferedReader b = new BufferedReader(new FileReader(f));

            String readLine = "";
            System.out.println("Total,R,C,Heap,R,C,Class,R,C,Thread,R,C,Code,R,C,GC,R,C,Compiler,R,C,Internal,R,C,Symbol,R,C");
 
            while ((readLine = b.readLine()) != null) {
            	String s = readLine;            	
            	if(!s.contains("TEST")) {
            		            
	            	get(s,"Total", new String[]{"reserved=","KB","committed=","KB"});
	            	get(s,"Heap", new String[]{"reserved=","KB","committed=","KB"});
	            	get(s,"Class", new String[]{"reserved=","KB","committed=","KB"});
	            	get(s,"Thread", new String[]{"reserved=","KB","committed=","KB"});
	            	get(s,"Code", new String[]{"reserved=","KB","committed=","KB"});
	            	get(s,"GC", new String[]{"reserved=","KB","committed=","KB"});
	            	get(s,"Compiler", new String[]{"reserved=","KB","committed=","KB"});
	            	get(s,"Internal", new String[]{"reserved=","KB","committed=","KB"});
	            	get(s,"Symbol", new String[]{"reserved=","KB","committed=","KB"});
            	} else {
            		System.out.println();
            	}
            }
           	

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
    public static void get(String s, String ident, String[] vals){
    	if(s.contains(ident) || ident.equals("NONE")) {
    		System.out.print(ident +",");
    		for(int i=0;i<vals.length;){
    			System.out.print(getsub(s, vals[i], vals[i+1]) +"," );
    			i+=2;	
    		}	
//    		System.out.println("");
    	}
    }
    
    
    public static String getsub( String s, String fromstring, String tostring) {
        int start =0;
        int end=0;
    	//System.out.println(s);
		start = s.indexOf(fromstring)+fromstring.length();
		//System.out.println(start);
		end = s.indexOf(tostring, start);
		return s.substring(start, end);
		
    }
	
	
}

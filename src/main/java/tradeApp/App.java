package tradeApp;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class App 
{
	
	static FileLoader file=new FileLoader();
	
	//*************************Method created for tradedInstrumentVolume*****************************************************
	
	public static HashMap<String, Integer> getTradedInstrumentVolume(String FromDate,String ToDate) throws IOException, ParseException {
		
	Date fromdate=new SimpleDateFormat("dd/MM/yyyy").parse(FromDate);
	Date todate=new SimpleDateFormat("dd/MM/yyyy").parse(ToDate);
		
    List<String> txtData= file.getFileReader("D:\\Assignment\\trades.txt");
	HashMap<String,Integer> hm = new HashMap<String,Integer>();
 
	for(int i=1;i<txtData.size();i++) {
		String strData =txtData.get(i);
		String dataCols[]= strData.split(",");
		String InID =dataCols[2];
		String qty = dataCols[3];
		String date = dataCols[1];
		SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		Date date1=formatter.parse(date); 
		int j=Integer.parseInt(qty);
		 
		if (date1.after(fromdate) && date1.before(todate)){
		
		       if(hm.containsKey(InID)) {
			      int val=hm.get(InID);
			       hm.put(InID,val+j);
			       
		        }
		      else {
			       hm.put(InID, j);
			      //System.out.println( hm.put(InID,j));	  
		         }		       
		}
		else{
			//System.out.println(date1 + " is not in range between " + FromDate + " and " + ToDate);
		}
	}
	return hm;
 
	}
	
////*************************Method created for UnTradedInstrumentVolume*****************************************************
	
    public static List<String> getUnTradedInstrumentVolume(String FromDate,String Todate) throws IOException, ParseException {
    	
    	List<String> txtData1= file.getFileReader("D:\\Assignment\\inst.txt");
    	List<String> untradedList = new ArrayList();
    	HashMap<String,Integer> hm= App.getTradedInstrumentVolume(FromDate, Todate);	 
    	for(int i=1;i<txtData1.size();i++) {
    		String strline =txtData1.get(i);                                            
    		String strdataCols[]= strline.split(",");
    		String instid = strdataCols[0];	
    		if(!hm.containsKey(strdataCols[0])){
    			untradedList.add(strdataCols[0]); 
    			 
    		}	
	}
    	// System.out.println("Instrument list not present in trade.txt file" + untradedList);
		return untradedList;
   }
  
}

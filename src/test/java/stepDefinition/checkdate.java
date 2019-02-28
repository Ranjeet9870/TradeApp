package stepDefinition;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import tradeApp.App;

public class checkdate {

	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub
		
		String FromDate ="27/11/2017 23:11:01";
		String ToDate ="01/12/2017 23:11:01";
		//Date FromDate=new SimpleDateFormat("dd/MM/yyyy").parse(FromDate);
		//Date todate=new SimpleDateFormat("dd/MM/yyyy").parse(ToDate);
		//App.getTradedInstrumentVolume(FromDate, ToDate);
		App.getUnTradedInstrumentVolume(FromDate, ToDate);

	}

}

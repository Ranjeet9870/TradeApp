package stepDefinition;


import java.util.HashMap;
import java.util.List;

import org.junit.Assert;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import tradeApp.App;

public class TradeStepDefinition {
	

	@Given("^\"(.*?)\" instrument traded date between \"(.*?)\" and \"(.*?)\"$")
	public void instrument_traded_date_between_and(String instid, String FromDate, String ToDate) throws Throwable {
		HashMap<String, Integer> hm = App.getTradedInstrumentVolume(FromDate, ToDate);
		Assert.assertTrue(hm.containsKey(instid));
	}

	@Then("^verify the \"(.*?)\" traded volume between \"(.*?)\" and \"(.*?)\"$")
	public void verify_the_traded_volume_between_and(String instid, String FromDate, String ToDate) throws Throwable {
		HashMap<String, Integer> hm = App.getTradedInstrumentVolume(FromDate, ToDate);
		Assert.assertTrue(hm.containsKey(instid));
	}

	@Given("^all instrument not traded between \"(.*?)\" and \"(.*?)\"$")
	public void all_instrument_not_traded_between_and(String FromDate, String ToDate) throws Throwable {
		List<String> untradedlist = App.getUnTradedInstrumentVolume(FromDate, ToDate);
		Assert.assertTrue(untradedlist.size() > 0);

	}

	@Then("^\"(.*?)\" should be present in the list of untraded instrument between \"(.*?)\" and \"(.*?)\"$")
	public void should_be_present_in_the_list_of_untraded_instrument_between_and(String instid, String FromDate,
			String ToDate) throws Throwable {
		List<String> untradedlist = App.getUnTradedInstrumentVolume(FromDate, ToDate);
		Assert.assertTrue(untradedlist.contains(instid));
	}
	
}

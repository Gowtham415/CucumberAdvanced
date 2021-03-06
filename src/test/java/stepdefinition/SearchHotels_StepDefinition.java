package stepdefinition;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import PageObjects.HomePage;
import PageObjects.ObjectsPage;
import PageObjects.ResultsPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchHotels_StepDefinition {
	private DataVariableClass COMMON_DATA;
	WebDriver driver;

	public SearchHotels_StepDefinition(DataVariableClass data) {
		this.COMMON_DATA = data;
		this.driver = data.driver;
	}

	private ObjectsPage selenium() {
		return COMMON_DATA.selenium();
	}

	@Given("Click on Hotels tab")
	public void click_on_Hotels_tab() {
		selenium().HOMEPAGE.clickHotelsTab();
	}

	@When("User provides city to be searched for hotels")
	public void user_provides_city_to_be_searched_for_hotels(DataTable dataTable) {
		selenium().HOMEPAGE.setDestinationCityForHotels(dataTable.asList().get(0));
	}

	@When("User provides checkin date {string} in to hotel")
	public void user_provides_checkin_date_in_to_hotel(String checkIn) {
		selenium().HOMEPAGE.setCheckInDateForHotel(checkIn);
	}

	@When("User provides checkout date {string} from the hotel")
	public void user_provides_checkout_date_from_the_hotel(String checkOut) {
		selenium().HOMEPAGE.setCheckOutDateForHotel(checkOut);
	}

	@When("User click on search hotel button")
	public void user_click_on_search_hotel_button() {
		selenium().HOMEPAGE.clickOnHotelSearch();
	}

	@Then("User should be able to navigate to search results page for hotels")
	public void user_should_be_able_to_navigate_to_search_results_page_for_hotels() {
		selenium().RESULTSPAGE.titleContains("Hotel Search Results");
	}

	@When("User provide flights data for hotel search")
	public void user_provide_flights_data_for_hotel_search(io.cucumber.datatable.DataTable dataTable) {
		selenium().HOMEPAGE.AddFlightsWithHotel(dataTable.asList().get(0));
	}
	
	@When("User selects multiple adults")
	public void user_selects_multiple_adults() {
	   selenium().HOMEPAGE.setPassengersInHotelsTab(2, 0);
	}

	@When("User selects multiple adults and multiple children")
	public void user_selects_multiple_adults_and_multiple_children() {
		 selenium().HOMEPAGE.setPassengersInHotelsTab(2, 2);
	}
	
	@When("User selects multiple rooms for multiple people")
	public void user_selects_multiple_rooms_for_multiple_people() {
		selenium().HOMEPAGE.setPassengersInHotelsTab(2, 2, 2);
	}

}

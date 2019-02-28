package com.restapiserenitycucumberscreenplay.cucumber;

import com.restapiserenitycucumberscreenplay.screenplay.questions.get.ObtainedAllUsers;
import com.restapiserenitycucumberscreenplay.screenplay.questions.get.ObtainedSingleUser;
import com.restapiserenitycucumberscreenplay.screenplay.questions.StatusOfTheService;
import com.restapiserenitycucumberscreenplay.screenplay.tasks.get.GetAllUsers;
import com.restapiserenitycucumberscreenplay.screenplay.tasks.get.GetSingleUser;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;

public class ReturnUserDataUserStepDefs {
    private Actor javi;
    private String theRestApiBaseUrl;


    @Before
    public void configureBaseUrl() {

        theRestApiBaseUrl = "https://reqres.in/api";
        javi = Actor.named("Javi").whoCan(CallAnApi.at(theRestApiBaseUrl));
    }


    @Given("^the service was up$")
    public void theServiceWasUp() {

        javi.should(seeThat(StatusOfTheService.is(), equalTo("200")));
    }

    @When("^i search for the user with id \"([^\"]*)\"$")
    public void iSearchForTheUserWithId(String arg0) {
        javi.attemptsTo(GetSingleUser.withId(arg0));

    }

    @Then("^the id obtained should be \"([^\"]*)\"$")
    public void theIdObtainedShouldBe(String arg0) {
        javi.should(seeThat(ObtainedSingleUser.id(), equalTo(arg0)));

    }

    @And("^the first_name should be \"([^\"]*)\"$")
    public void theFirst_nameShouldBe(String arg0) {
        javi.should(seeThat(ObtainedSingleUser.firstName(), equalTo(arg0)));

    }

    @And("^the last_name should be \"([^\"]*)\"$")
    public void theLast_nameShouldBe(String arg0) {
        javi.should(seeThat(ObtainedSingleUser.lastName(), equalTo(arg0)));

    }

    @When("^i search for all the users$")
    public void iSearchForAllTheUsers() {
        javi.attemptsTo(GetAllUsers.now());

    }

    @Then("^i should get all the users$")
    public void iShouldGetAllTheUsers() {
        javi.should(seeThat(ObtainedAllUsers.allTheUsersFirstName(), hasItems("George", "Janet", "Emma")));
    }

}

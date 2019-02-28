package com.restapiserenitycucumberscreenplay.cucumber;

import com.restapiserenitycucumberscreenplay.screenplay.questions.post.StatusOfThePost;
import com.restapiserenitycucumberscreenplay.screenplay.tasks.post.AddNewUser;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class AddNewUserUserStepdefs {


    private Actor javi;
    private String theRestApiBaseUrl;


    @Before
    public void configureBaseUrl() {

        theRestApiBaseUrl = "https://reqres.in/api";
        javi = Actor.named("Javi").whoCan(CallAnApi.at(theRestApiBaseUrl));
    }


    @When("^i try to add a new user with name \"([^\"]*)\" and last name \"([^\"]*)\"$")
    public void iTryToAddANewUserWithNameAndLastName(String arg0, String arg1) {
        javi.attemptsTo(AddNewUser.withData(arg0,arg1));
    }

    @Then("^i should see that the new user was added succesfully$")
    public void iShouldSeeThatTheNewUserWasAddedSuccesfully() {
        javi.should(seeThat(StatusOfThePost.value(), equalTo("201")));
        
    }
}

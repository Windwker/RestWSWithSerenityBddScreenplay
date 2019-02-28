package com.restapiserenitycucumberscreenplay.screenplay.tasks.post;

import com.restapiserenitycucumberscreenplay.screenplay.model.User;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AddNewUser implements Task {

    private final String firstName;
    private final String lastName;

    public AddNewUser(String firstName , String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


    @Override
    public <T extends Actor> void performAs(T theActor) {
        User user = new User(firstName,lastName);

        theActor.attemptsTo(Post.to("/users").with(request-> request.header("Content-Type","application/json")
                .body(user)));


    }


    public static AddNewUser withData(String firstName, String lastName){
    return instrumented(AddNewUser.class, firstName, lastName);
    }

}

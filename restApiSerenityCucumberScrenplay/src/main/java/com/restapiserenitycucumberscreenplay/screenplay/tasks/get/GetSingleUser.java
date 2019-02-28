package com.restapiserenitycucumberscreenplay.screenplay.tasks.get;

import com.restapiserenitycucumberscreenplay.screenplay.model.User;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.Tasks.instrumented;


public class GetSingleUser implements Task {
    public static User user;
    private final String id;

    public GetSingleUser(String id) {
        this.id = id;
    }

    public static GetSingleUser withId(String id) {
        return instrumented(GetSingleUser.class, id);
    }


    @Override
    public <T extends Actor> void performAs(T theActor) {

        theActor.attemptsTo(Get.resource("/users/{id}").with(request-> request.pathParam("id",id)));
        user = SerenityRest.lastResponse().jsonPath().getObject("data", User.class);

    }
}

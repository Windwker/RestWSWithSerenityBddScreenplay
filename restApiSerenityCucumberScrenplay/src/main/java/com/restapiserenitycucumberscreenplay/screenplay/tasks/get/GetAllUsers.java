package com.restapiserenitycucumberscreenplay.screenplay.tasks.get;


import com.restapiserenitycucumberscreenplay.screenplay.model.User;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetAllUsers implements Task {


    public static List<User> listOfUsers;

    @Override
    public <T extends Actor> void performAs(T theActor) {
        theActor.attemptsTo(Get.resource("/users"));
        listOfUsers = SerenityRest.lastResponse().jsonPath().getList("data", User.class);

    }

    public static GetAllUsers now() {
        return instrumented(GetAllUsers.class);
    }

}

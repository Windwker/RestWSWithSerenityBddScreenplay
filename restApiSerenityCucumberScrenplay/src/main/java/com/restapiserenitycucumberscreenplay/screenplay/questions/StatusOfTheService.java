package com.restapiserenitycucumberscreenplay.screenplay.questions;

import com.restapiserenitycucumberscreenplay.screenplay.model.User;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.rest.SerenityRest.get;

public class StatusOfTheService {

    public static Question<String> is() {

        int statuscode = get("https://reqres.in/api/users/").getStatusCode();
        return actor -> Integer.toString(statuscode);

    }
}

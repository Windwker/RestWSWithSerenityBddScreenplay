package com.restapiserenitycucumberscreenplay.screenplay.questions.get;

import com.restapiserenitycucumberscreenplay.screenplay.model.User;
import com.restapiserenitycucumberscreenplay.screenplay.tasks.get.GetSingleUser;
import net.serenitybdd.screenplay.Question;

public class ObtainedSingleUser {


    private static User user = GetSingleUser.user;

    public static Question<String> firstName() {


        return actor -> user.getFirst_name();
    }

    public static Question<String> lastName() {


        return actor -> user.getLast_name();
    }

    public static Question<String> id() {

        return actor -> Integer.toString(user.getId());
    }


}

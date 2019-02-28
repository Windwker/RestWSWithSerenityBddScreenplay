package com.restapiserenitycucumberscreenplay.screenplay.model;


import net.thucydides.core.annotations.Steps;


public class User {
    // Nombre de las variables deben llamarse exactamente igual a lo que devuelve el servicio.
    private int id;
    private String first_name;
    private String last_name;



    public User(String first_name, String last_name){

        this.first_name = first_name;
        this.last_name = last_name;

    }

    public int getId(){
        return id;
    }

    public String getFirst_name(){
        return first_name;

    }

    public String getLast_name(){
        return last_name;
    }



}

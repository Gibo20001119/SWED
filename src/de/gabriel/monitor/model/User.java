package de.gabriel.monitor.model;

public class User {
    private String name;
    private int id;
    private String email;

    // Constructor of User class
    public User(String name, int id, String email) {
        this.name = name;
        this.id = id;
        this.email = email;
    }

    //getter
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }


}

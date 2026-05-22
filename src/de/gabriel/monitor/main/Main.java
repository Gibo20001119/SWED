package de.gabriel.monitor.main;

import de.gabriel.monitor.controller.WebsiteMonitor;
import de.gabriel.monitor.model.User;
import de.gabriel.monitor.model.Website;
import de.gabriel.monitor.service.Notification;

public class Main {
    public static void main(String[] args) {
        WebsiteMonitor monitor = new WebsiteMonitor(); // Create an instance of the WebsiteMonitor class
        
        // Create users
        monitor.createUser("Alice", 1, "alice@test.com");
        User bob = new User("Bob", 2, "bob@test.com");
        Website google = new Website("https://www.google.com");

        monitor.createSubscription("daily", "email", bob, google);

        Notification bobNotification = new Notification(bob);
        monitor.addObserver(bobNotification); // Register Bob's notification as an observer

        monitor.runPeriodicCheck(); // Run the periodic check to see if there are any updates on the subscribed websites

        System.out.println("Nutzer erstellt!");
        System.out.println("Projekt läuft erfolgreich!");
    }
}

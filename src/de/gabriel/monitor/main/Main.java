package de.gabriel.monitor.main;

import de.gabriel.monitor.controller.WebsiteMonitor;
import de.gabriel.monitor.model.User;
import de.gabriel.monitor.model.Website;

public class Main {
    public static void main(String[] args) {
        WebsiteMonitor monitor = new WebsiteMonitor(); // Create an instance of the WebsiteMonitor class
        
        // Create users
        monitor.createUser("Alice", 1, "alice@test.com");
        monitor.createUser("Bob", 2, "bob@test.com");
        
        System.out.println("Nutzer erstellt!");
        System.out.println("Projekt läuft erfolgreich!");
    }
}

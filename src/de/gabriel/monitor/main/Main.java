package de.gabriel.monitor.main;

import de.gabriel.monitor.controller.WebsiteMonitor;
import de.gabriel.monitor.model.User;
import de.gabriel.monitor.model.Website;
import de.gabriel.monitor.service.*;

public class Main {
    public static void main(String[] args) {
        WebsiteMonitor monitor = new WebsiteMonitor();
        User alice = new User("Alice", 1, "alice@test.com");
        Website google = new Website("https://google.com");

        monitor.createSubscription("day", "Email", alice, google);
        monitor.addObserver(new Notification(alice));

        // 1: Standard (HTML-comparison)
        System.out.println("--- Test with HTML ---");
        monitor.runPeriodicCheck();

        // 2: change to TextValue
        System.out.println("\n--- Change to SizeValue ---");
        google.setComparisonStrategy(new ContentSizeStrategy());
        monitor.runPeriodicCheck();
    }
}
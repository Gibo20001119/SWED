package de.gabriel.monitor.service;

import de.gabriel.monitor.model.User;

public class Notification {
    public void sendNotification(User user, String message) { // for calculation: C Metric for de.gabriel.monitor.service.Notification is Cu = 3
        System.out.println("Sending notification to " + user.getEmail() + ": " + message);
    }
}

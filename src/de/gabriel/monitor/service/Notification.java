package de.gabriel.monitor.service;
import de.gabriel.monitor.model.User;
import de.gabriel.monitor.model.Website;

public class Notification implements Observer{
    private User user;

    // we bind the Notification to a user
    public Notification(User user) {
        this.user = user;
    }
    @Override
    public void update(Website website, String message) { // for calculation: C Metric for de.gabriel.monitor.service.Notification is Cu = 3
        System.out.println("Sende Nachricht an " + user.getEmail() + ": " + message);
    }
}

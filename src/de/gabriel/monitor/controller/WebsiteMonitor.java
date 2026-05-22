package de.gabriel.monitor.controller;

import de.gabriel.monitor.model.Subscription;
import de.gabriel.monitor.model.User;
import de.gabriel.monitor.model.Website;
import de.gabriel.monitor.service.Notification;
import de.gabriel.monitor.service.Observer;

import java.util.ArrayList;
import java.util.List;

// This class is responsible for managing users, subscriptions, and the main logic of checking websites and sending notifications.
public class WebsiteMonitor {
    private List<User> users = new ArrayList<>();
    private List<Subscription> subscriptions = new ArrayList<>();

    // NEU: Eine Liste aller angemeldeten Beobachter
    private List<Observer> observers = new ArrayList<>();

    // Methoden, um Beobachter hinzuzufügen oder zu entfernen
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void createUser(String name, int id, String email) {
        User newUser = new User(name, id, email);
        users.add(newUser);
    }

    public void createSubscription(String frequenz, String channel, User user, Website website) {
        Subscription newSubscription = new Subscription(frequenz, channel, user, website);
        subscriptions.add(newSubscription);
    }

    // Die Haupt-Logik benachrichtigt jetzt die Observer
    public void runPeriodicCheck() {
        for (Subscription sub : subscriptions) {
            if (sub.isDueForCheck()) {
                Website site = sub.getWebsite();
                String cuContent = site.fetchCurrentContent();

                if (site.hasChanged(cuContent)) {
                    String message = "Update found on: " + site.getUrl();

                    // NEU: Alle Observer informieren, anstatt Notification direkt aufzurufen
                    for (Observer obs : observers) {
                        obs.update(site, message);
                    }
                }
            }
        }
    }
}

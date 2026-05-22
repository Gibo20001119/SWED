package de.gabriel.monitor.controller;

import de.gabriel.monitor.model.Subscription;
import de.gabriel.monitor.model.User;
import de.gabriel.monitor.model.Website;
import de.gabriel.monitor.service.Notification;

import java.util.ArrayList;
import java.util.List;

// This class is responsible for managing users, subscriptions, and the main logic of checking websites and sending notifications.
public class WebsiteMonitor {
    private List<User> users = new ArrayList<>();
    private List<Subscription> subscriptions = new ArrayList<>();
    private Notification notificationService = new Notification();

    //Creator Prinzipal : Controller creates user
    public void createUser(String name, int id, String email) {
        User newUser = new User(name, id, email); // CMetric for de.gabriel.monitor.model.User is Cu = 2
        users.add(newUser);
    }

    // Creator Prinzipal : Controller creates subscription

    public void createSubscription(String frequenz, String channel, User user, Website website) {
        Subscription newSubscription = new Subscription(frequenz, channel, user, website);
        subscriptions.add(newSubscription);
        // In a real implementation, we would store this subscription in a list
    }

    // The de.gabriel.monitor.main.Main Logic if the System
    public void runPeriodicCheck(){
        for(Subscription sub : subscriptions){
            if(sub.isDueForCheck()){
                Website site = sub.getWebsite();
                String cuContent = site.fetchCurrentContent();

                if(site.hasChanged(cuContent)){
                    notificationService.sendNotification(sub.getUser(), "Update found on: " + site.getUrl());

                }
            }
        }
    }

}

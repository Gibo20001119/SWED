package de.gabriel.monitor.model;

public class Subscription {
    private String frequenz;
    private String communicationChannel;
    private User user; //* Just for calculation: CMetric for de.gabriel.monitor.model.Subscription is Ca = 1
    private Website website;

    // * Constructor of Subscription class
    public Subscription(String frequenz, String communicationChannel, User user, Website website) {
        this.frequenz = frequenz;
        this.communicationChannel = communicationChannel;
        this.user = user;
        this.website = website;
    }
    // * Method to check if the subscription is due for a check
    public boolean isDueForCheck(){
        return true;
    }

    public User getUser() { return user;}
    public Website getWebsite() { return website;}
    public String getChannel () { return communicationChannel;}
}
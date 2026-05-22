package de.gabriel.monitor.model;

import java.util.Date;
import java.lang.String;

public class Website {
    private String url;
    private Date lastExaminationDate;
    private String lastContent;

    // Constructor to initialize the website with its URL
    public Website(String url) {
        this.url = url;
        this.lastExaminationDate = new Date();
        this.lastContent = "";

    }

    // Simulate fetching content from the website
    public String fetchCurrentContent() {
        // Simulate fetching content from the website
        return "Current content of " + url + " at " + new Date();
    }

    // Check if the content has changed since the last examination
    public boolean hasChanged(){
        // get the latest content (previous implementation used an undefined variable newContent)
        String newContent = fetchCurrentContent();
        boolean changed = !this.lastContent.equals(newContent);
        if(changed){
            this.lastContent = newContent;
            this.lastExaminationDate = new Date();
        }
        return changed;
    }

    // Overload: allow callers to provide the fetched content to avoid double-fetching
    public boolean hasChanged(String newContent){
        boolean changed = !this.lastContent.equals(newContent);
        if(changed){
            this.lastContent = newContent;
            this.lastExaminationDate = new Date();
        }
        return changed;
    }

    public String getUrl() {
        return url;
    }
}

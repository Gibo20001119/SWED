package de.gabriel.monitor.service;

import de.gabriel.monitor.model.Website;

public interface Observer {
    void update(Website website, String message);
}

package de.gabriel.monitor.service;

public interface ComparisonStrategy {
    boolean hasChanged(String oldContent, String newContent);
}

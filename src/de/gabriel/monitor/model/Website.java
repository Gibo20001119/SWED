package de.gabriel.monitor.model;

import de.gabriel.monitor.service.ComparisonStrategy;
import de.gabriel.monitor.service.HtmlContentStrategy; // Default

public class Website {
    private String url;
    private String lastContent = "";
    private ComparisonStrategy comparisonStrategy; // Strategy-Referenz

    public Website(String url) {
        this.url = url;
        this.comparisonStrategy = new HtmlContentStrategy(); // Strategy-pattern
    }

    public String getUrl() { return url; }

    // New: Setter for the strategy, allowing dynamic changes at runtime
    public void setComparisonStrategy(ComparisonStrategy strategy) {
        this.comparisonStrategy = strategy;
    }

    public String fetchCurrentContent() {
        return "<html><body>Example Content</body></html>";
    }

    // the method that checks for changes using the strategy
    public boolean hasChanged(String newContent) {
        boolean changed = comparisonStrategy.hasChanged(this.lastContent, newContent);
        if (changed) {
            this.lastContent = newContent;
        }
        return changed;
    }
}
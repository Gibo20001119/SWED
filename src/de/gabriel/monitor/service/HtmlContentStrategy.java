package de.gabriel.monitor.service;

public class HtmlContentStrategy implements ComparisonStrategy {
    @Override
    public boolean hasChanged(String oldContent, String newContent) {
        // we can use a simple string comparison for HTML content, but in a real application, we might want to use a more sophisticated approach (e.g., parsing the HTML and comparing the DOM structure)
        return !oldContent.equals(newContent);
    }
}

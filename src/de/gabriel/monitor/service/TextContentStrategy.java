package de.gabriel.monitor.service;

public class TextContentStrategy implements ComparisonStrategy{
    @Override
    public boolean hasChanged(String oldContent, String newContent) {
        String oldText = oldContent.replaceAll("<[^>]*>", "").trim();
        String newText = newContent.replaceAll("<[^>]*>", "").trim();
        return !oldText.equals(newText);
    }
}

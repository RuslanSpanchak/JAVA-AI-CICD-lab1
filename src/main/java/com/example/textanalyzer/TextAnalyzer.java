package com.example.textanalyzer;

/** Provides small, deterministic text statistics for the console application. */
public final class TextAnalyzer {
    private TextAnalyzer() {
        // Utility class; instances are not required.
    }

    /**
     * Analyzes text and returns word, Unicode code-point, and line counts.
     *
     * @param text input text; must not be null
     * @return immutable analysis result
     * @throws IllegalArgumentException when text is null
     */
    public static Analysis analyze(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Text must not be null.");
        }

        int wordCount = text.isBlank() ? 0 : text.strip().split("(?U)\\s+").length;
        int characterCount = text.codePointCount(0, text.length());
        int lineCount = text.isEmpty() ? 0 : text.split("\\R", -1).length;

        return new Analysis(wordCount, characterCount, lineCount);
    }

    /** Immutable result of a text analysis. */
    public record Analysis(int wordCount, int characterCount, int lineCount) {
    }
}

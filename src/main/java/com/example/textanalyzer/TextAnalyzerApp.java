package com.example.textanalyzer;

import java.util.Scanner;

/** Console entry point for the text analyzer. */
public final class TextAnalyzerApp {
    private TextAnalyzerApp() {
    }

    public static void main(String[] args) {
        String text;
        if (args.length > 0) {
            text = String.join(" ", args);
        } else {
            System.out.print("Enter one line of text: ");
            try (Scanner scanner = new Scanner(System.in)) {
                text = scanner.hasNextLine() ? scanner.nextLine() : "";
            }
        }

        TextAnalyzer.Analysis result = TextAnalyzer.analyze(text);
        System.out.println("Words: " + result.wordCount());
        System.out.println("Characters (Unicode code points): " + result.characterCount());
        System.out.println("Lines: " + result.lineCount());
    }
}

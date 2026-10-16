package com.example.textanalyzer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TextAnalyzerTest {
    @Test
    void countsWordsCharactersAndLinesForRegularText() {
        TextAnalyzer.Analysis result = TextAnalyzer.analyze("Hello world");

        assertEquals(2, result.wordCount());
        assertEquals(11, result.characterCount());
        assertEquals(1, result.lineCount());
    }

    @Test
    void emptyTextHasZeroWordsCharactersAndLines() {
        TextAnalyzer.Analysis result = TextAnalyzer.analyze("");

        assertEquals(0, result.wordCount());
        assertEquals(0, result.characterCount());
        assertEquals(0, result.lineCount());
    }

    @Test
    void whitespaceOnlyTextHasNoWords() {
        TextAnalyzer.Analysis result = TextAnalyzer.analyze(" \t  ");

        assertEquals(0, result.wordCount());
        assertEquals(4, result.characterCount());
        assertEquals(1, result.lineCount());
    }

    @Test
    void countsUnicodeCodePointsRatherThanUtf16CodeUnits() {
        TextAnalyzer.Analysis result = TextAnalyzer.analyze("A😀");

        assertEquals(1, result.wordCount());
        assertEquals(2, result.characterCount());
        assertEquals(1, result.lineCount());
    }

    @Test
    void recognizesUnicodeWhitespaceBetweenWords() {
        TextAnalyzer.Analysis result = TextAnalyzer.analyze("\u2003hello\u2003world\u2003");

        assertEquals(2, result.wordCount());
    }

    @Test
    void handlesDifferentLineSeparatorsAndTrailingNewline() {
        TextAnalyzer.Analysis result = TextAnalyzer.analyze("one\ntwo\r\n");

        assertEquals(2, result.wordCount());
        assertEquals(9, result.characterCount());
        assertEquals(3, result.lineCount());
    }

    @Test
    void rejectsNullInput() {
        assertThrows(IllegalArgumentException.class, () -> TextAnalyzer.analyze(null));
    }
}

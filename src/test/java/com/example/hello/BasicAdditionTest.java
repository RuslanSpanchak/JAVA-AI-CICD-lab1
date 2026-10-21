package com.example.hello;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BasicAdditionTest {
    @Test
    void addsTwoPositiveNumbers() {
        assertEquals(5, BasicAddition.add(2, 3));
    }

    @Test
    void addsANegativeNumber() {
        assertEquals(1, BasicAddition.add(4, -3));
    }

    @Test
    void addingZeroKeepsTheNumberUnchanged() {
        assertEquals(7, BasicAddition.add(7, 0));
    }
}

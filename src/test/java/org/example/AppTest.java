package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class AppTest {
    @Test
    void greets() {
        assertEquals("Hello from audit", App.greet());
    }
}

package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {
    Smartphone smartphone = new Smartphone(3, "Nokia", 100, "Iphone");

    @Test
    void shouldManufacturerDoesNotMatch() {
        String text = "Samsung";
        assertEquals(false, smartphone.matches(text));
    }

    @Test
    void shouldManufacturerCorrespondsTo() {
        String text = "Iphone";
        assertEquals(true, smartphone.matches(text));

    }
}
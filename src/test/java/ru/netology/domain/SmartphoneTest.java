package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {
    Smartphone smartphone = new Smartphone(3, "Smartphone3", 100, "Redmi");

    @Test
    void shouldNotMatchManufacturerOfSmartphone() {
        String text = "Nokia";
        assertEquals(false, smartphone.matches(text));
    }

    @Test
    void shouldMatchManufacturerOfSmartphone() {
        String text = "Redmi";
        assertEquals(true, smartphone.matches(text));

    }
}
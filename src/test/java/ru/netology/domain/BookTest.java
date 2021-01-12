package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    Book book = new Book(4, "Pushkin", 100, "Tolstoi");

    @Test
    void shouldNotMatchAuthorOfBook() {
        String text = "Esenin";
        assertEquals(false, book.matches(text));
    }

    @Test
    void shouldMatchAuthorOfBook() {
        String text = "Tolstoi";
        assertEquals(true, book.matches(text));

    }
}
package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    Book book = new Book(4, "Faust", 100, "Gete");

    @Test
    void shouldNotMatchAuthorOfBook() {
        String text = "Po";
        assertEquals(false, book.matches(text));
    }

    @Test
    void shouldMatchAuthorOfBook() {
        String text = "Gete";
        assertEquals(true, book.matches(text));

    }
}
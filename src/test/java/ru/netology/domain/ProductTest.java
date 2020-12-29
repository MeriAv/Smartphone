package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    Product product = new Product();

    @BeforeEach
    void SetUp() {
        product.setName("Java");
    }


    @Test
    void shouldNotMatchNameOfProduct() {
        String text = "Faust";
        assertEquals(false, product.matches(text));
    }

    @Test
    void shouldMatchNameOfProduct() {
        String text = "Java";
        assertEquals(true, product.matches(text));
    }

}
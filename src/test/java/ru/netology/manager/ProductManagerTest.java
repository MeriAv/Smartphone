package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.*;
import ru.netology.exceptions.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductManagerTest {
    private ProductManager manager = new ProductManager();
    Smartphone first = new Smartphone(1, "Smartphone1", 100, "Redmi");
    Smartphone second = new Smartphone(2, "Smartphone2", 1000, "Huawei");
    Smartphone third = new Smartphone(3, "Smartphone3", 500, "Redmi");
    Book forth = new Book(4, "Faust", 100, "Gete");
    Book fifth = new Book(5, "Faust", 100, "Pushkin");
    Book sixth = new Book(6, "Onegin", 50, "Gete");


    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(forth);
        manager.add(fifth);
        manager.add(sixth);
    }

    @Test
    void shouldRemoveIfExists() {
        int idToRemove = 4;
        manager.removeById(idToRemove);
        Product[] expected = new Product[]{first, second, third, fifth, sixth};
        Product[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGenerateExceptionWhenTryToRemoveMissingElement() {
        int idToRemove = 7;
        Exception e = assertThrows(NotFoundException.class, () -> manager.removeById(idToRemove));
        System.out.println(e.getMessage());
        e.printStackTrace();
    }

    @Test
    void shouldSearchByBookAuthor() {
        String text = "Gete";
        Product[] expected = new Product[]{forth, sixth};
        Product[] actual = manager.searchBy(text);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByBookName() {
        String text = "Faust";
        Product[] expected = new Product[]{forth, fifth};
        Product[] actual = manager.searchBy(text);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBySmartphoneName() {
        String text = "Smartphone2";
        Product[] expected = new Product[]{second};
        Product[] actual = manager.searchBy(text);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBySmartphoneManufacturer() {
        String text = "Redmi";
        Product[] expected = new Product[]{first, third};
        Product[] actual = manager.searchBy(text);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByMissingString() {
        String text = "Figa";
        Product[] expected = new Product[0];
        Product[] actual = manager.searchBy(text);
        assertArrayEquals(expected, actual);
        System.out.println("No such product");
    }
}
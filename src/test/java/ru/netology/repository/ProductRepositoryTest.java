package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
  private ProductRepository repository = new ProductRepository();
  private Book coreJava = new Book(1, "Name1", 500, "Nabokov", 200, 1985);

  @Test
  public void shouldRemoveExist() {

    repository.save(coreJava);
    repository.removeById(1);

    Product[] expected = new Product[]{};
    Product[] actual = repository.findAll();
    assertArrayEquals(expected, actual);
  }

  @Test
  public void shouldRemoveNotExist() {

    Assertions.assertThrows(NotFoundException.class, ()-> {repository.removeById(2);});
  }
}

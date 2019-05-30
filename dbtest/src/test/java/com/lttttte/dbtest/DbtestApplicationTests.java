package com.lttttte.dbtest;

import com.lttttte.dbtest.domain.Book;
import com.lttttte.dbtest.domain.Category;
import com.lttttte.dbtest.repository.BookRepository;
import com.lttttte.dbtest.repository.CategoryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

//import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class DbtestApplicationTests {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void saveEntity(){

        Category category = new Category();
        category.setGenre("컴퓨터장르");
        categoryRepository.save(category);

        Book book = new Book();
        book.setName("운영체제책");
        book.setCategory(category);
        book.getCategory().getBook().add(book);
        bookRepository.save(book);


        Category category2 = new Category();
        category2.setGenre("응용장르");
        categoryRepository.save(category2);
        book.setCategory(category2);
        book.getCategory().getBook().add(book);
        bookRepository.save(book);


//        assertThat(book.getCategory().getGenre()).isEqualTo("컴퓨터장르");
//        assertThat(category.getBook()).contains(book);


//        assertThat(book.getName()).isEqualTo("운영체제");
//        assertThat(category.getGenre()).isEqualTo("컴퓨터");

//        book.setCategory(category);
//        category.setBook(book);
//
//        //One To one
//        //양방향넣기
//        bookRepository.save(book);
//        categoryRepository.save(category);
//
//        assertThat(book.getCategory().getGenre()).isEqualTo("컴퓨터");
//        assertThat(category.getBook().getName()).isEqualTo("운영체제");
    }

}

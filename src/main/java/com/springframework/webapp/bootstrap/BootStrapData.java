package com.springframework.webapp.bootstrap;

import com.springframework.webapp.domain.Author;
import com.springframework.webapp.domain.Book;
import com.springframework.webapp.repositories.AuthorRepository;
import com.springframework.webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Harry potter","123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);


        Author daniel = new Author("Daniel", "John");
        Book hsk = new Book("HSK", "145145");
        daniel.getBooks().add(hsk);
        hsk.getAuthors().add(daniel);


        authorRepository.save(daniel);
        bookRepository.save(hsk);

        System.out.println("Started Bootstrap");
        System.out.println("Number of Books: "+ bookRepository.count());
    }


}

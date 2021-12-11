package com.springframework.webapp.bootstrap;

import com.springframework.webapp.domain.Author;
import com.springframework.webapp.domain.Book;
import com.springframework.webapp.domain.Publisher;
import com.springframework.webapp.repositories.AuthorRepository;
import com.springframework.webapp.repositories.BookRepository;
import com.springframework.webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started Bootstrap");


        Publisher publisher = new Publisher();
        publisher.setName("SFG Publishing");
        publisher.setCity("Fushun");
        publisher.setState("Liaoning");

        publisherRepository.save(publisher);
        System.out.println("publisher count: "+ publisherRepository.count());

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Harry potter","123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);


        Author daniel = new Author("Daniel", "John");
        Book hsk = new Book("HSK", "145145");
        daniel.getBooks().add(hsk);
        hsk.getAuthors().add(daniel);

        hsk.setPublisher(publisher);
        publisher.getBooks().add(hsk);

        authorRepository.save(daniel);
        bookRepository.save(hsk);
        publisherRepository.save(publisher);


        System.out.println("Number of Books: "+ bookRepository.count());
        System.out.println("publisher number of Books: "+ publisher.getBooks().size());
    }


}

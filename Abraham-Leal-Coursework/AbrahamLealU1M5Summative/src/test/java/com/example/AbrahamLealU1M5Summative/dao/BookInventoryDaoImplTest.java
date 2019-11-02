package com.example.AbrahamLealU1M5Summative.dao;

import com.example.AbrahamLealU1M5Summative.model.Author;
import com.example.AbrahamLealU1M5Summative.model.Book;
import com.example.AbrahamLealU1M5Summative.model.Publisher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BookInventoryDaoImplTest {

    @Autowired
    protected AuthorDao authorDao;
    @Autowired
    protected BookDao bookDao;
    @Autowired
    protected PublisherDao publisherDao;

    @Before
    public void setUp() throws Exception {
        // clean out the test db
        List<Book> books = bookDao.getAllBooks();

        books.stream()
                .forEach(book -> bookDao.deleteBook(book.getBookId()));

        List<Author> authors = authorDao.getAllAuthors();

        authors.stream()
                .forEach(author -> authorDao.deleteAuthor(author.getAuthorId()));

        List<Publisher> publishers = publisherDao.getAllPublishers();

        publishers.stream()
                .forEach(publisher -> publisherDao.deletePublisher(publisher.getPublisherId()));

   }


    @Test
    public void addAuthor() {
        assertEquals(0, authorDao.getAllAuthors().size());
        Author author = new Author();
        author.setFirstName("Mark");
        author.setLastName("Twain");
        author.setStreet("Mississippi St");
        author.setCity("Hartford");
        author.setState("CT");
        author.setPostalCode("00077");
        author.setPhone("123-456-7890");
        author.setEmail("samuel.clemens@marktwain.com");
        authorDao.addAuthor(author);

        assertEquals(1, authorDao.getAllAuthors().size());

        Author author1 = authorDao.getAuthor(author.getAuthorId());

        assertEquals(author, author1);
    }

    @Test
    public void getAuthor() {
            Author author = new Author();
            author.setFirstName("Mark");
            author.setLastName("Twain");
            author.setStreet("Mississippi St");
            author.setCity("Hartford");
            author.setState("CT");
            author.setPostalCode("00077");
            author.setPhone("123-456-7890");
            author.setEmail("samuel.clemens@marktwain.com");
            authorDao.addAuthor(author);

            assertEquals(author, authorDao.getAuthor(author.getAuthorId()));
    }

    @Test
    public void getAllAuthors() {
        Author author = new Author();
        author.setFirstName("Mark");
        author.setLastName("Twain");
        author.setStreet("Mississippi St");
        author.setCity("Hartford");
        author.setState("CT");
        author.setPostalCode("00077");
        author.setPhone("123-456-7890");
        author.setEmail("samuel.clemens@marktwain.com");
        authorDao.addAuthor(author);

        Author author1 = new Author();
        author1.setFirstName("Samuel");
        author1.setLastName("Clemens");
        author1.setStreet("Mississippi St");
        author1.setCity("Florida");
        author1.setState("MO");
        author1.setPostalCode("12345");
        author1.setPhone("777-666-5555");
        author1.setEmail("mark.twains@marktwain.com");
        authorDao.addAuthor(author1);

        assertEquals(authorDao.getAllAuthors().size(), 2);
    }

    @Test
    public void updateAuthor() {
        Author author = new Author();
        author.setFirstName("Mark");
        author.setLastName("Twain");
        author.setStreet("Mississippi St");
        author.setCity("Hartford");
        author.setState("CT");
        author.setPostalCode("00077");
        author.setPhone("123-456-7890");
        author.setEmail("samuel.clemens@marktwain.com");
        authorDao.addAuthor(author);

        author.setFirstName("Samuel");
        author.setLastName("Clemens");
        author.setStreet("Mississippi St");
        author.setCity("Florida");
        author.setState("MO");
        author.setPostalCode("12345");
        author.setPhone("777-666-5555");
        author.setEmail("mark.twains@marktwain.com");

        authorDao.updateAuthor(author);

        Author author1 = authorDao.getAuthor(author.getAuthorId());

        assertEquals(author, author1);

    }

    @Test
    public void deleteAuthor() {
        Author author = new Author();
        author.setFirstName("Mark");
        author.setLastName("Twain");
        author.setStreet("Mississippi St");
        author.setCity("Hartford");
        author.setState("CT");
        author.setPostalCode("00077");
        author.setPhone("123-456-7890");
        author.setEmail("samuel.clemens@marktwain.com");
        authorDao.addAuthor(author);

        Author author1 = new Author();
        author1.setFirstName("Samuel");
        author1.setLastName("Clemens");
        author1.setStreet("Mississippi St");
        author1.setCity("Florida");
        author1.setState("MO");
        author1.setPostalCode("12345");
        author1.setPhone("777-666-5555");
        author1.setEmail("mark.twains@marktwain.com");
        authorDao.addAuthor(author1);

        assertEquals(2, authorDao.getAllAuthors().size());

        authorDao.deleteAuthor(author1.getAuthorId());

        assertEquals(1, authorDao.getAllAuthors().size());

    }

    @Test
    public void addPublisher() {
        assertEquals(0, publisherDao.getAllPublishers().size());
        Publisher publisher = new Publisher();
        publisher.setName("Chatto & Windus ");
        publisher.setStreet("1745 Broadway");
        publisher.setCity("New York");
        publisher.setState("NY");
        publisher.setPostalCode("10032");
        publisher.setPhone("212-666-7677");
        publisher.setEmail("penguin@randomhouse.com");

        publisherDao.addPublisher(publisher);

        assertEquals(1, publisherDao.getAllPublishers().size());

        Publisher publisher1 = publisherDao.getPublisher(publisher.getPublisherId());

        assertEquals(publisher, publisher1);
    }

    @Test
    public void getPublisher() {
        Publisher publisher = new Publisher();
        publisher.setName("Chatto & Windus ");
        publisher.setStreet("1745 Broadway");
        publisher.setCity("New York");
        publisher.setState("NY");
        publisher.setPostalCode("10032");
        publisher.setPhone("212-666-7677");
        publisher.setEmail("penguin@randomhouse.com");

        publisherDao.addPublisher(publisher);

        assertEquals(publisher, publisherDao.getPublisher(publisher.getPublisherId()));

    }

    @Test
    public void getAllPublishers() {
        Publisher publisher = new Publisher();
        publisher.setName("Chatto & Windus ");
        publisher.setStreet("1745 Broadway");
        publisher.setCity("New York");
        publisher.setState("NY");
        publisher.setPostalCode("10032");
        publisher.setPhone("212-666-7677");
        publisher.setEmail("penguin@randomhouse.com");

        publisherDao.addPublisher(publisher);

        assertEquals(1, publisherDao.getAllPublishers().size());

        Publisher publisher1 = new Publisher();
        publisher1.setName("John Wiley & Sons, Inc.");
        publisher1.setStreet("111 River Street");
        publisher1.setCity("Hoboken");
        publisher1.setState("NJ");
        publisher1.setPostalCode("07030");
        publisher1.setPhone("201-777-4949");
        publisher1.setEmail("wiley@wileyandsons.com");

        publisherDao.addPublisher(publisher1);

        assertEquals(2, publisherDao.getAllPublishers().size());

    }

    @Test
    public void updatePublisher() {
        Publisher publisher = new Publisher();
        publisher.setName("Chatto & Windus ");
        publisher.setStreet("1745 Broadway");
        publisher.setCity("New York");
        publisher.setState("NY");
        publisher.setPostalCode("10032");
        publisher.setPhone("212-666-7677");
        publisher.setEmail("penguin@randomhouse.com");

        publisherDao.addPublisher(publisher);

        publisher.setName("John Wiley & Sons, Inc.");
        publisher.setStreet("111 River Street");
        publisher.setCity("Hoboken");
        publisher.setState("NJ");
        publisher.setPostalCode("07030");
        publisher.setPhone("201-777-4949");
        publisher.setEmail("wiley@wileyandsons.com");

        publisherDao.updatePublisher(publisher);

        assertEquals(publisher, publisherDao.getPublisher(publisher.getPublisherId()));

    }

    @Test
    public void deletePublisher() {
        Publisher publisher = new Publisher();
        publisher.setName("Chatto & Windus ");
        publisher.setStreet("1745 Broadway");
        publisher.setCity("New York");
        publisher.setState("NY");
        publisher.setPostalCode("10032");
        publisher.setPhone("212-666-7677");
        publisher.setEmail("penguin@randomhouse.com");

        publisherDao.addPublisher(publisher);

        Publisher publisher1 = new Publisher();
        publisher1.setName("John Wiley & Sons, Inc.");
        publisher1.setStreet("111 River Street");
        publisher1.setCity("Hoboken");
        publisher1.setState("NJ");
        publisher1.setPostalCode("07030");
        publisher1.setPhone("201-777-4949");
        publisher1.setEmail("wiley@wileyandsons.com");

        publisherDao.addPublisher(publisher1);

        assertEquals(2, publisherDao.getAllPublishers().size());

        publisherDao.deletePublisher(publisher.getPublisherId());

        assertEquals(1, publisherDao.getAllPublishers().size());
    }

    @Test
    public void addBook() {
        List<Author> authors = helperLoadAuthors();
        List<Publisher> publishers = helperLoadPublishers();

        Book book = new Book();
        book.setIsbn("9781101628270");
        book.setPublishDate(Date.valueOf("1884-12-10"));
        book.setAuthorId(authors.get(0).getAuthorId());
        book.setTitle("The Adventures of Huckleberry Finn");
        book.setPublisherId(publishers.get(0).getPublisherId());
        book.setPrice(12.99);

        assertEquals(0, bookDao.getAllBooks().size());

        bookDao.addBook(book);

        assertEquals(1, bookDao.getAllBooks().size());

        Book book1 = bookDao.getBook(book.getBookId());

        assertEquals(book, book1);

    }

    @Test
    public void getBook() {
        List<Author> authors = helperLoadAuthors();
        List<Publisher> publishers = helperLoadPublishers();

        Book book = new Book();
        book.setIsbn("9781101628270");
        book.setPublishDate(Date.valueOf("1884-12-10"));
        book.setAuthorId(authors.get(0).getAuthorId());
        book.setTitle("The Adventures of Huckleberry Finn");
        book.setPublisherId(publishers.get(0).getPublisherId());
        book.setPrice(12.99);

        bookDao.addBook(book);

        assertEquals(book, bookDao.getBook(book.getBookId()));

    }

    @Test
    public void getAllBooks() {
        List<Author> authors = helperLoadAuthors();
        List<Publisher> publishers = helperLoadPublishers();

        Book book = new Book();
        book.setIsbn("9781101628270");
        book.setPublishDate(Date.valueOf("1884-12-10"));
        book.setAuthorId(authors.get(0).getAuthorId());
        book.setTitle("The Adventures of Huckleberry Finn");
        book.setPublisherId(publishers.get(0).getPublisherId());
        book.setPrice(12.99);

        bookDao.addBook(book);

        Book book1 = new Book();
        book1.setIsbn("9788373191723");
        book1.setPublishDate(Date.valueOf("1954-07-29"));
        book1.setAuthorId(authors.get(1).getAuthorId());
        book1.setTitle("The Lord of the Rings");
        book1.setPublisherId(publishers.get(1).getPublisherId());
        book1.setPrice(29.99);

        bookDao.addBook(book1);

        assertEquals(2, bookDao.getAllBooks().size());
    }

    @Test
    public void updateBook() {
        List<Author> authors = helperLoadAuthors();
        List<Publisher> publishers = helperLoadPublishers();

        Book book = new Book();
        book.setIsbn("9781101628270");
        book.setPublishDate(Date.valueOf("1884-12-10"));
        book.setAuthorId(authors.get(0).getAuthorId());
        book.setTitle("The Adventures of Huckleberry Finn");
        book.setPublisherId(publishers.get(0).getPublisherId());
        book.setPrice(12.99);

        bookDao.addBook(book);

        book.setIsbn("9788373191723");
        book.setPublishDate(Date.valueOf("1954-07-29"));
        book.setAuthorId(authors.get(1).getAuthorId());
        book.setTitle("The Lord of the Rings");
        book.setPublisherId(publishers.get(1).getPublisherId());
        book.setPrice(19.99);

        bookDao.updateBook(book);

        assertEquals(book, bookDao.getBook(book.getBookId()));
    }

    @Test
    public void deleteBook() {
        List<Author> authors = helperLoadAuthors();
        List<Publisher> publishers = helperLoadPublishers();

        Book book = new Book();
        book.setIsbn("9781101628270");
        book.setPublishDate(Date.valueOf("1884-12-10"));
        book.setAuthorId(authors.get(0).getAuthorId());
        book.setTitle("The Adventures of Huckleberry Finn");
        book.setPublisherId(publishers.get(0).getPublisherId());
        book.setPrice(12.99);

        bookDao.addBook(book);

        Book book1 = new Book();
        book1.setIsbn("9788373191723");
        book1.setPublishDate(Date.valueOf("1954-07-29"));
        book1.setAuthorId(authors.get(1).getAuthorId());
        book1.setTitle("The Lord of the Rings");
        book1.setPublisherId(publishers.get(1).getPublisherId());
        book1.setPrice(29.99);

        bookDao.addBook(book1);

        assertEquals(2, bookDao.getAllBooks().size());

        bookDao.deleteBook(book.getBookId());

        assertEquals(1, bookDao.getAllBooks().size());
    }

    @Test
    public void getBooksByAuthor() {
        List<Author> authors = helperLoadAuthors();
        List<Publisher> publishers = helperLoadPublishers();

        Book book = new Book();
        book.setIsbn("9781101628270");
        book.setPublishDate(Date.valueOf("1884-12-10"));
        book.setAuthorId(authors.get(0).getAuthorId());
        book.setTitle("The Adventures of Huckleberry Finn");
        book.setPublisherId(publishers.get(0).getPublisherId());
        book.setPrice(12.99);

        bookDao.addBook(book);

        Book book1 = new Book();
        book1.setIsbn("9788373191723");
        book1.setPublishDate(Date.valueOf("1954-07-29"));
        book1.setAuthorId(authors.get(1).getAuthorId());
        book1.setTitle("Fellowship of the Rings");
        book1.setPublisherId(publishers.get(1).getPublisherId());
        book1.setPrice(29.99);

        bookDao.addBook(book1);

        Book book2 = new Book();
        book2.setIsbn("9788372980618");
        book2.setPublishDate(Date.valueOf("1954-11-11"));
        book2.setAuthorId(authors.get(1).getAuthorId());
        book2.setTitle("The Two Towers");
        book2.setPublisherId(publishers.get(1).getPublisherId());
        book2.setPrice(16.99);

        bookDao.addBook(book2);

        assertEquals(3, bookDao.getAllBooks().size());

        assertEquals(2, bookDao.getBooksByAuthor(authors.get(1).getAuthorId()).size());


    }

    List<Publisher> helperLoadPublishers(){
        Publisher publisher = new Publisher();
        publisher.setName("Chatto & Windus ");
        publisher.setStreet("1745 Broadway");
        publisher.setCity("New York");
        publisher.setState("NY");
        publisher.setPostalCode("10032");
        publisher.setPhone("212-666-7677");
        publisher.setEmail("penguin@randomhouse.com");

        publisherDao.addPublisher(publisher);

        Publisher publisher1 = new Publisher();
        publisher1.setName("John Wiley & Sons, Inc.");
        publisher1.setStreet("111 River Street");
        publisher1.setCity("Hoboken");
        publisher1.setState("NJ");
        publisher1.setPostalCode("07030");
        publisher1.setPhone("201-777-4949");
        publisher1.setEmail("wiley@wileyandsons.com");

        publisherDao.addPublisher(publisher1);

        return publisherDao.getAllPublishers();
    }

    List<Author> helperLoadAuthors(){
        Author author = new Author();
        author.setFirstName("Mark");
        author.setLastName("Twain");
        author.setStreet("Mississippi St");
        author.setCity("Hartford");
        author.setState("CT");
        author.setPostalCode("00077");
        author.setPhone("123-456-7890");
        author.setEmail("samuel.clemens@marktwain.com");
        authorDao.addAuthor(author);

        Author author1 = new Author();
        author1.setFirstName("Samuel");
        author1.setLastName("Clemens");
        author1.setStreet("Mississippi St");
        author1.setCity("Florida");
        author1.setState("MO");
        author1.setPostalCode("12345");
        author1.setPhone("777-666-5555");
        author1.setEmail("mark.twains@marktwain.com");
        authorDao.addAuthor(author1);

        return authorDao.getAllAuthors();
    }
}
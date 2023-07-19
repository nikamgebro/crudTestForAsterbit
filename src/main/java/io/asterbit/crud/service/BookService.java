package io.asterbit.crud.service;

import io.asterbit.crud.entity.Book;
import io.asterbit.crud.model.request.AddBookRequest;
import io.asterbit.crud.model.request.UpdateBookRequest;
import io.asterbit.crud.model.response.DeleteBookResponse;
import io.asterbit.crud.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public Book addBook(AddBookRequest addBookRequest) {
        var book = new Book();
        book.setIsbn(addBookRequest.isbn());
        book.setAuthor(addBookRequest.author());
        book.setTitle(addBookRequest.title());
        book.setReleaseYear(addBookRequest.releaseYear());

        bookRepository.save(book);

        return book;
    }

    public List<Book> getBooks() {
        final var books = bookRepository.findAll();
        if (books.isEmpty()) {
            throw new IllegalStateException("Books are empty !");
        }
        return books;
    }

    public Book findBookById(Long id){
        var book = bookRepository.findBookById(id);
        if (book == null) {
            throw new IllegalStateException("Book with this ID does not exists !");
        }
        return book;
    }

    public Book updateBook(Long id, UpdateBookRequest updateBookRequest) {
        var book = bookRepository.findBookById(id);
        if (book == null) {
            throw new IllegalStateException("Book with this ID does not exists !");
        }
        book.setIsbn(updateBookRequest.isbn());
        book.setAuthor(updateBookRequest.author());
        book.setTitle(updateBookRequest.title());
        book.setReleaseYear(updateBookRequest.releaseYear());

        bookRepository.save(book);

        return book;
    }

    public DeleteBookResponse deleteBook(Long id) {
        var book = bookRepository.findBookById(id);
        if (book == null) {
            throw new IllegalStateException("Book with this ID does not exists !");
        }
        bookRepository.delete(book);
        var deleteBookResponse = new DeleteBookResponse("Book with " + id + " is deleted");
        return deleteBookResponse;
    }
}

package io.asterbit.crud.controller;

import io.asterbit.crud.entity.Book;
import io.asterbit.crud.model.request.AddBookRequest;
import io.asterbit.crud.model.request.UpdateBookRequest;
import io.asterbit.crud.model.response.DeleteBookResponse;
import io.asterbit.crud.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping
    @ResponseBody
    private List<Book> getBooks() {
        return bookService.getBooks();
    }

    @GetMapping("/byId")
    @ResponseBody
    private Book findBookById(@RequestParam long id){
        return bookService.findBookById(id);
    }

    @PostMapping
    @ResponseBody
    private Book addBook(@RequestBody @Valid AddBookRequest addBookRequest) {
        return bookService.addBook(addBookRequest);
    }

    @PutMapping
    @ResponseBody
    private Book updateBook(@RequestParam Long id, @RequestBody @Valid UpdateBookRequest updateBookRequest) {
        return bookService.updateBook(id, updateBookRequest);
    }

    @DeleteMapping
    @ResponseBody
    private DeleteBookResponse deleteBook(@RequestParam Long id) {
        return bookService.deleteBook(id);
    }
}

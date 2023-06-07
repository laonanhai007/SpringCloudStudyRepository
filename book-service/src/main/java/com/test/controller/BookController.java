package com.test.controller;

import com.test.entity.Book;
import com.test.service.BookService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @Resource
    BookService bookService;

    @GetMapping("/book/{bid}")
    Book findBookByBid(@PathVariable("bid") int bid){
        return bookService.getBookByBid(bid);
    }
}

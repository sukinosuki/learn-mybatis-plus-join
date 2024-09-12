package com.example.learnmybatisplusjoin.modules.book

import com.example.learnmybatisplusjoin.common.R
import com.example.learnmybatisplusjoin.entity.Book
import com.example.learnmybatisplusjoin.modules.book.form.BookFormAdd
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/book")
class BookController {

    @Autowired
    lateinit var bookService: BookService

    @GetMapping("/{id}")
    fun getById(@PathVariable("id") id: Long): R<Book?> {
        val book = bookService.getById(id)

        return R.ok(book)
    }

    @PostMapping
    fun add(@RequestBody form: BookFormAdd): Long {
        val id = bookService.add(form)

        return id
    }
}
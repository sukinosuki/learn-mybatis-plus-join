package com.example.learnmybatisplusjoin.modules.book

import com.example.learnmybatisplusjoin.entity.Book
import com.example.learnmybatisplusjoin.mapper.BookMapper
import com.example.learnmybatisplusjoin.modules.book.form.BookFormAdd
import com.github.yulichang.toolkit.KtWrappers
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.TransactionDefinition
import org.springframework.transaction.support.DefaultTransactionDefinition
import java.time.LocalDateTime

@Service
class BookService {

    @Autowired
    lateinit var bookMapper: BookMapper

    @Autowired
    lateinit var txManager: PlatformTransactionManager

    val logger = LoggerFactory.getLogger(BookService::class.java)

    fun getById(id: Long): Book? {

        val book = bookMapper.selectOne(
            KtWrappers.query(Book::class.java)
                .select(Book::id, Book::name, Book::author, Book::uid, Book::createdAt)
//                .select(Book::id, Book::name, Book::author, Book::uid)
                .eq(Book::id, id)
        )

        return book
    }

    fun add(form: BookFormAdd): Long {
        val transactionDefinition = DefaultTransactionDefinition()
        transactionDefinition.propagationBehavior = TransactionDefinition.PROPAGATION_REQUIRES_NEW
        val status = txManager.getTransaction(transactionDefinition)

        val book = Book(
            uid = form.uid,
            author = form.author,
            name = form.name,
            categoryId = form.categoryId,
            createdAt = LocalDateTime.now(),
            updatedAt = LocalDateTime.now()
        )
        try {

            bookMapper.insert(book)
//            val a = 1 / 0

            txManager.commit(status)
        } catch (e: Exception) {
            logger.error("捕获异常: ${e.message}")
            txManager.rollback(status)
        }

        return book.id
    }
}
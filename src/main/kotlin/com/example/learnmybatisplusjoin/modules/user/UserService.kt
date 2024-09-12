package com.example.learnmybatisplusjoin.modules.user

import com.example.learnmybatisplusjoin.entity.*
import com.example.learnmybatisplusjoin.mapper.BookMapper
import com.example.learnmybatisplusjoin.mapper.UserMapper
import com.example.learnmybatisplusjoin.modules.user.form.FormGet
import com.example.learnmybatisplusjoin.common.exception.RecordNotFoundException
import com.github.yulichang.toolkit.KtWrappers
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService {

    @Autowired
    lateinit var userDao: UserDao

    @Autowired
    lateinit var userMapper: UserMapper

    @Autowired
    lateinit var bookMapper: BookMapper
    fun getUserBookById(id: Long): MutableList<Book> {

//        val user = userDao.getUserWithBooksById(id) ?: throw Exception("record not found")
//
//        return user
        val books = bookMapper.selectJoinList(
            Book::class.java,
            KtWrappers.query(Book::class.java).select(Book::id, Book::uid, Book::name).eq(Book::uid, id)
        )
        return books!!
    }

    fun getById(id: Long): User {
        val user = userMapper.selectOne(KtWrappers.query(User::class.java).eq(User::id, id))
            ?: throw RecordNotFoundException()

        return user
    }

    fun getUser(query: FormGet): MutableList<User> {

        val list = userDao.get(query)

        return list!!
    }
}
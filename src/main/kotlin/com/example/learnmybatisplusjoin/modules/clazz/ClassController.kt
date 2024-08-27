package com.example.learnmybatisplusjoin.modules.clazz

import com.baomidou.mybatisplus.extension.plugins.pagination.Page
import com.example.learnmybatisplusjoin.entity.*
import com.example.learnmybatisplusjoin.mapper.ClazzMapper
import com.github.yulichang.toolkit.KtWrappers
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/class")
class ClassController {


    @Autowired
    lateinit var clazzMapper: ClazzMapper

    @GetMapping
    fun get(): Any? {

        // 先给主表分页
        val idList = clazzMapper.selectJoinPage(Page(1,2), Clazz::class.java, KtWrappers.query(Clazz::class.java).select(Clazz::id)).records.map { it.id }

        val wrapper = KtWrappers.query(Clazz::class.java)
//            .selectAll(Clazz::class.java) // 获取主表所有字段
            .select(Clazz::id, Clazz::name) // 获取主表指定字段
            .selectCollection(Clazz::users) { tUser ->
                tUser
                    .id(User::id)
                    .result(User::name)
                    .result(User::classId)
                    // 查询 userIdCard
                    .association(UserIdCard::class.java, User::userIdCard) { tUserIdCard ->
                        // 只查询 userIdCard指定字段
                        tUserIdCard
                            .id(UserIdCard::id)
                            .result(UserIdCard::uid)
                            .result(UserIdCard::cardNumber)
                    }
                    // 查询 book列表
                    .collection(User::books) { tBook ->
                        // 只查询book指定字段
                        tBook
                            .id(Book::id)
                            .result(Book::name)
                            .association(BookCategory::class.java, Book::category) { tCategory ->
                                tCategory.id(BookCategory::id)
                                    .result(BookCategory::name)
                            }
                    }
            }
            // join user
            .leftJoin(User::class.java, User::classId, Clazz::id)
            // join userIdCard
            .leftJoin(UserIdCard::class.java, UserIdCard::uid, User::id)
            // join book
            .leftJoin(Book::class.java, Book::uid, User::id)
            // join book category
            .leftJoin(BookCategory::class.java, BookCategory::id, Book::categoryId)
            .`in`(Clazz::id, idList)

        val list = clazzMapper.selectJoinList(Clazz::class.java, wrapper)

        return list
    }
}
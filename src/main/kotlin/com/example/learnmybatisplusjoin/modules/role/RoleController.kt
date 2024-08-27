package com.example.learnmybatisplusjoin.modules.role

import com.example.learnmybatisplusjoin.entity.Permission
import com.example.learnmybatisplusjoin.entity.Role
import com.example.learnmybatisplusjoin.entity.Role2Permission
import com.example.learnmybatisplusjoin.mapper.RoleMapper
import com.github.yulichang.toolkit.KtWrappers
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/role")
class RoleController {

    @Autowired
    lateinit var roleMapper: RoleMapper

    @GetMapping
    fun get(): MutableList<Role>? {
        val wrappers = KtWrappers.query(Role::class.java)
            .selectAll(Role::class.java)
            .selectCollection(Permission::class.java, Role::permissions)
            .leftJoin(Role2Permission::class.java, Role2Permission::roleId, Role::id)
            .leftJoin(Permission::class.java, Permission::id, Role2Permission::permissionId)

        val list = roleMapper.selectJoinList(Role::class.java, wrappers)

        return list
    }
}
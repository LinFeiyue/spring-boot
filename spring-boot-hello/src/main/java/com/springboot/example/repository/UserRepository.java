package com.springboot.example.repository;

import com.springboot.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 通过JPA实体持久化
 * 1、该接口继承了JpaRepository，并使用了Repository,使其能被其他程序引用，为其他程序提供存取数据库的功能
 * 2、JpaRepository 继承 PagingAndSortingRepository 继承 CurRepository 继承  Repository
 * 3、Jpa提供了一些自定义的声明方法的规则，如：findBy[(大写开头)属性名]，readBy[同上]，getBy[同上]，也可以字段And等拼接
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    //像满足规则3的要求，不用实现，JPA将会代理实现这些方法
    User findByNameLike(String name);

}

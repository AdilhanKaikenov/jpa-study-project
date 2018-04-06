package com.epam.adok.jpaproject.repository;

import com.epam.adok.jpaproject.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {

    @Query(name = "Blog.readById")
    Blog getBlogById(@Param("id") Long id);

}

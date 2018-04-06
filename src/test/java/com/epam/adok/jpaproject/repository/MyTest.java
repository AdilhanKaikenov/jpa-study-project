package com.epam.adok.jpaproject.repository;

import com.epam.adok.jpaproject.configuration.RootApplicationContextConfiguration;
import com.epam.adok.jpaproject.entity.Blog;
import com.epam.adok.jpaproject.entity.Category;
import com.epam.adok.jpaproject.entity.User;
import com.epam.adok.jpaproject.entity.comment.AbstractComment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootApplicationContextConfiguration.class)
public class MyTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SessionFactory sessionFactory;

    @Test
    public void lazyInitialization() {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Blog blog = session.load(Blog.class, 1L);

        System.out.println(blog.getTitle());

//        transaction.commit();
//        session.close();
        // if close earlier org.hibernate.LazinitializationEssepetion will be caught
        // since Blog would be detached

        Set<Category> categories = blog.getCategories();

        System.out.println("categories size = " + categories.size());

//        transaction.commit();
//        session.close();

    }

    @Test
    public void detachedBlog() {

        Session session1 = this.sessionFactory.openSession();
        Transaction transaction1 = session1.beginTransaction();

        Query query = session1.createQuery("SELECT b FROM Blog b WHERE b.id = 1");
        Blog blog = (Blog) query.getSingleResult();

        System.out.println("Blog title: " + blog.getTitle());

        transaction1.commit();
        session1.close();

        Session session2 = this.sessionFactory.openSession();
//        Transaction transaction2 = session2.beginTransaction();

//        session2.merge(result); ---> detached 'blog' to persistent 'blog'

        session2.delete(blog); // won't delete until there is no transaction

//        transaction2.commit();
        session2.close();

    }

    @Test
    public void jpaCacheTheFirstLevel() {

        Session session1 = this.sessionFactory.openSession();
        Transaction transaction1 = session1.beginTransaction();

        Blog blog = this.getBlog();
        session1.persist(blog); // blog saved with title 'Title'

        transaction1.commit();

        Transaction transaction2 = session1.beginTransaction();
        blog.setTitle("New title"); // Blog title name updated in dataBase
        transaction2.commit();

        session1.close();
    }

    @Test
    public void bidirectionalEntityRelationship() {
        Optional<User> optionalUser = this.userRepository.findById(1L);

        User user = optionalUser.get();
        System.out.println(user.getLogin());

        Set<AbstractComment> comments = user.getComments();
        System.out.println(comments.size());
    }

    private Blog getBlog() {
        User user = new User();
        user.setId(2);

        Category category = new Category();
        category.setId(2);

        Set<Category> categories = new HashSet<>();
        categories.add(category);

        return new Blog("Title", "Content Text", user, categories, new Date());
    }
}

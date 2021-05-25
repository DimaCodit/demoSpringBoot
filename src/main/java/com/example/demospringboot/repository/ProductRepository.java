package com.example.demospringboot.repository;

import com.example.demospringboot.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class ProductRepository {

    private List<Product> personList = new CopyOnWriteArrayList<>();
    private AtomicLong generator = new AtomicLong();
    private SessionFactory factory;

    public ProductRepository() {

        this.factory = new Configuration()
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();

    }

    private Session getSession() {
        return this.factory.getCurrentSession();
    }

    public List<Product> findAll(){
//        return personList.stream()
//                .filter(it->!it.isDelete())
//                .collect();
        Session session = getSession();
        session.beginTransaction();
        List<Product> productsList = (List<Product>) session.createQuery("from Product").getResultList();
        getSession().getTransaction().commit();
        if (productsList == null) {
            return new ArrayList<Product>();
        }
        return productsList;
    }

    public void add(Product product) {
        Session session = getSession();
        session.beginTransaction();
        session.save(product);
        session.getTransaction().commit();
    }

    public Product getById(Long id) {
        Session session = getSession();
        session.beginTransaction();
        Product product = session.get(Product.class, id);
        session.getTransaction().commit();
        return product;
    }


}

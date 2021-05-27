package com.example.demospringboot.repository;

import com.example.demospringboot.model.Product;
import com.example.demospringboot.util.HibernateAction;
import com.example.demospringboot.util.HibernateUtil;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequiredArgsConstructor
public class ProductRepository {

    private final SessionFactory factory;

    private Session getSession() {
        return this.factory.getCurrentSession();
    }

    public List<Product> findAll(){

        List<Product> productsList = (List<Product>) HibernateUtil.doInTransactionWithResult(factory, s -> s.createQuery("from Product").getResultList());

        if (productsList == null) {
            return new ArrayList<Product>();
        }
        return productsList;
    }

    public Product getById(Long id) {
        return (Product)HibernateUtil.doInTransactionWithResult(factory, s -> s.get(Product.class, id));
    }

    public void deleteById(Long id) {
        Product product = (Product)HibernateUtil.doInTransactionWithResult(factory, s -> s.get(Product.class, id));
        HibernateUtil.doInTransaction(factory, s -> s.delete(product));
    }

    public void saveOrUpdate(Product product) {
        HibernateUtil.doInTransaction(factory, s -> s.saveOrUpdate(product));
    }

}

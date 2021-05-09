package com.example.demospringboot.repository;

import com.example.demospringboot.model.Product;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class ProductRepository {

    private List<Product> personList = new CopyOnWriteArrayList<>();
    private AtomicLong generator = new AtomicLong();

    @PostConstruct
    public void init() {
        personList.add(new Product(generator.incrementAndGet(), "Сникерс", 23, false));
    }

    public List<Product> findAll(){
        return personList.stream()
                .filter(it->!it.isDelete())
                .collect(Collectors.toUnmodifiableList());
    }

    public void add(Product product) {
        personList.add(product);
    }

    public Product getById(String id) {
        Optional<Product> product= personList.stream().filter(p->p.getId().equals(id)).findFirst();
        return product.get();
    }


}

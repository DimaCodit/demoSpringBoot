package com.example.demospringboot.util;

import org.hibernate.Session;

@FunctionalInterface
public interface HibernateAction<T> {
    T perform(Session session);
}

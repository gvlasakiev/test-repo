package com.example.jorexa.landlordapp.repositories.base;

import java.io.IOException;
import java.util.List;

public interface Repository<T> {
    //List<T> getAll() throws IOException;

    T login(T item) throws IOException;

    //T getById(int id) throws IOException;
}

package com.jasminadmin.rest.service;

import com.jasminadmin.rest.domain.Category;
import com.jasminadmin.rest.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository repo;
    public List<Category> listAll() {
        return repo.findAll();
    }
    public void save(Category std) {
        repo.save(std);
    }
    public Category get(long id) {
        return repo.findById(id).get();
    }
    public void delete(long id) {
        repo.deleteById(id);
    }
}

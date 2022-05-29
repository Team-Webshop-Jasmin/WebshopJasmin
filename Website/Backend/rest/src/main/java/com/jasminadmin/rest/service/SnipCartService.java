package com.jasminadmin.rest.service;


import com.jasminadmin.rest.domain.SnipCart;
import com.jasminadmin.rest.repository.SnipCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SnipCartService {
    @Autowired
    private SnipCartRepository repo;
    public List<SnipCart> listAll() {
        return repo.findAll();
    }
    public void save(SnipCart std) {
        repo.save(std);
    }
    public SnipCart get(long id) {
        return repo.findById(id).get();
    }
    public void delete(long id) {
        repo.deleteById(id);
    }
}

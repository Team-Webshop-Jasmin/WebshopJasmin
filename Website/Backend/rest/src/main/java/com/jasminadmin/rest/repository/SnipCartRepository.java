package com.jasminadmin.rest.repository;

import com.jasminadmin.rest.domain.SnipCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SnipCartRepository extends JpaRepository<SnipCart, Long> {}
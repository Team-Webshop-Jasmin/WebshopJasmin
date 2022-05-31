package at.jasminsweets.admin.Repositories;

import at.jasminsweets.admin.persistence.entities.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public class ProductRepository implements CrudRepository<Product, Long> {
    @Override
    public <S extends Product> S save(S s) {
        return null;
    }

    @Override
    public <S extends Product> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Product> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Product> findAll() {
        return null;
    }

    @Override
    public Iterable<Product> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Product product) {

    }

    @Override
    public void deleteAll(Iterable<? extends Product> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}

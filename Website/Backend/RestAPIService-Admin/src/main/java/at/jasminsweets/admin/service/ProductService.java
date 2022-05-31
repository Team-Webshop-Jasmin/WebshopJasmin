package at.jasminsweets.admin.service;

import at.jasminsweets.admin.persistence.entities.Product;
import at.jasminsweets.admin.persistence.mapper.ProductMapper;
import at.jasminsweets.admin.persistence.model.ProductModel;
import at.jasminsweets.admin.persistence.repo.ProductRepository;
import lombok.NonNull;
import org.hibernate.service.spi.ServiceException;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@ApplicationScoped
public class ProductService {

<<<<<<< HEAD
    private ProductRepository productRepository;
    private ProductMapper productMapper;

    public List<ProductModel> findAll() {
        return this.productMapper.toDomainList(productRepository.findAll().list());
    }

    public Optional<Product> findById(@NonNull Integer customerId) {
        return productRepository.findByIdOptional(customerId)
                .map(productMapper::toDomain);
    }

    @Transactional
    public void save(ProductModel productModel) {
        Product entity = productMapper.toEntity(productModel);
        productRepository.persist(entity);
        productMapper.updateDomainFromEntity(entity, productModel);
    }

    @Transactional
    public void update(ProductModel productModel) {
        if (Objects.isNull(productModel.getId())) {
            throw new ServiceException("Product does not have a id");
        }
        Product entity = productRepository.findByIdOptional(productModel.getId())
                .orElseThrow(() -> new ServiceException("No Product found for Id"));
        productMapper.updateEntityFromDomain(productModel, entity);
        productRepository.persist(entity);
        productMapper.updateDomainFromEntity(entity, productModel);
    }
=======

>>>>>>> bc887148c383ce3ae70af647eb852b4ec922dce5
}

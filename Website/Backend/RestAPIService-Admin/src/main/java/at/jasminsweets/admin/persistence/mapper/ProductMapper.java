package at.jasminsweets.admin.persistence.mapper;

import at.jasminsweets.admin.persistence.entities.Product;
import at.jasminsweets.admin.persistence.model.ProductModel;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
<<<<<<< HEAD

import java.util.List;

public interface ProductMapper {

    List<ProductModel> toDomainList(List<Product> entities);

    Product toDomain(Product entity);

    @InheritInverseConfiguration(name = "toDomain")
    Product toEntity(ProductModel domain);

    void updateEntityFromDomain(ProductModel domain, @MappingTarget Product entity);

    void updateDomainFromEntity(Product entity, @MappingTarget ProductModel domain);

}
=======
>>>>>>> bc887148c383ce3ae70af647eb852b4ec922dce5

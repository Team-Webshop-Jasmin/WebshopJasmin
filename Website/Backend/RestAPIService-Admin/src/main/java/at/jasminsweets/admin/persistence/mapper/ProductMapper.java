package at.jasminsweets.admin.persistence.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "cdi")
public interface ProductMapper {

    List<Customer> toDomainList(List<CustomerEntity> entities);

    Customer toDomain(CustomerEntity entity);

    @InheritInverseConfiguration(name = "toDomain")
    CustomerEntity toEntity(Customer domain);

    void updateEntityFromDomain(Customer domain, @MappingTarget CustomerEntity entity);

    void updateDomainFromEntity(CustomerEntity entity, @MappingTarget Customer domain);

}
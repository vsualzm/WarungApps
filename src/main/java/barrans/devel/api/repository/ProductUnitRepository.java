package barrans.devel.api.repository;


import barrans.devel.api.model.ProductUnit;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProductUnitRepository implements PanacheRepository<ProductUnit> {

}

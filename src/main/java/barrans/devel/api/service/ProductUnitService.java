package barrans.devel.api.service;


import barrans.devel.api.model.ProductUnit;
import barrans.devel.api.repository.ProductUnitRepository;
import io.vertx.core.json.JsonObject;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;

@ApplicationScoped
public class ProductUnitService {

    @Inject
    ProductUnitRepository productUnitRepository;

    @Transactional
    public ProductUnit persistProductUnit(@Valid ProductUnit productUnit) {
        productUnit.persist();
        return productUnit;
    }

    @Transactional
    public void updateProductUnit(Long id, JsonObject params){
        ProductUnit productUnit = productUnitRepository.findById(id);
        productUnit.description = params.getString("description");
        productUnitRepository.persist(productUnit);
    }

    @Transactional
    public void deleteProductUnit(Long id){
        ProductUnit productUnit = productUnitRepository.findById(id);
        productUnit.delete();
    }



}

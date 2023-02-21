package barrans.devel.api.service;


import barrans.devel.api.model.Product;
import barrans.devel.api.repository.ProductRepository;
import io.vertx.core.json.JsonObject;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@ApplicationScoped
public class ProductService {

    @Inject
    ProductRepository productRepository;

    @Transactional
    public Product persistProduct(@Valid Product product) {
        product.persist();
        return product;
    }

    @Transactional
    public void updateProduct(Long id, JsonObject params){
        Product product = productRepository.findById(id);
        product.barcode = params.getLong("barcode");
        product.productName = params.getString("productName");
        product.description = params.getString("description");
        product.price = params.getDouble("price");
        product.image= params.getString("image");
        productRepository.persist(product);
    }

    public List<Product> getListAllProduct(){
        List<Product> products = productRepository.findAll().list();
        return products;
    }

    @Transactional
    public void deleteProduct(Long id){
        Product product = productRepository.findById(id);
        product.delete();
    }

    public Product findProductById(Long id) {
        return productRepository.findById(id);
    }

}

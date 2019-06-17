package roman.pidkostelnyi.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import roman.pidkostelnyi.demo.dto.request.ProductRequest;
import roman.pidkostelnyi.demo.entity.Category;
import roman.pidkostelnyi.demo.entity.Product;
import roman.pidkostelnyi.demo.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryService categoryService;

    public void create(ProductRequest request) {
        productRepository.save(productRequestToProduct(null, request));
    }

    public void update(Long id, ProductRequest request) {
        productRepository.save(productRequestToProduct(findOne(id), request));
    }

    private Product productRequestToProduct(Product product, ProductRequest request) {
        if (product == null) {
            product = new Product();
        }
        Category category =
                categoryService.findOne(request.getCategoryId());
        product.setCategory(category);
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        return product;
    }

    public Product findOne(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Product with id " + id + " not exists"));
    }
}

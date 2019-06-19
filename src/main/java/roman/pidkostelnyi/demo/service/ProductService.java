package roman.pidkostelnyi.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import roman.pidkostelnyi.demo.dto.request.PaginationRequest;
import roman.pidkostelnyi.demo.dto.request.ProductRequest;
import roman.pidkostelnyi.demo.dto.response.PageResponse;
import roman.pidkostelnyi.demo.dto.response.ProductResponse;
import roman.pidkostelnyi.demo.entity.Category;
import roman.pidkostelnyi.demo.entity.Product;
import roman.pidkostelnyi.demo.repository.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

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

//    public PageResponse<ProductResponse> findPage(Integer size, Integer page, String field, Sort.Direction direction) {
//
//        Page<Product> all;
//        if (direction == null || field == null) {
//            all = productRepository.findAll(PageRequest.of(page, size));
//        } else {
//            all = productRepository.findAll(PageRequest.of(page, size, direction, field));
//        }
//        List<Product> content = all.getContent();
//        final List<ProductResponse> collect = content.stream().map(ProductResponse::new).collect(Collectors.toList());
//        return new PageResponse<>(all.getTotalPages(), all.getTotalElements(), collect);
//    }

    public PageResponse<ProductResponse> findPage(PaginationRequest paginationRequest) {
        Page<Product> page = productRepository.findAll(paginationRequest.toPageable());
        return new PageResponse<>(page.getTotalPages(),
                page.getTotalElements(),
                page.get().map(ProductResponse::new).collect(Collectors.toList()));
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

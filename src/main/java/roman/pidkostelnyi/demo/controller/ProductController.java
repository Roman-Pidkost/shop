package roman.pidkostelnyi.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import roman.pidkostelnyi.demo.dto.request.PaginationRequest;
import roman.pidkostelnyi.demo.dto.request.ProductRequest;
import roman.pidkostelnyi.demo.dto.response.PageResponse;
import roman.pidkostelnyi.demo.dto.response.ProductResponse;
import roman.pidkostelnyi.demo.service.ProductService;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public void create(@Valid @RequestBody ProductRequest request) throws IOException {
        productService.create(request);
    }

    @GetMapping
    public PageResponse<ProductResponse> findAll(PaginationRequest paginationRequest) {
        return productService.findPage(paginationRequest);
    }
}

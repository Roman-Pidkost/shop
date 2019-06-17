package roman.pidkostelnyi.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import roman.pidkostelnyi.demo.dto.request.CategoryRequest;
import roman.pidkostelnyi.demo.dto.response.CategoryResponse;
import roman.pidkostelnyi.demo.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public void create(@RequestBody CategoryRequest request) {
        categoryService.create(request);
    }

    @GetMapping
    public List<CategoryResponse> findAll() {
        return categoryService.findAll();
    }

    @PutMapping
    public void update(Long id, @RequestBody CategoryRequest request) {
        categoryService.update(id, request);
    }

    @DeleteMapping
    public void delete(Long id) {
        categoryService.delete(id);
    }
}

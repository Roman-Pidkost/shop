package roman.pidkostelnyi.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import roman.pidkostelnyi.demo.dto.request.CategoryRequest;
import roman.pidkostelnyi.demo.dto.response.CategoryResponse;
import roman.pidkostelnyi.demo.service.CategoryService;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public void create(@Valid @RequestBody CategoryRequest request) {
        categoryService.create(request);
    }

    @GetMapping
    public List<CategoryResponse> findAll() {
        return categoryService.findAll();
    }

    @PutMapping
    public void update(Long id, @Valid @RequestBody CategoryRequest request) {
        categoryService.update(id, request);
    }

    @DeleteMapping
    public void delete(Long id) {
        categoryService.delete(id);
    }
}

package roman.pidkostelnyi.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import roman.pidkostelnyi.demo.dto.request.CategoryRequest;
import roman.pidkostelnyi.demo.dto.response.CategoryResponse;
import roman.pidkostelnyi.demo.entity.Category;
import roman.pidkostelnyi.demo.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public void create(CategoryRequest request) {
        categoryRepository.save(categoryRequestToCategory(null, request));
    }

    public List<CategoryResponse> findAll() {
        return categoryRepository.findAll().stream()
                .map(CategoryResponse::new)
                .collect(Collectors.toList());
    }

    public Category findOne(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Category with id " + id + " not exists"));
    }

    public void update(Long id, CategoryRequest request) {
        categoryRepository.save(categoryRequestToCategory(findOne(id), request));
    }

     public void delete(Long id) {
        categoryRepository.delete(findOne(id));
     }


    private Category categoryRequestToCategory(Category category, CategoryRequest request) {
        if (category == null) {
            category = new Category();
        }
        category.setName(request.getName());
        return category;
    }
}

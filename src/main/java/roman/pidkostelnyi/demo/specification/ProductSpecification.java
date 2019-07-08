package roman.pidkostelnyi.demo.specification;

import org.springframework.data.jpa.domain.Specification;
import roman.pidkostelnyi.demo.dto.request.ProductCriteria;
import roman.pidkostelnyi.demo.entity.Category;
import roman.pidkostelnyi.demo.entity.Product;

import javax.persistence.criteria.*;

public class ProductSpecification implements Specification<Product> {

    private String name;
    private Long minPrice;
    private Long maxPrice;
    private Long categoryId;

    public ProductSpecification(ProductCriteria criteria) {
        name = criteria.getName();
        minPrice = criteria.getMinPrice();
        maxPrice = criteria.getMaxPrice();
        categoryId = criteria.getCategoryId();
    }

    @Override
    public Predicate toPredicate(
            Root<Product> r,//from SOME_TABLE join
            CriteriaQuery<?> cq,//select distinct, avg()
            CriteriaBuilder cb//where FIELD between // where FIELD like
    ) {
        Predicate p1 = findByName(r, cb);
        Predicate p2 = findByPrice(r, cb);
        Predicate p3 = findByCategory(r, cb);
        return cb.and(p1, p2, p3);
    }

    private Predicate findByCategory(Root<Product> r, CriteriaBuilder cb) {
        Predicate predicate;
        if (categoryId != null) {
//        r.get("id") -> Product.id
//        categoryJoin.get("id") -> Category.id
            Join<Product, Category> categoryJoin = r.join("category");
            predicate = cb.equal(categoryJoin.get("id"), categoryId);
        } else {
            predicate = cb.conjunction();
        }
        return predicate;
    }

    private Predicate findByName(Root<Product> r, CriteriaBuilder cb) {
        Predicate predicate;
        if (name != null) {
            predicate = cb.like(r.get("name"), '%' + name + '%');
        } else {
            predicate = cb.conjunction();
        }
        return predicate;
    }

    private Predicate findByPrice(Root<Product> r, CriteriaBuilder cb) {
        Predicate predicate;
        if (minPrice != null && maxPrice != null) {
            predicate = cb.between(r.get("price"), minPrice, maxPrice);
        } else if (minPrice != null) {
            predicate = cb.greaterThanOrEqualTo(r.get("price"), minPrice);
        } else if (maxPrice != null) {
            predicate = cb.lessThanOrEqualTo(r.get("price"), maxPrice);
        } else {
            predicate = cb.conjunction();
        }
        return predicate;
    }
}

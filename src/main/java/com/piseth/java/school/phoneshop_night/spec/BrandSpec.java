package com.piseth.java.school.phoneshop_night.spec;

import com.piseth.java.school.phoneshop_night.entity.Brand;
import com.sun.istack.Nullable;
import lombok.Data;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Data
public class BrandSpec implements Specification<Brand> {
    private final BrandFilter brandFilter;
    List<javax.persistence.criteria.Predicate> predicates = new ArrayList<>();

    @Override
    public @Nullable Predicate toPredicate(Root<Brand> brand, CriteriaQuery<?> query, CriteriaBuilder cb) {
        if (brandFilter.getName() != null) {
//            Predicate name = brand.get("name").in(brandFilter.getName());
//            predicates.add(name);
            Predicate name = cb.like(cb.upper(brand.get("name")),  "%" + brandFilter.getName().toUpperCase() + "%");
            predicates.add(name);
        }

        if (brandFilter.getId() != null) {
            Predicate id = brand.get("id").in(brandFilter.getId());
            predicates.add(id);
        }
//        final Predicate[] pp = predicates.toArray(new Predicate[0]);
//        return cb.and(predicates.toArray(new Predicate[0]));
        return cb.and(predicates.toArray(Predicate[]::new));
    }
}

package com.piseth.java.school.phoneshop_night.repository;

import com.piseth.java.school.phoneshop_night.entity.Brand;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class BrandRepositoryTest {
    @Autowired
    BrandRepository brandRepository;

    @Test
    public void testFindByNameLike(){

        // given
        Brand brand = new Brand();
        brand.setName("Apple");
        brandRepository.save(brand);

        //when
        List<Brand> brands = brandRepository.findByNameLike("%A%");

        //then
        assertEquals(1, brands.size());
        assertEquals("Apple", brands.get(0).getName());
        assertNotNull(brands.get(0).getId());
    }
}

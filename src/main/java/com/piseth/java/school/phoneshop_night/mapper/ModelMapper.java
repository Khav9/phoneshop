package com.piseth.java.school.phoneshop_night.mapper;

import com.piseth.java.school.phoneshop_night.dto.ModelDto;
import com.piseth.java.school.phoneshop_night.entity.Brand;
import com.piseth.java.school.phoneshop_night.entity.Model;
import com.piseth.java.school.phoneshop_night.service.BrandService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",uses = {BrandService.class})
public interface ModelMapper {
    ModelMapper INSTANCE = Mappers.getMapper(ModelMapper.class);

    @Mapping(target = "brand", source = "brandId")
    Model toModel(ModelDto dto);

    @Mapping(target = "brandId", source = "model.id")
    ModelDto toModelDto(Model model);

    /*
	default Brand toBrand(Integer brId) {
		Brand brand = new Brand();
		brand.setId(brId);
		return brand;
	}
     */
}

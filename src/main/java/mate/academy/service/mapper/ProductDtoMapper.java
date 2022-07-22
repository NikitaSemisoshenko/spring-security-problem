package mate.academy.service.mapper;

import mate.academy.model.Product;
import mate.academy.model.dto.ProductRequestDto;
import mate.academy.model.dto.ProductResponseDto;
import org.springframework.stereotype.Component;

@Component
public class ProductDtoMapper {

    public ProductResponseDto toDto(Product product) {
        ProductResponseDto responseDto = new ProductResponseDto();
        responseDto.setId(product.getId());
        responseDto.setName(product.getName());
        responseDto.setPrice(product.getPrice());
        responseDto.setBrand(product.getBrand());
        return responseDto;
    }



    public Product toModel(ProductRequestDto rd) {
        Product product = new Product();
        product.setPrice(rd.getPrice());
        product.setBrand(rd.getBrand());
        product.setName(rd.getName());
        return product;
    }
}

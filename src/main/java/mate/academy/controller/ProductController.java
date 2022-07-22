package mate.academy.controller;

import java.util.List;
import javax.validation.Valid;
import mate.academy.model.Product;
import mate.academy.model.dto.ProductRequestDto;
import mate.academy.model.dto.ProductResponseDto;
import mate.academy.service.ProductService;
import mate.academy.service.mapper.ProductDtoMapper;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    private final ProductDtoMapper mapper;

    public ProductController(ProductService productService,
                             ProductDtoMapper mapper) {
        this.productService = productService;
        this.mapper = mapper;
    }

    @GetMapping
    public List<ProductResponseDto> getAllProducts() {
         return productService.getAll().stream()
                 .map(mapper::toDto)
                 .toList();
    }

    @PostMapping
    public ProductResponseDto create(@Valid @RequestBody ProductRequestDto product) {
        return mapper.toDto(productService.save(mapper.toModel(product)));
    }

    @GetMapping("/find")
    public List<ProductResponseDto> getAllByBrand(@RequestParam String brand) {
        return productService.findByBrand(brand).stream()
                .map(mapper::toDto)
                .toList();
    }

    @GetMapping("/{id}")
    public ProductResponseDto get(@PathVariable Long id) {
        return mapper.toDto(productService.get(id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }

    @PutMapping("/{id}")
    public ProductResponseDto update(@PathVariable Long id,
                                     @RequestBody ProductRequestDto requestDto) {
        Product product = mapper.toModel(requestDto);
        product.setId(id);
        Product productFromDb = productService.update(product);
        return mapper.toDto(productFromDb);
    }
}

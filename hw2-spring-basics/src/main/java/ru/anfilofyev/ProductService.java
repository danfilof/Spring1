package ru.anfilofyev;

import org.springframework.stereotype.Service;
import ru.anfilofyev.persist.Product;
import ru.anfilofyev.persist.ProductRepository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostConstruct
    public void init() {
        this.productRepository.insert(new Product("Milk", 2));
        this.productRepository.insert(new Product("Samsung galaxy 100500", 6));
        this.productRepository.insert(new Product("LG TV", 1));
        this.productRepository.insert(new Product("Honey", 7));
        this.productRepository.insert(new Product("Random product", 1));
    }

    public void insert (Product product) {
        if(product.getPrice() != 0 || product.getTitle().equals("")) {
            this.productRepository.insert(product);
        } else {
            throw new IllegalArgumentException("Incorrect Product");
        }
    }

    public int findAll() {
        return this.productRepository.findAll().size();
    }

    public void showAll() {
        this.productRepository.showAll();
    }
}

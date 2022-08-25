package ru.anfilofyev;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ru.anfilofyev.persist.Product;

import javax.annotation.PostConstruct;

@Service
public class CartService {

    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @PostConstruct
    public void init() {
        this.cartRepository.insert(new Product("Milk", 2));
        this.cartRepository.insert(new Product("Samsung galaxy 100500", 6));
        this.cartRepository.insert(new Product("LG TV", 1));
        this.cartRepository.insert(new Product("Honey", 7));
        this.cartRepository.insert(new Product("Random product", 1));
    }

    public void insert (Product product) {
        if(product.getPrice() != 0 || product.getTitle().equals("")) {
            this.cartRepository.insert(product);
        } else {
            throw new IllegalArgumentException("Incorrect Product");
        }
    }

    public int findAll() {
        return this.cartRepository.findAll().size();
    }

    public void showAll() {
        this.cartRepository.showAll();
    }

    public void delete (Long id) {
        this.cartRepository.delete(id);
    }
}

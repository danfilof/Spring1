package ru.anfilofyev.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.anfilofyev.Cart;
import ru.anfilofyev.CartRepository;
import ru.anfilofyev.CartService;
import ru.anfilofyev.ProductService;
import ru.anfilofyev.persist.ProductRepository;
import ru.anfilofyev.persist.ProductRepositoryImpl;

@Configuration
public class AppConfiguration {

//    @Bean
//    public ProductRepository ProductRepository() {
//        return new ProductRepositoryImpl();
//    }
//
//    @Bean
//    public ProductService productService(ProductRepository productRepository) {
//        return new ProductService(productRepository);
//    }

    @Bean
    public CartService cartService(CartRepository cartRepository) {
        return new CartService(cartRepository);
    }

    @Bean
    public CartRepository cartRepository() {
        return new CartRepository();
    }

    @Bean
    @Scope("prototype")
    public Cart cart() {
        return new Cart();
    }
}

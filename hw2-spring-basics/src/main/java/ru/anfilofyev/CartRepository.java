package ru.anfilofyev;

import org.springframework.stereotype.Repository;
import ru.anfilofyev.persist.Product;
import ru.anfilofyev.persist.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository(value = "cartRepository")
public class CartRepository implements ProductRepository {

    private final Map<Long, Product> cartMap = new ConcurrentHashMap<>();

    private final AtomicLong identity = new AtomicLong(0);
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(cartMap.values());
    }

    @Override
    public Product findById(long id) {
        return cartMap.get(id);
    }

    @Override
    public void insert(Product product) {
        long id = identity.incrementAndGet();
        product.setId(id);
        cartMap.put(id, product);
    }

    @Override
    public void update(Product product) {
        cartMap.put(product.getId(), product);
    }

    @Override
    public void delete(long id) {
        cartMap.remove(id);
    }

    @Override
    public long getCount() {
        return cartMap.size();
    }

    @Override
    public void showAll() {
        System.out.println("ID" + " || " + "Title" + " || " + "Price");
        for (Product product : cartMap.values()) {
            System.out.println(product.getId() + " || " + product.getTitle() + " || " + product.getPrice());
        }
    }
}

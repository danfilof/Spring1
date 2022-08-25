package ru.anfilofyev;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.anfilofyev.config.AppConfiguration;
import ru.anfilofyev.persist.Product;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
        //ProductService productService = context.getBean("productService", ProductService.class);
        CartService cartService = context.getBean("cartService", CartService.class);
        Cart cart = context.getBean("cart", Cart.class);
        Cart cart1 = context.getBean("cart", Cart.class);
        Cart cart2 = context.getBean("cart", Cart.class);



        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Yout current cart: ");
            cartService.showAll();
            String nextLine = scanner.nextLine();

            if (nextLine.equals("/showCart")) {
                cartService.showAll();
            }

            if (nextLine.equals("/add")) {
                System.out.println("Enter product title: ");
                String newProductTitle = scanner.nextLine();
                cartService.showAll();

                System.out.println("Enter price: ");
                int newProductPrice = Integer.parseInt(scanner.nextLine());

                cartService.insert(new Product(newProductTitle, newProductPrice));

                cartService.showAll();
            }

            if (nextLine.equals("/remove")) {
                System.out.println("Enter product's id");
                Long productToDelete = Long.valueOf(scanner.nextLine());
                cartService.delete(productToDelete);

            }

            System.out.println("Enter \"end \" to exit ");
            if (scanner.nextLine().equals("end")) {
                return;
            }
        }
    }
}

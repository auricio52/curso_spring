package com.empresa.course.config;

import com.empresa.course.entities.Category;
import com.empresa.course.entities.Order;
import com.empresa.course.entities.User;
import com.empresa.course.entities.enums.OrderStatus;
import com.empresa.course.repositories.CategoryRepository;
import com.empresa.course.repositories.OrderRepository;
import com.empresa.course.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    private UserRepository userRepository;
    private OrderRepository orderRepository;
    private CategoryRepository categoryRepository;

    public TestConfig(
        UserRepository userRepository,
        OrderRepository orderRepository,
        CategoryRepository categoryRepository
    ) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");
        User user1 = new User(null, "Maria Brown", "maria@gmail.com", "32523523", "123456");
        User user2 = new User(null, "Alex Green", "alex@gmail.com", "21423522", "123456");
        Order order1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, user1);
        Order order2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, user2);
        Order order3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, user1);

        userRepository.saveAll(Arrays.asList(user1, user2));
        orderRepository.saveAll(Arrays.asList(order1, order2, order3));
        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
    }
}

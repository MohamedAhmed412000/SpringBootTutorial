package spring.boot.tutorial.demo.customer;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository(value = "fake")
public class CustomerFakeRepository implements CustomerRepo {

    @Override
    public List<Customer> getCustomers() {
        return Arrays.asList(
            new Customer(1L, "Mohamed", "Ahmed", "mohamed@gmail.com", 23,"123456"),
            new Customer(2L, "Abdo", "Morsy", "abdo@gmail.com", 24, "123456"),
            new Customer(3L, "Adham", "Gamal", "adham@gmail.com", 24, "123456")
        );
    }
    
}

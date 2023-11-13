package spring.boot.tutorial.demo.customer;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository(value = "fake")
public class CustomerFakeRepository implements CustomerRepo {

    @Override
    public List<Customer> getCustomers() {
        return Arrays.asList(
            new Customer(1L, "Mohamed", "mohamed@gmail.com", "123"),
            new Customer(2L, "Abdo", "abdo@gmail.com", "123"),
            new Customer(3L, "Adham", "adham@gmail.com", "123")
        );
    }
    
}

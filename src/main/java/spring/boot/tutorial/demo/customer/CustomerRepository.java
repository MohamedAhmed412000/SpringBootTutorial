package spring.boot.tutorial.demo.customer;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository implements CustomerRepo {

    @Override
    public List<Customer> getCustomers() {
        return Collections.emptyList();
    }
        
}

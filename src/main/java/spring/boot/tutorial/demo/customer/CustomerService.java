package spring.boot.tutorial.demo.customer;

import java.util.List;

import org.springframework.stereotype.Service;

import spring.boot.tutorial.demo.exception.NotFoundException;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    List<Customer> getCustomers() {
        return customerRepository.getCustomers();
    }

    Customer getCustomer(Long id, Boolean showThrowable) {
        return getCustomers().stream()
            .filter(customer -> customer.getId().equals(id))
            .findFirst().orElseThrow(() -> 
                new NotFoundException("Customer with id=" + id + " not found", showThrowable));
    }

}

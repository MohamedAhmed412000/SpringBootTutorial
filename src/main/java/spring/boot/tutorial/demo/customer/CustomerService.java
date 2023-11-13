package spring.boot.tutorial.demo.customer;

import java.util.List;

import org.springframework.stereotype.Service;

import spring.boot.tutorial.demo.exception.NotFoundException;

@Service
public class CustomerService {
    private final CustomerRepo customerRepo;

    public CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    List<Customer> getCustomers() {
        return customerRepo.getCustomers();
    }

    Customer getCustomer(Long id, Boolean showThrowable) {
        return getCustomers().stream()
            .filter(customer -> customer.getId().equals(id))
            .findFirst().orElseThrow(() -> 
                new NotFoundException("Customer with id=" + id + " not found", showThrowable));
    }

}

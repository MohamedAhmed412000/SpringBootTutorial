package spring.boot.tutorial.demo.customer;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import spring.boot.tutorial.demo.exception.NotFoundException;

@Service
public class CustomerService {
    // This to add logging to the CustomerService class
    private final static Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    Customer getCustomer(Long id, Boolean showThrowable) {
        LOGGER.info("getCustomer was called .");
        return customerRepository.findById(id)
            .orElseThrow(() -> {
                NotFoundException notFoundException =  new NotFoundException("Customer with id=" + id + " not found", showThrowable);
                LOGGER.error(notFoundException.getMessage());
                return notFoundException;
            });
    }

    void createCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    void updateCustomer(Customer customer, Long id) {
        customer.setId(id);
        customerRepository.save(customer);
    }

    void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

}

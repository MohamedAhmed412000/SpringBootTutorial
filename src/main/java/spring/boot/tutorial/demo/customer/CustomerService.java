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
        return customerRepository.findAll();
    }

    Customer getCustomer(Long id, Boolean showThrowable) {
        return customerRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("Customer with id=" + id + " not found", showThrowable));
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

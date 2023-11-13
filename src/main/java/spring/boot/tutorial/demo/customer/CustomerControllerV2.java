package spring.boot.tutorial.demo.customer;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RequestMapping(path = "api/v2/customers")
@RestController
public class CustomerControllerV2 {
	private final CustomerService customerService;

    public CustomerControllerV2(CustomerService customerService) {
		this.customerService = customerService;
	}

	@GetMapping(value = "all")
	List<Customer> getCustomers() {
		return customerService.getCustomers();
	}
	
	@GetMapping(value = "{customerId}")
	Customer getCustomer(@PathVariable("customerId") Long id) {
		return customerService.getCustomer(id);
	}

	@PostMapping
	void createCustomer(@Valid @RequestBody Customer customer) {
		System.out.println("Created new customer");
		System.out.println(customer);
	}

	@PutMapping(path = "{customerId}")
	void updateCustomer(
		@PathVariable("customerId") Long id, 
		@Valid @RequestBody Customer customer	
	) {
		System.out.println("Update data of customer with id = " + id);
		System.out.println("The new data: " + customer);
	}

	@DeleteMapping(path = "{customerId}")
	void deleteCustomer(@PathVariable("customerId") Long id) {
		System.out.println("Delete customer with id = " + id);
	}
    
}
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

@RequestMapping(path = "api/v1/customers")
@RestController
@Deprecated
public class CustomerController {
	private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@GetMapping(value = "all")
	List<Customer> getCustomers() {
		return customerService.getCustomers();
	}

	@PostMapping
	void createCustomer(@RequestBody Customer customer) {
		System.out.println("Created new customer");
		System.out.println(customer);
	}

	@PutMapping(path = "{customerId}")
	void updateCustomer(
		@PathVariable("customerId") Long id, 
		@RequestBody Customer customer	
	) {
		System.out.println("Update data of customer with id = " + id);
		System.out.println("The new data: " + customer);
	}

	@DeleteMapping(path = "{customerId}")
	void deleteCustomer(@PathVariable("customerId") Long id) {
		System.out.println("Delete customer with id = " + id);
	}
    
}

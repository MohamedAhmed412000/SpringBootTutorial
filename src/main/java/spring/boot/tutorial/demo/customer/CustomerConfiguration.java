package spring.boot.tutorial.demo.customer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConfiguration {
    @Value("${app.useFakeRepo}")
    private Boolean useFakeRepo;

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
        return args -> {
            customerRepository.findCustomerByEmail("mohamed.ahmed04012000@gmail.com")
                .ifPresentOrElse(System.out::println, () -> System.out.println("Not found"));

            System.out.println(
                customerRepository.filterCustomersUsingFirstNameAndAge("Abdo", 23)
            );
        };
    }

    // @Bean
    // CustomerRepo customerRepo() {
    //     System.out.println("UseFakeRepo: " + useFakeRepo);
    //     return useFakeRepo? new CustomerFakeRepository(): new CustomerRepository();
    // }
}

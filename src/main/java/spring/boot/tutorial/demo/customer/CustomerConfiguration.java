package spring.boot.tutorial.demo.customer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
// import org.springframework.data.domain.PageRequest;
// import org.springframework.data.domain.Sort;
// import org.springframework.data.domain.ScrollPosition.Direction;

import com.github.javafaker.Faker;

@Configuration
public class CustomerConfiguration {
    @Value("${app.useFakeRepo}")
    private Boolean useFakeRepo;

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
        // Only for testing purposes
        return args -> {
            // customerRepository.findCustomerByEmail("mohamed.ahmed04012000@gmail.com")
            //     .ifPresentOrElse(System.out::println, () -> System.out.println("Not found"));

            // System.out.println(
            //     customerRepository.filterCustomersUsingFirstNameAndAge("Abdo", 23)
            // );

            // System.out.println(
            //     customerRepository.filterCustomersUsingFirstNameAndAgeNative(
            //         "Abdo", 
            //         23
            //     )
            // );
            
            generateCustomers(customerRepository, 20);
            // // Multi sorting example
            // Sort sort = Sort.by("firstname").ascending()
            //                 .and(Sort.by("lastname").ascending())
            //                 .and(Sort.by("age")).descending();
            // customerRepository.findAll(sort)
            //     .forEach(customer -> System.out.println(customer));

            // PageRequest pageRequest = PageRequest.of(1, 5, Sort.by("firstname").ascending());
            // customerRepository.findAll(pageRequest)
            //     .forEach(customer -> System.out.println(customer));

        };
    }

    void generateCustomers(CustomerRepository customerRepository, Integer num) {
        Faker faker = new Faker();
        for (int i = 0; i < num; i++) {
            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();
            String email = String.format("%s.%s@gmail.com", firstName, lastName);
            Integer age = faker.number().numberBetween(17, 45);

            Customer customer = new Customer(
                firstName, lastName, email, age, "123456"
            );
            customerRepository.save(customer);

        }
    }

    // @Bean
    // CustomerRepo customerRepo() {
    //     System.out.println("UseFakeRepo: " + useFakeRepo);
    //     return useFakeRepo? new CustomerFakeRepository(): new CustomerRepository();
    // }
}

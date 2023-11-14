package spring.boot.tutorial.demo.customer;

import org.springframework.beans.factory.annotation.Value;
// import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConfiguration {
    @Value("${app.useFakeRepo}")
    private Boolean useFakeRepo;

    // @Bean
    // CustomerRepo customerRepo() {
    //     System.out.println("UseFakeRepo: " + useFakeRepo);
    //     return useFakeRepo? new CustomerFakeRepository(): new CustomerRepository();
    // }
}

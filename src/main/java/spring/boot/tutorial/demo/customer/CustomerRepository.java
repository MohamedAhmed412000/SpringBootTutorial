package spring.boot.tutorial.demo.customer;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query("SELECT c FROM Customer c WHERE c.email = ?1")
    Optional<Customer> findCustomerByEmail(String email);

    @Query("SELECT c FROM Customer c WHERE c.firstname = ?1 AND c.age >= ?2")
    List<Customer> filterCustomersUsingFirstNameAndAge(
        String firstName, Integer age
    );
}

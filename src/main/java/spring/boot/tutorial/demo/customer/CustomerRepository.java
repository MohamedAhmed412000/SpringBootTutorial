package spring.boot.tutorial.demo.customer;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query("SELECT c FROM Customer c WHERE c.email = ?1")
    Optional<Customer> findCustomerByEmail(String email);

    // This doesn't depend on database
    @Query("SELECT c FROM Customer c WHERE c.firstname = ?1 AND c.age >= ?2")
    List<Customer> filterCustomersUsingFirstNameAndAge(
        String firstName, Integer age
    );
    
    // This differs from Database to another
    @Query(
        value = "SELECT * FROM Customer WHERE first_name = :firstName AND age >= :age",
        nativeQuery = true    
    )
    List<Customer> filterCustomersUsingFirstNameAndAgeNative(
        @Param(value = "firstName") String firstName, 
        @Param(value = "age") Integer age
    );
}

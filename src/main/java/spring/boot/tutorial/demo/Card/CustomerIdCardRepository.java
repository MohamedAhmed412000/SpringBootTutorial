package spring.boot.tutorial.demo.Card;

import org.springframework.data.repository.CrudRepository;

public interface CustomerIdCardRepository 
        extends CrudRepository<CustomerIdCard, Long> {
    
}

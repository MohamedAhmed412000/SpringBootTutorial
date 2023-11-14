package spring.boot.tutorial.demo.customer;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity(name = "Customer")
@Table(
    name = "customer",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "email", name = "customer_email_unique")
    }
)
public class Customer {
    @Id
    @SequenceGenerator(
        name = "customer_sequence", 
        sequenceName = "customer_sequence",
        allocationSize = 1,
        initialValue = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE, 
        generator = "customer_sequence"
    )
    @Column(name = "id", updatable = false)
    private Long id;
    
    @NotBlank(message = "FirstName can't be empty")
    @Column(name = "first_name", nullable = false, columnDefinition = "TEXT")
    private String firstname;
    
    @NotBlank(message = "LastName can't be empty")
    @Column(name = "last_name", nullable = false, columnDefinition = "TEXT")
    private String lastname;
    
    @NotBlank(message = "Email can't be empty")
    @Column(name = "email", nullable = false, unique = true, columnDefinition = "TEXT")
    @Email(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")
    private String email;

    @Min(value = 16)
    @Max(value = 80)
    @Column(name = "age")
    private Integer age;
    
    @NotBlank(message = "Password can't be empty")
    @Length(min = 6, max = 20)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "password")
    private String password; 
 
    public Customer(
        @NotBlank(message = "FirstName can't be empty") String firstname,
        @NotBlank(message = "LastName can't be empty") String lastname,
        @NotBlank(message = "Email can't be empty") @Email(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$") String email,
        @Min(16) @Max(80) Integer age,
        @NotBlank(message = "Password can't be empty") @Length(min = 6, max = 20) String password
    ) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.age = age;
        this.password = password;
    }

    public Customer() {}

    @JsonProperty("customerId")
    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
    
    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }
    
    public Integer getAge() {
        return age;
    }
    
    @JsonIgnore
    public String getPassword() {
        return password;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    @Override
    public String toString() {
        return "Customer [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
                + ", age=" + age + ", password=" + password + "]";
    }

}

package com.training.springbootdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AdvancedUser {

    @Id
    @GeneratedValue
    private long id;

    @NotBlank(message = "First Name cannot be null, empty or be a white space")
    private String firstName;

    @NotBlank(message = "Last Name cannot be null, empty or be a white space")
    private String lastName;

    @NotBlank(message = "Country should not be null, empty or be a white space") //@NotNull
    private String country;

    @NotBlank(message = "Email should not be null, empty or white space")
    @Email(message = "Email should be valid")
    private String email;

    @Size(min = 10, max = 200, message = "About must be between 10 and 200 characters")
    @NotEmpty(message = "About should not be null or empty")
    private String about;

    @AssertTrue(message = "Working should be true")
    private boolean working;

    @Positive(message = "Age should be positive")  //@Negative
    @Min(value = 18, message = "Age should not be less than 18")
    @Max(value = 100, message = "Age should not be greater than 100")
    private int age;

    @PositiveOrZero(message = "Work Experience can be 0 or more years") //@NegativeOrZero
    private int workExperience;

    @PastOrPresent(message = "Last working day can be today or before") //@FutureOrPresent
    private Date lastDayAtWork;

    @Past(message = "DOB will be in past") //@Future
    private LocalDate dob;

    //private List<@NotBlank String> preferences;

    /*public Optional<@Past LocalDate> getDob2() {
        return Optional.of(dob);
    }*/
}

//@Valid on Controller method params kicks off these validating annotations
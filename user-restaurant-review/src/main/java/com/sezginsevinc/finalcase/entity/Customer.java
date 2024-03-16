package com.sezginsevinc.finalcase.entity;

import com.sezginsevinc.finalcase.general.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "CUSTOMER")
public class Customer extends BaseEntity {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Customer")
    @SequenceGenerator(name = "Customer", sequenceName = "CUSTOMER_ID_SEQ")
    @Id
    private Long id;

    @Length(min = 1, max = 100)
    @Column(name = "NAME", length = 100, nullable = false)
    private String name;

    @Length(min = 1, max = 100)
    @Column(name = "SURNAME", length = 100, nullable = false)
    private String surname;

    @Past
    @Column(name = "BIRTH_DATE")
    private LocalDate birthDate;

    @NotBlank
    @Column(name = "USERNAME", length = 100, nullable = false)
    private String username;

    @NotBlank
    @Column(name = "IDENTITY_NO", length = 11)
    private String identityNo;

    @Column(name = "PASSWORD", length = 400, nullable = false)
    private String password;

    @Column(name = "PHONE_NUMBER", length = 20)
    private String phoneNumber;

    @Email
    @NotBlank
    @Column(name = "EMAIL", length = 100, nullable = false)
    private String email;

    @Column(name = "LATITUDE", precision = 14, scale = 3)
    private BigDecimal latitude;

    @Column(name = "LONGITUDE", precision = 14, scale = 3)
    private BigDecimal longitude;
}

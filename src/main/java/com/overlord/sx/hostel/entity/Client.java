package com.overlord.sx.hostel.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"phone", "email"})})
public class Client implements AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String lastName;

    private String patronymic;

    private String phone;

    private String email;

    @OneToMany
            (fetch = FetchType.EAGER,
                    cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE},
                    mappedBy = "client")
    private Set<Order> orders;
}

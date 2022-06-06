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
public class Client implements AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String lastName;

    private String patronymic;

    private String phone;

    private String email;

    @OneToMany
    @JoinColumn(name = "order_id", nullable = false)
    private Set<Order> order;
}

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
public class Room implements AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int price;

    private String description;

    private int roomCount;

    private Double square;

    private int bedsCount;

    private int floor;

    //нифигашеньки не понял почему одинКоМногим, я думал МногиеВодного и без сета
    @OneToMany
    private Set<Category> category;

    @OneToMany
    @JoinColumn(name = "photo_id", nullable = false)
    private Set<Photo> photo;

    @OneToMany
    @JoinColumn(name = "order_id", nullable = false)
    private Set<Order> order;

}

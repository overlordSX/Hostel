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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int price;

    private String description;

    private int roomCount;

    private Double square;

    private int bedsCount;

    private int floor;

    //нифигашеньки не понял почему одинКоМногим, я думал МногиеВодного и без сета

    @ManyToOne
    private Category category;

    @OneToMany
            (fetch = FetchType.EAGER,
                    cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE},
                    mappedBy = "room")
    private Set<Photo> photos;

    @OneToMany
            (fetch = FetchType.EAGER,
                    cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE},
                    mappedBy = "room")
    private Set<Order> orders;
    //@ManyToOne
    //private Order order;

}

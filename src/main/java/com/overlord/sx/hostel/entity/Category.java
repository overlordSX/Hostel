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
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"title"})})
public class Category implements AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    @ManyToMany
    @JoinTable(name = "setOfFacilities",
            joinColumns = @JoinColumn(name = "categories", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "householdAppliances", referencedColumnName = "id")
    )
    private Set<HouseholdAppliances> householdAppliances;

    @OneToMany
            (fetch = FetchType.EAGER,
                    cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE},
                    mappedBy = "category")
    private Set<Room> rooms;
}

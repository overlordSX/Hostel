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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToMany
    @JoinTable(name="setOfFacilities",
    joinColumns = @JoinColumn(name="category_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "householdAppliances", referencedColumnName = "id")
    )
    private Set<HouseholdAppliances> householdAppliances;

    @ManyToOne
    private Room room;
}

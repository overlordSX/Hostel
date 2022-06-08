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
public class HouseholdAppliances implements AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private int cost;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "householdAppliances")
    private Set<Category> categories;
}

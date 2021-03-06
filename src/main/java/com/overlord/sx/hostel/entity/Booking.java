package com.overlord.sx.hostel.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;


@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Booking implements AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int countOfPeople;

    private Date time;

    private Date incomeDate;

    private Date outcomeDate;

    @ManyToOne
    private Client client;

    @ManyToOne
    private Room room;
}

package com.example.docker_project.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "holiday_entity")
public class HolidayEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String destination;
    private String arrive_date;
    private String departure_date;
    private String address;
    private Double accomodation_cost;

    @ManyToOne(fetch = FetchType.EAGER)
    private UserEntity user;
    @OneToMany(mappedBy = "holiday", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<PackItemEntity> packItems;
    @OneToMany(mappedBy = "holiday", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<ItemCostEntity> itemsCosts;
    @OneToMany(mappedBy = "holiday", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<TripPlanEntity> tripPlans;

}

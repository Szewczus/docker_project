package com.example.docker_project.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "holiday_entity")
public class HolidayEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String destination;
    private LocalDateTime arrive_date;
    private LocalDateTime departure_date;
    private String address;
    private Double accomodation_cost;
    @ManyToOne(fetch = FetchType.EAGER)
    private UserEntity user;
    @OneToMany(mappedBy = "holiday", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<PackItemEntity> packItemEntitySet;
    @OneToMany(mappedBy = "holiday", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<ItemCostEntity> itemCostEntitySet;
    @OneToMany(mappedBy = "holiday", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<TripPlanEntity> tripPlanEntities;

}

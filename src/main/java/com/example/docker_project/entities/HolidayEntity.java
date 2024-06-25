package com.example.docker_project.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getArrive_date() {
        return arrive_date;
    }

    public void setArrive_date(String arrive_date) {
        this.arrive_date = arrive_date;
    }

    public String getDeparture_date() {
        return departure_date;
    }

    public void setDeparture_date(String departure_date) {
        this.departure_date = departure_date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getAccomodation_cost() {
        return accomodation_cost;
    }

    public void setAccomodation_cost(Double accomodation_cost) {
        this.accomodation_cost = accomodation_cost;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}

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
    private String travel_destination;
    private String destination_address;
    private String arrive_date;
    private String departure_date;
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

    public String getDestination_address() {
        return destination_address;
    }

    public void setDestination_address(String destination_address) {
        this.destination_address = destination_address;
    }

    public String getTravel_destination() {
        return travel_destination;
    }

    public void setTravel_destination(String travel_destination) {
        this.travel_destination = travel_destination;
    }

    @Override
    public String toString() {
        return "HolidayEntity{" +
                "id=" + id +
                ", travel_destination='" + travel_destination + '\'' +
                ", destination_address='" + destination_address + '\'' +
                ", arrive_date='" + arrive_date + '\'' +
                ", departure_date='" + departure_date + '\'' +
                ", accomodation_cost=" + accomodation_cost +
                '}';
    }
}

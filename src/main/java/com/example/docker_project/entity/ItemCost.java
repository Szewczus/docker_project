package com.example.docker_project.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "item_cost_entity")
@Getter
@Setter
public class ItemCost {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String item;
    private Double cost;
    @ManyToOne(fetch = FetchType.EAGER)
    private HolidayEntity holiday;
}

package com.example.docker_project.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pack_item_entity")
@Getter
@Setter
public class PackItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String item;
    private Integer item_count;
    private String description;
    @ManyToOne(fetch = FetchType.EAGER)
    private HolidayEntity holiday;
}

package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;

@EqualsAndHashCode
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "topic")
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;
}

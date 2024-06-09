package com.example.TH_Java_Buoi3.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor


@Data
@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy ="category", cascade = CascadeType.ALL)
    private List<Book> books;
}

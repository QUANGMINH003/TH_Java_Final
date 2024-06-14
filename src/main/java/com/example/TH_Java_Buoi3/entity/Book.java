package com.example.TH_Java_Buoi3.entity;

import com.example.TH_Java_Buoi3.validator.annotation.ValidCategoryId;
import com.example.TH_Java_Buoi3.validator.annotation.ValidUserId;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor


@Data
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", length = 50)
    @NotEmpty(message = "Title must not be null")
    @Size(max = 50, min = 1, message = "Title must be less than 50 characters")
    private String title;

    @Column(name = "author", length = 50)
    @Size(max = 50, min = 1, message = "Author must be less than 50 characters")
    private String author;

    @Column(name = "price")
    @NotNull(message = "Price is required")
    @Positive(message = "Price must be greater than 0")
    private Double price;

    @ManyToOne
    @JoinColumn(name ="category_id")
    @ValidCategoryId
    private Category category;

    @ManyToOne
    @JoinColumn(name ="user_id", referencedColumnName = "id")
    @ValidUserId
    private User user;


}

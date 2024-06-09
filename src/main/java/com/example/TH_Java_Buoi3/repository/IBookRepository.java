package com.example.TH_Java_Buoi3.repository;



import com.example.TH_Java_Buoi3.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookRepository extends JpaRepository<Book, Long> {

}

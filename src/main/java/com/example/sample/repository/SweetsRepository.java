package com.example.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sample.entity.Sweets;

@Repository
public interface SweetsRepository extends JpaRepository<Sweets, String> {

}

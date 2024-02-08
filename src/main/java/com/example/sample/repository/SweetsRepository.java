package com.example.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.sample.entity.Sweets;

import jakarta.transaction.Transactional;

@Transactional  // UPDATE,DELETE時に必要
@Repository
public interface SweetsRepository extends JpaRepository<Sweets, String> {

	@Modifying  // UPDATE,DELETE時に必要
	@Query("UPDATE Sweets SET stock = (stock - :stock) where id = :id") //SQL文を書いて実行するには@Queryで宣言。SQLの中で計算も可能。
	void updateStock(@Param("stock") int stock, @Param("id") String id);

}
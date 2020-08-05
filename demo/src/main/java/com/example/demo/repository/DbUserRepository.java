package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.demo.dbfield.DbUser;

@Repository
public interface DbUserRepository extends JpaRepository<DbUser, Long> {
	List<DbUser> findAll();
}

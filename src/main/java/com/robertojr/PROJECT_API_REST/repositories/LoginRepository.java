package com.robertojr.PROJECT_API_REST.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.robertojr.PROJECT_API_REST.entities.Login;

public interface LoginRepository extends JpaRepository<Login, Long> {

}

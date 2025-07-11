package com.robertojr.PROJECT_API_REST.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.robertojr.PROJECT_API_REST.entities.Reserve;

public interface ReserveRepository extends JpaRepository<Reserve, Long> {

}

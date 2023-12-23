package com.example.transactions.Repository;

import com.example.transactions.entities.CardProgram;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardProgramRepository extends JpaRepository<CardProgram,Long> {
    CardProgram findByProgramName(String programName);
}

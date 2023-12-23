package com.example.transactions.Repository;

import com.example.transactions.entities.MappingData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TemplateCardProgramRepository extends JpaRepository<MappingData,Long> {
    List<MappingData> findAllByCardProgramId(Long card_program_id);
}

package com.example.transactions.Repository;

import com.example.transactions.entities.Template;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemplateRepository extends JpaRepository<Template,Long>{
    Template findByFeeEvent(String eventName);
    Template findTemplateById(Long id);
}
package com.example.transactions.Repository;

import com.example.transactions.entities.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card,Long> {
    Card findByCardId(long cardId);
}

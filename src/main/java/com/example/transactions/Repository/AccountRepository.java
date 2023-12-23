package com.example.transactions.Repository;

import com.example.transactions.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {
    Account findAccountByAccountNo(int no);
}

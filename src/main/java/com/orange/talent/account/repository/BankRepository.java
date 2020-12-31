package com.orange.talent.account.repository;

import com.orange.talent.account.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends JpaRepository <Bank, Long> {

    public Bank findByName(String name);
}

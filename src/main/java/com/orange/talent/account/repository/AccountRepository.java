package com.orange.talent.account.repository;

import com.orange.talent.account.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AccountRepository extends JpaRepository <Account, Long> {

    public List<Account> findByAgency(Integer agency);
}

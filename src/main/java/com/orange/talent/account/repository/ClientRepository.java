package com.orange.talent.account.repository;

import com.orange.talent.account.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository <Client, Long> {

    public Optional<Client> findByDocument(String document);
    public Optional<Client> findByEmail(String email);
    public List<Client> findByNameContains(String name);
}

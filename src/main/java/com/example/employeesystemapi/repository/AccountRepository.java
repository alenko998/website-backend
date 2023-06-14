package com.example.employeesystemapi.repository;

import com.example.employeesystemapi.entity.AccountEntity;
import com.example.employeesystemapi.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity,Long> {
    Optional<Account> findAccountEntitiesByEmailAndPassword(String email, String password);
}

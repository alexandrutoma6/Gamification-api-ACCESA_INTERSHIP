package com.alex.repository;
import com.alex.model.entity.AccountUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountUserRepository extends JpaRepository<AccountUser,Integer> {
}

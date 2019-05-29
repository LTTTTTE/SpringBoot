package com.lttttte.crudtest02.repository;

import com.lttttte.crudtest02.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {
}

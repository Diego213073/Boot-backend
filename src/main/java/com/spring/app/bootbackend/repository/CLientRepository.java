package com.spring.app.bootbackend.repository;

import com.spring.app.bootbackend.model.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CLientRepository extends CrudRepository<Client,String> {

}

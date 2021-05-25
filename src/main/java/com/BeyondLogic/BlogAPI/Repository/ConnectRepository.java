package com.BeyondLogic.BlogAPI.Repository;

import com.BeyondLogic.BlogAPI.Model.Connection;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConnectRepository extends CrudRepository<Connection, Long> {

}

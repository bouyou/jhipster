package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.Borne;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Spring Data MongoDB repository for the Borne entity.
 */
@SuppressWarnings("unused")
@Repository
public interface BorneRepository extends MongoRepository<Borne, String> {}

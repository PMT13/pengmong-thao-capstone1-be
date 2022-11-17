package net.yorksolutions.pengmongthaocapstone1be.repositories;

import net.yorksolutions.pengmongthaocapstone1be.models.Response;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponseRepository extends CrudRepository<Response, Long> {
}

package net.yorksolutions.pengmongthaocapstone1be.repositories;

import net.yorksolutions.pengmongthaocapstone1be.models.SurveyResponses;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SurveyResponsesRepository extends CrudRepository<SurveyResponses, Long> {
    public Iterable<SurveyResponses> findAllBySurveyId(Long id);

}

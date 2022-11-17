package net.yorksolutions.pengmongthaocapstone1be.repositories;

import net.yorksolutions.pengmongthaocapstone1be.models.Question;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Long> {
}

package ru.markelov.simpleSecurity.repositories;

import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.markelov.simpleSecurity.entities.Score;

@Repository

public interface ScoreRepository extends CrudRepository<Score, Integer> {
}

package dev.franzon.readlock.repository;

import dev.franzon.readlock.entity.Example;
import dev.franzon.readlock.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import javax.persistence.LockModeType;
import java.util.List;
import java.util.UUID;

@Repository
public interface ExampleRepository extends JpaRepository<Example, UUID> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    List<Example> findByStatus(Status status);
}

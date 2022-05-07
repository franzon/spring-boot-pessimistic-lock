package dev.franzon.readlock;

import dev.franzon.readlock.entity.Example;
import dev.franzon.readlock.entity.Status;
import dev.franzon.readlock.repository.ExampleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.List;
import java.util.logging.Logger;

@Component
@RequiredArgsConstructor
public class Scheduler {

    private static final Logger logger = Logger.getLogger(Scheduler.class.getSimpleName());

    private final ExampleRepository repository;
    private final MockService mockService;

    @Scheduled(fixedDelay = 10000)
    @Transactional
    public void scheduler() {
        logger.info("Scheduler executed");

        try {
            List<Example> examples = repository.findByStatus(Status.PENDING);
            logger.info("Examples: " + examples);

            examples.forEach(mockService::execute);
        } catch (Exception ex) {
            logger.info("Error: " + ex);
        }


    }

    @PostConstruct
    void loadData() {
        repository.save(new Example(1L, Status.PENDING));
        repository.save(new Example(2L, Status.PENDING));
        repository.save(new Example(3L, Status.PENDING));
        repository.save(new Example(4L, Status.PENDING));
        repository.save(new Example(5L, Status.PENDING));
        repository.save(new Example(6L, Status.PENDING));
        repository.save(new Example(7L, Status.PENDING));
        repository.save(new Example(8L, Status.PENDING));
        repository.save(new Example(9L, Status.PENDING));

    }
}

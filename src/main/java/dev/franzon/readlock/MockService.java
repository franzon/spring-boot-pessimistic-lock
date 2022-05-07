package dev.franzon.readlock;

import dev.franzon.readlock.entity.Example;
import dev.franzon.readlock.entity.Status;
import dev.franzon.readlock.repository.ExampleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@RequiredArgsConstructor
@Service
public class MockService {
    private static final Logger logger = Logger.getLogger(MockService.class.getSimpleName());

    private final ExampleRepository repository;

    public void execute(Example example) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        example.setStatus(Status.EXECUTED);
        repository.save(example);

        logger.info("MockService executed: " + example);
    }
}

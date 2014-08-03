package pro.krasikov.sample.dao.impl;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import pro.krasikov.sample.dao.TaskRepository;
import pro.krasikov.sample.model.Task;

/**
 * @author Vladimir Krasikov (mailto: vladimir@krasikov.pro)
 *         Date: 03.08.2014.
 */
@Repository
public class TaskRepositoryImpl implements TaskRepository {
    @Override
    @Cacheable("tasks")
    public Task getByNameContains(String testToSearch) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ignored) {
        }
        return new Task("task name", "task description");
    }
}

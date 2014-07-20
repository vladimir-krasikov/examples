package pro.krasikov.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.krasikov.sample.controller.helper.CommonCRUDController;
import pro.krasikov.sample.dao.TaskRepository;
import pro.krasikov.sample.domain.Task;

/**
 * @author Vladimir Krasikov (mailto: vladimir@krasikov.pro)
 *         Date: 19.07.2014.
 */
@RestController
@RequestMapping("/api/task")
public class TaskController extends CommonCRUDController<Task> {

    @Autowired
    protected TaskController(TaskRepository repository) {
        super(repository);
    }
}

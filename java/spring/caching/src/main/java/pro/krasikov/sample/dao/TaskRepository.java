package pro.krasikov.sample.dao;

import pro.krasikov.sample.model.Task;

/**
 * @author Vladimir Krasikov (mailto: vladimir@krasikov.pro)
 *         Date: 03.08.2014.
 */
public interface TaskRepository {

    Task getByNameContains(String testToSearch);

}

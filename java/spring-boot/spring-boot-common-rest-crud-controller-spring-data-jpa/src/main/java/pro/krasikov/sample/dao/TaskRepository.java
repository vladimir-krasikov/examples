package pro.krasikov.sample.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pro.krasikov.sample.domain.Task;

/**
 * @author Vladimir Krasikov (mailto: vladimir@krasikov.pro)
 *         Date: 19.07.2014.
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{
}

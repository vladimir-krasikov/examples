package pro.krasikov.samle.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pro.krasikov.samle.domain.Task;

/**
 * @author Vladimir Krasikov (mailto: vladimir@krasikov.pro)
 *         Date: 31.07.2014.
 */
@RepositoryRestResource(collectionResourceRel = "task", path = "task")
public interface TaskRepository extends JpaRepository<Task, Long> {
    Page<Task> findByNameContaining(@Param("text") String text, Pageable pageable);
}

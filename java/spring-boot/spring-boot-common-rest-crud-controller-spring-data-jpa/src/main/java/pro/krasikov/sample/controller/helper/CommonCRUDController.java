package pro.krasikov.sample.controller.helper;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pro.krasikov.sample.domain.helper.HasId;

import javax.validation.ValidationException;

/**
 * @author Vladimir Krasikov (mailto: vladimir@krasikov.pro)
 *         Date: 19.07.2014.
 */
public class CommonCRUDController<T extends HasId> {

    private final JpaRepository<T, Long> repository;

    protected CommonCRUDController(JpaRepository<T, Long> repository) {
        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Page<T> getAll(
            @RequestParam int page,
            @RequestParam int size) {
        return repository.findAll(
                new PageRequest(page, size));
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public T create(@RequestBody T task) {
        return repository.save(task);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public T getOne(@PathVariable long id) {
        return repository.findOne(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public T update(
            @PathVariable long id,
            @RequestBody T task) {
        if (task.getId() == null || task.getId() != id) {
            throw new ValidationException("id must not be null and equals to path variable value");
        }
        return repository.save(task);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id) {
        repository.delete(id);
    }
}

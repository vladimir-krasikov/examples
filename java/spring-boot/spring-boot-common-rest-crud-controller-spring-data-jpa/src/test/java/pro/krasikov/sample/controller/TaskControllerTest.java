package pro.krasikov.sample.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import pro.krasikov.sample.config.TestConfig;
import pro.krasikov.sample.dao.TaskRepository;
import pro.krasikov.sample.domain.Task;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfig.class})
@WebAppConfiguration
public class TaskControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private TaskRepository taskRepositoryMock;

    @Autowired
    private List<Task> tasks;

    @Autowired
    private MediaType applicationJsonUtf8;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        Mockito.reset(taskRepositoryMock);
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void getAll_TwoTasks_ShouldReturnCorrectContentWithTwoTasksInOnePage() throws Exception {
        int page = 0;
        int size = 10;
        PageRequest pageRequest = new PageRequest(page, size);

        when(taskRepositoryMock.findAll(pageRequest))
                .thenReturn(new PageImpl<>(tasks, pageRequest, tasks.size()));

        mockMvc.perform(
                get("/api/task")
                        .param("page", String.valueOf(page))
                        .param("size", String.valueOf(size)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(applicationJsonUtf8))
                .andExpect(jsonPath("totalPages", is(1)))
                .andExpect(jsonPath("numberOfElements", is(tasks.size())))
                .andExpect(jsonPath("$.content.[0].name", is(tasks.get(0).getName())))
                .andExpect(jsonPath("$.content.[0].description", is(tasks.get(0).getDescription())))
                .andExpect(jsonPath("$.content.[1].name", is(tasks.get(1).getName())))
                .andExpect(jsonPath("$.content.[1].description", is(tasks.get(1).getDescription())));

        verify(taskRepositoryMock, times(1)).findAll(pageRequest);
        verifyNoMoreInteractions(taskRepositoryMock);
    }

    @Test
    public void getAll_TwoTasks_ShouldReturnTwoTasksInTwoPage() throws Exception {
        int page = 0;
        int size = 1;
        PageRequest pageRequest = new PageRequest(page, size);

        when(taskRepositoryMock.findAll(pageRequest))
                .thenReturn(new PageImpl<>(tasks, pageRequest, tasks.size()));

        mockMvc.perform(
                get("/api/task")
                        .param("page", String.valueOf(page))
                        .param("size", String.valueOf(size)))
                .andExpect(jsonPath("totalPages", is(2)));
    }
}
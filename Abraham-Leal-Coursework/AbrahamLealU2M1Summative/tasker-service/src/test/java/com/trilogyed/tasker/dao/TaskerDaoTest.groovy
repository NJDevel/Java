package com.trilogyed.tasker.dao

import com.trilogyed.tasker.model.Task
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

import java.time.LocalDate

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
class TaskerDaoTest extends groovy.util.GroovyTestCase {
    @Autowired
    protected TaskerDao dao;

    @Before
    void setUp() throws Exception {
        List<Task> tasks = dao.getAllTasks();
        for (Task task : tasks) {
            dao.deleteTask(task.getId());
        }
    }
    @Test
    void testCreateGetDeleteTask() {

        Task task = new Task();
        task.setDescription("Take out the garbage")
        task.setCreateDate(LocalDate.of(2019, 9, 18));
        task.setDueDate(LocalDate.of(2019, 9,25));
        task.setCategory("Chores");

        task = dao.createTask(task);

        Task task1 = dao.getTask(task.getId());

        assertEquals(task, task1);

        Task task2 = new Task();
        task2.setDescription("Feed the pets")
        task2.setCreateDate(LocalDate.of(2019, 9, 23));
        task2.setDueDate(LocalDate.of(2019, 9, 24));
        task2.setCategory("Chores");

        task2 = dao.createTask(task2);

        assertEquals(2, dao.getAllTasks().size());

        dao.deleteTask(task2.getId());

        assertEquals(1, dao.getAllTasks().size());
    }

    @Test
    void testGetAllTasks() {
        Task task = new Task();
        task.setDescription("Take out the garbage")
        task.setCreateDate(LocalDate.of(2019, 9, 18));
        task.setDueDate(LocalDate.of(2019, 9,25));;
        task.setCategory("Chores");

        task = dao.createTask(task);

        Task task2 = new Task();
        task2.setDescription("Feed the pets")
        task2.setCreateDate(LocalDate.of(2019, 9, 23));
        task2.setDueDate(LocalDate.of(2019, 9, 24));
        task2.setCategory("Chores");

        task2 = dao.createTask(task2);

        assertEquals(2, dao.getAllTasks().size());
    }

    @Test
    void testUpdateTask() {
        Task task = new Task();
        task.setDescription("Take out the garbage")
        task.setCreateDate(LocalDate.of(2019, 9, 18));
        task.setDueDate(LocalDate.of(2019, 9,25));;
        task.setCategory("Chores");

        task = dao.createTask(task);
        int id = task.getId();

        task.setDescription("Feed the pets")
        task.setCreateDate(LocalDate.of(2019, 9, 23));
        task.setDueDate(LocalDate.of(2019, 9, 24));
        task.setCategory("Chores");

        dao.updateTask(task);

        assertEquals(task, dao.getTask(id));
    }

}

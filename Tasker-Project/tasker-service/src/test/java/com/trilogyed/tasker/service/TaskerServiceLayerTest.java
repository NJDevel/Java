package com.trilogyed.tasker.service;

import com.trilogyed.tasker.dao.TaskerDao;
import com.trilogyed.tasker.model.Task;
import com.trilogyed.tasker.model.TaskViewModel;
import com.trilogyed.tasker.util.feign.AdServerClient;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class TaskerServiceLayerTest {

    private TaskerServiceLayer serviceLayer;
    private TaskerDao taskerDao;
    private AdServerClient adServerClient;

    final static private String AD = "$5 off your next purchase at WackDonald's!!!";

    @Before
    public void setUp() throws Exception{
        setUpAdServerClientFeignMock();
        setUpTaskerDao();
        serviceLayer = new TaskerServiceLayer(taskerDao, adServerClient);
    }

    @Test
    public void fetchAllTasks() {
        assertEquals(1,serviceLayer.fetchAllTasks().size());
    }

    @Test
    public void newTask() {

        Task task = new Task();
        task.setId(1);
        task.setDescription("Reserve meeting room");
        task.setCreateDate(LocalDate.of(2019,9,24));
        task.setDueDate(LocalDate.of(2019, 9, 25));
        task.setCategory("Work");

        Task task1 = new Task();
        task1.setDescription("Reserve meeting room");
        task1.setCreateDate(LocalDate.of(2019,9,24));
        task1.setDueDate(LocalDate.of(2019, 9, 25));
        task1.setCategory("Work");

        TaskViewModel tvm = new TaskViewModel(task1);

        TaskViewModel tvm1 = new TaskViewModel();

        //Retrieves ID from task object in service layer
        tvm1 = serviceLayer.newTask(tvm);
        task1.setId(tvm1.getId());

        assertEquals(task, task1);

        assertEquals(tvm1.getAdvertisement(), AD);
    }

    @Test
    public void updateTask() {

        TaskViewModel tvm = serviceLayer.fetchTask(1);

        Task updateTask = new Task();
        updateTask.setId(1);
        updateTask.setDescription("Take out the garbage");
        updateTask.setCreateDate(LocalDate.of(2010,8,30));
        updateTask.setDueDate(LocalDate.of(2010, 9, 7));
        TaskViewModel updateTVM = new TaskViewModel(updateTask);

        updateTask.setCategory("Chores");

        serviceLayer.updateTask(updateTVM);

        assertNotEquals(tvm, updateTask);


    }

    @Test
    public void fetchAllTasksByCategory() {
        assertEquals(1,serviceLayer.fetchTasksByCategory("Work").size());

        assertEquals(0, serviceLayer.fetchTasksByCategory("Chores").size());
    }

    private void setUpAdServerClientFeignMock() {
        adServerClient = mock(AdServerClient.class);
        doReturn(AD).when(adServerClient).getAd();
    }

    private void setUpTaskerDao() {
        taskerDao = mock(TaskerDao.class);

        Task task = new Task();
        task.setId(1);
        task.setDescription("Reserve meeting room");
        task.setCreateDate(LocalDate.of(2019,9,24));
        task.setDueDate(LocalDate.of(2019, 9, 25));
        task.setCategory("Work");

        TaskViewModel tvm = new TaskViewModel();
        tvm.setId(task.getId());
        tvm.setDescription(task.getDescription());
        tvm.setCreateDate(task.getCreateDate());
        tvm.setDueDate(task.getDueDate());
        tvm.setDescription(adServerClient.getAd());

        Task task1 = new Task();
        task1.setDescription("Reserve meeting room");
        task1.setCreateDate(LocalDate.of(2019,9,24));
        task1.setDueDate(LocalDate.of(2019, 9, 25));
        task1.setCategory("Work");

        //Mock create task
        doReturn(task).when(taskerDao).createTask(task1);

        //Mock get Task
        doReturn(task).when(taskerDao).getTask(1);

        List<Task> tasks = new ArrayList<>();
        tasks.add(task);
        //Mock get Task by Category
        doReturn(tasks).when(taskerDao).getTasksByCategory("Work");

        //Mock get all tasks
        doReturn(tasks).when(taskerDao).getAllTasks();

        //Mock update task
        Task updateTask = new Task();
        updateTask.setId(1);
        updateTask.setDescription("Take out the garbage");
        updateTask.setCreateDate(LocalDate.of(2010,8,30));
        updateTask.setDueDate(LocalDate.of(2010, 9, 7));
        updateTask.setCategory("Chores");

        doNothing().when(taskerDao).updateTask(updateTask);

        //Delete task
        doNothing().when(taskerDao).deleteTask(1);
    }
}
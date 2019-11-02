package com.trilogyed.tasker.service;

import com.trilogyed.tasker.dao.TaskerDao;
import com.trilogyed.tasker.exception.TaskNotFoundException;
import com.trilogyed.tasker.model.Task;
import com.trilogyed.tasker.model.TaskViewModel;
import com.trilogyed.tasker.util.feign.AdServerClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TaskerServiceLayer {

    @Autowired
    TaskerDao dao;
    @Autowired
    private AdServerClient adServerClient;

    public TaskerServiceLayer(TaskerDao taskerDao, AdServerClient adServerClient) {
        this.dao = taskerDao;
        this.adServerClient = adServerClient;
    }

    public TaskViewModel fetchTask(int id) {
        Task task = new Task();
        task = dao.getTask(id);
        if (task == null) {
            throw new TaskNotFoundException("The task ID you entered does not exist in our database. Task ID: " + id);
        }
        TaskViewModel tvm = new TaskViewModel();

        tvm.setId(task.getId());
        tvm.setDescription(task.getDescription());
        tvm.setCreateDate(task.getCreateDate());
        tvm.setDueDate(task.getDueDate());
        tvm.setCategory(task.getCategory());
        // get ad from Adserver and put in tvm
        tvm.setAdvertisement(adServerClient.getAd());
        return tvm;
    }

    public List<TaskViewModel> fetchAllTasks() {
        List<Task> tasks = dao.getAllTasks();
        List<TaskViewModel> taskViewModelList = new ArrayList<>();
        for (Task task : tasks) {
            taskViewModelList.add(buildTaskViewModel(task));
        }
        return taskViewModelList;
    }

    public List<TaskViewModel> fetchTasksByCategory(String category) {
        List<Task> tasks = dao.getTasksByCategory(category);
        List<TaskViewModel> taskViewModelList = new ArrayList<>();
        for (Task task : tasks) {
            taskViewModelList.add(buildTaskViewModel(task));
        }
        return taskViewModelList;
    }

    public TaskViewModel newTask(TaskViewModel taskViewModel) {

        Task task = new Task();
        task.setDescription(taskViewModel.getDescription());
        task.setCreateDate(taskViewModel.getCreateDate());
        task.setDueDate(taskViewModel.getDueDate());
        task.setCategory(taskViewModel.getCategory());

        task = dao.createTask(task);
        taskViewModel.setId(task.getId());

        //get ad from Adserver and put in taskViewModel
        taskViewModel.setAdvertisement(adServerClient.getAd());

        return taskViewModel;
    }

    public void deleteTask(int id) {
        if(fetchTask(id) == null) {
            throw new TaskNotFoundException("The task ID you entered does not exist in our database. Task ID: " + id);
        }
        dao.deleteTask(id);
    }

    public void updateTask(TaskViewModel taskViewModel) {
        Task task = new Task();
        task.setId(taskViewModel.getId());
        task.setCreateDate(taskViewModel.getCreateDate());
        task.setDueDate(taskViewModel.getDueDate());
        task.setCategory(taskViewModel.getCategory());
        try {
            dao.updateTask(task);
        } catch (TaskNotFoundException e) {
            throw new TaskNotFoundException("The task ID you entered does not exist in our database. Task ID: " + task.getId());
        }
    }

    private TaskViewModel buildTaskViewModel(Task task) {
        TaskViewModel tvm = new TaskViewModel();

        tvm.setId(task.getId());
        tvm.setDescription(task.getDescription());
        tvm.setCreateDate(task.getCreateDate());
        tvm.setDueDate(task.getDueDate());
        tvm.setCategory(task.getCategory());

        tvm.setAdvertisement(adServerClient.getAd());

        return tvm;

    }
}

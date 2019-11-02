package com.trilogyed.tasker.controller;

import com.trilogyed.tasker.model.TaskViewModel;
import com.trilogyed.tasker.service.TaskerServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class TaskerController {

    @Autowired
    TaskerServiceLayer service;

    public TaskerController(TaskerServiceLayer service) {
        this.service = service;
    }

    /**Create a new Task
     *
     * @param tvm
     */
    @RequestMapping(value = "/tasks", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public TaskViewModel createTask(@RequestBody @Valid TaskViewModel tvm) {
        return service.newTask(tvm);
    }

    /**Update a Task
     *
     * @param tvm
     */
    @RequestMapping(value = "/tasks", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void updateTask(@RequestBody @Valid TaskViewModel tvm) { service.updateTask(tvm); }

    /**Get a Task
     *
     * @param id
     */
    @RequestMapping(value = "/tasks/{id}", method = RequestMethod.GET)
    public TaskViewModel findTask(@PathVariable int id) {
        return service.fetchTask(id);
    }

    /**Get all Tasks
     *
     *
     */
    @RequestMapping(value = "/tasks", method = RequestMethod.GET)
    public List<TaskViewModel> findAllTasks() { return service.fetchAllTasks(); }

    /**Get all Tasks
     *
     *
     */
    @RequestMapping(value = "/tasks/category/{category}", method = RequestMethod.GET)
    public List<TaskViewModel> findTaskByCategory(@PathVariable String category) {return service.fetchTasksByCategory(category); }

    /**Delete Task
     *
     * @param id
     */
    @RequestMapping(value = "/tasks/{id}", method = RequestMethod.DELETE)
    public void deleteTask(@PathVariable int id) {
        service.deleteTask(id);
    }


}

package com.trilogyed.tasker.model;

import javax.validation.constraints.Size;
import java.time.LocalDate;

public class TaskViewModel {
    private int id;
    @Size(min= 1, max = 255, message = "The description entered is too long.  Please keep under 255 characters.")
    private String description;
    //@PastOrPresent
    private LocalDate createDate;
    //@PastOrPresent
    private LocalDate dueDate;
    @Size(min= 1, max = 50, message = "The description entered is too long.  Please keep under 50 characters.")
    private String category;
    private String advertisement;

    public TaskViewModel() {}

    public TaskViewModel(Task task) {
        this.description = task.getDescription();
        this.createDate = task.getCreateDate();
        this.dueDate = task.getDueDate();
        this.category = task.getCategory();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAdvertisement() {
        return advertisement;
    }

    public void setAdvertisement(String advertisement) {
        this.advertisement = advertisement;
    }
}

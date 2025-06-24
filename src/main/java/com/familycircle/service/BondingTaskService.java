package com.familycircle.service;

import com.familycircle.model.BondingTask;
import com.familycircle.model.User;

import java.util.List;

public interface BondingTaskService {
    void saveTask(BondingTask task);
    List<BondingTask> getTasksForUser(User user);
    void markTaskCompleted(Long taskId);
}

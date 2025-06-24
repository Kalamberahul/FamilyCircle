package com.familycircle.service;

import com.familycircle.model.BondingTask;
import com.familycircle.model.User;
import com.familycircle.repository.BondingTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BondingTaskServiceImpl implements BondingTaskService {

    @Autowired
    private BondingTaskRepository bondingTaskRepository;

    @Override
    public void saveTask(BondingTask task) {
        bondingTaskRepository.save(task);
    }

    @Override
    public List<BondingTask> getTasksForUser(User user) {
        return bondingTaskRepository.findByUser(user);
    }

    @Override
    public void markTaskCompleted(Long taskId) {
        Optional<BondingTask> taskOptional = bondingTaskRepository.findById(taskId);
        if (taskOptional.isPresent()) {
            BondingTask task = taskOptional.get();
            task.setCompleted(true);
            bondingTaskRepository.save(task);
        }
    }
}

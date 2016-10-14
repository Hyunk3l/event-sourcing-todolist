package todolist.Application.CreateTask;

import todolist.Domain.Task;
import todolist.Domain.TaskRepository;

import java.util.UUID;

public class CreateTask {
  private final TaskRepository taskRepository;

  public CreateTask(TaskRepository taskRepository) {

    this.taskRepository = taskRepository;
  }

  public Task execute(String description) {

    Task createdTask = new Task(
        UUID.randomUUID(),
        description
    );
    this.taskRepository.persist(createdTask);

    return createdTask;
  }
}

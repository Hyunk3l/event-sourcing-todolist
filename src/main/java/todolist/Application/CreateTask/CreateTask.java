package todolist.Application.CreateTask;

import todolist.Domain.Task;
import todolist.Domain.TaskId;
import todolist.Domain.TaskRepository;

import java.util.UUID;

public class CreateTask {
  private final TaskRepository taskRepository;

  public CreateTask(TaskRepository taskRepository) {

    this.taskRepository = taskRepository;
  }

  public CreateTaskResponse execute(CreateTaskRequest createTaskRequest) {

    Task createdTask = Task.create(
        new TaskId(),
        createTaskRequest.getDescription()
    );
    this.taskRepository.persist(createdTask);

    return new CreateTaskResponse(
        createdTask.getId().toString(),
        createdTask.getDescription()
    );
  }
}

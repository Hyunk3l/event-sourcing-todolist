package todolist.Application.GetTasks;

import todolist.Domain.Task;
import todolist.Domain.TaskRepository;

import java.util.List;

public class GetTasks {

  private final TaskRepository taskRepository;

  public GetTasks(TaskRepository taskRepository){
    this.taskRepository = taskRepository;
  }

  public List<Task> execute() {
    return taskRepository.findAll();
  }
}

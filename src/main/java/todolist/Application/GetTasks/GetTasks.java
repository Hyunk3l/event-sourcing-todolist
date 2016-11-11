package todolist.Application.GetTasks;

import todolist.Domain.Task;
import todolist.Domain.TaskRepository;

import java.util.List;

public class GetTasks {

  private final TaskRepository taskRepository;

  public GetTasks(TaskRepository taskRepository){
    this.taskRepository = taskRepository;
  }

  public List<GetTasksResponse> execute() {
    List<Task> tasks = taskRepository.findAll();

    return GetTasksResponse.buildFrom(tasks);
  }
}

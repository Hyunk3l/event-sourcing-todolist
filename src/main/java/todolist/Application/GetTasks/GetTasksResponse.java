package todolist.Application.GetTasks;

import todolist.Domain.Task;

import java.util.List;
import java.util.stream.Collectors;

public class GetTasksResponse {

  private final String id;
  private final String description;

  public GetTasksResponse(String id, String description) {
    this.id = id;
    this.description = description;
  }

  public String getId() {
    return id;
  }

  public String getDescription() {
    return description;
  }

  public static List<GetTasksResponse> buildFrom(List<Task> tasksList) {
    return tasksList
        .stream()
        .map(GetTasksResponse::createDto)
        .collect(Collectors.toList());
  }

  private static GetTasksResponse createDto(Task task) {
    return new GetTasksResponse(task.getId().toString(), task.getDescription());
  }
}

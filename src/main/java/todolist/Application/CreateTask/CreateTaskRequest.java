package todolist.Application.CreateTask;

public class CreateTaskRequest {
  private String description;

  public CreateTaskRequest(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }
}

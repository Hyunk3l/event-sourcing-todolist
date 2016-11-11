package todolist.Application.CreateTask;

public class CreateTaskResponse {

  private final String id;
  private final String description;

  public CreateTaskResponse(String id, String description) {
    this.id = id;
    this.description = description;
  }

  public String getId() {
    return id;
  }

  public String getDescription() {
    return description;
  }
}

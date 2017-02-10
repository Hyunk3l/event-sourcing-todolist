package todolist.Domain;

import java.util.UUID;

public class TaskId {
  private final UUID id;

  public TaskId(UUID id) {
    this.id = id;
  }

  public TaskId() {
    this.id = UUID.randomUUID();
  }

  public UUID getId() {
    return id;
  }
}

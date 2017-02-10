package todolist.Domain.Events;

import todolist.Domain.TaskId;

import java.time.Instant;

public class TaskCreatedEvent implements Event {
  private final TaskId id;
  private final String description;
  private Instant createdAt;
  private Instant modifiedAt;

  public TaskCreatedEvent(TaskId id, String description, Instant createdAt, Instant modifiedAt) {
    this.id = id;
    this.description = description;
    this.createdAt = createdAt;
    this.modifiedAt = modifiedAt;
  }

  public TaskId getId() {
    return id;
  }

  public String getDescription() {
    return description;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public Instant getModifiedAt() {
    return modifiedAt;
  }
}

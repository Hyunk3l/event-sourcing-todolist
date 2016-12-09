package todolist.Domain.Events;

import java.time.Instant;

public class TaskCreatedEvent implements Event {
  private final String id;
  private final String description;
  private Instant createdAt;
  private Instant modifiedAt;

  public TaskCreatedEvent(String id, String description, Instant createdAt, Instant modifiedAt) {
    this.id = id;
    this.description = description;
    this.createdAt = createdAt;
    this.modifiedAt = modifiedAt;
  }

  public String getId() {
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

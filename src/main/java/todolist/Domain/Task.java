package todolist.Domain;

import java.time.Instant;
import java.util.UUID;

public class Task {
  private final UUID id;
  private final String description;
  private final Instant createdAt;
  private final Instant modifiedAt;

  public Task(
      UUID id,
      String description
  ) {
    this.id = id;
    this.description = description;
    this.createdAt = Instant.now();
    this.modifiedAt = Instant.now();
  }

  public UUID getId() {
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

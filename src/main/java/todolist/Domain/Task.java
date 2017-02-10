package todolist.Domain;

import todolist.Domain.Events.Event;
import todolist.Domain.Events.TaskCreatedEvent;
import todolist.Domain.Events.UpdatedDescriptionEvent;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Task {
  private UUID id;
  private String description;
  private Instant createdAt;
  private Instant modifiedAt;
  private List<Event> events = new ArrayList<>();

  private Task() {
  }

  public static Task create(UUID id, String description) {
    Task task = new Task();
    task.publish(new TaskCreatedEvent(id.toString(), description, Instant.now(), Instant.now()));
    return task;
  }

  public void updateDescription(String newDescription) {
    publish(new UpdatedDescriptionEvent(newDescription));
  }

  private void publish(Event event) {
    events.add(event);
    apply(event);
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

  public List recordedEvents() {
    return events;
  }

  public void apply(Event event) {
    if (event instanceof TaskCreatedEvent) {
      apply((TaskCreatedEvent) event);
    } else if (event instanceof UpdatedDescriptionEvent) {
      apply((UpdatedDescriptionEvent) event);
    }
  }

  public void apply(TaskCreatedEvent taskCreatedEvent) {
    this.id = UUID.fromString(taskCreatedEvent.getId());
    this.description = taskCreatedEvent.getDescription();
    this.createdAt = taskCreatedEvent.getCreatedAt();
    this.modifiedAt = taskCreatedEvent.getModifiedAt();
  }

  public void apply(UpdatedDescriptionEvent updatedDescriptionEvent) {
    this.description = updatedDescriptionEvent.getDescription();
    this.modifiedAt = Instant.now();
  }
}

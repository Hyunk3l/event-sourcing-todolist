package todolist.Domain;

import org.junit.Test;
import todolist.Domain.Events.TaskCreatedEvent;

import java.time.Instant;
import java.util.UUID;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TaskTest {
  @Test
  public void itShouldRecordCreationEvent() {
    String description = "Any valid description.";
    UUID id = UUID.randomUUID();
    Task task = Task.create(id, description);

    assertThat(task.recordedEvents().get(0), instanceOf(TaskCreatedEvent.class));
    assertThat(((TaskCreatedEvent) task.recordedEvents().get(0)).getId(), is(id.toString()));
    assertThat(((TaskCreatedEvent) task.recordedEvents().get(0)).getDescription(), is(description));
    assertThat(((TaskCreatedEvent) task.recordedEvents().get(0)).getCreatedAt(), instanceOf(Instant.class));
    assertThat(((TaskCreatedEvent) task.recordedEvents().get(0)).getModifiedAt(), instanceOf(Instant.class));
  }

  @Test
  public void itShouldApplyCreatedEvent() throws Exception {
    Task task = Task.create(UUID.randomUUID(), "Any valid description.");
    task.apply(new TaskCreatedEvent(UUID.randomUUID().toString(), "Any valid description.", Instant.now(), Instant.now()));

    assertThat(task.getDescription(), is("Any valid description."));
  }

  @Test
  public void itShouldUpdateDescription() throws Exception {
    Task task = Task.create(UUID.randomUUID(), "Any valid description.");
    task.updateDescription("Another valid description.");
    assertThat(task.getDescription(), is("Another valid description."));
  }
}
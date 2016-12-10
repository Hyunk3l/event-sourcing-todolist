package todolist.Domain;

import org.junit.Before;
import org.junit.Test;
import todolist.Domain.Events.TaskCreatedEvent;

import java.time.Instant;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

public class TaskTest {

  private static final String VALID_DESCRIPTION = "Any valid description.";
  private static final TaskId VALID_ID = new TaskId();
  private static final String ANOTHER_VALID_DESCRIPTION = "Another valid description.";

  private Task task;

  @Before
  public void setUp() {
    this.task = Task.create(VALID_ID, VALID_DESCRIPTION);
  }

  @Test
  public void itShouldRecordCreationEvent() {

    TaskCreatedEvent taskCreatedEvent = (TaskCreatedEvent) task.recordedEvents().get(0);

    assertThat(taskCreatedEvent.getId(), is(VALID_ID));
    assertThat(taskCreatedEvent.getDescription(), is(VALID_DESCRIPTION));
    assertThat(taskCreatedEvent.getCreatedAt(), instanceOf(Instant.class));
    assertThat(taskCreatedEvent.getModifiedAt(), instanceOf(Instant.class));
  }

  @Test
  public void itShouldApplyCreatedEvent() throws Exception {
    task.apply(new TaskCreatedEvent(VALID_ID, VALID_DESCRIPTION, Instant.now(), Instant.now()));

    assertThat(task.getDescription(), is(VALID_DESCRIPTION));
  }

  @Test
  public void itShouldUpdateDescription() throws Exception {

    Instant oldModifiedAt = task.getModifiedAt();
    task.updateDescription(ANOTHER_VALID_DESCRIPTION);

    assertThat(task.getDescription(), is(ANOTHER_VALID_DESCRIPTION));
    assertThat(task.getModifiedAt(), not(oldModifiedAt));
  }
}
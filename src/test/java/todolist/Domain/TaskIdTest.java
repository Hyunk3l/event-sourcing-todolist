package todolist.Domain;

import org.junit.Test;

import java.util.UUID;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TaskIdTest {

  @Test
  public void shouldStoreUuid() {

    UUID expectedId = UUID.randomUUID();
    TaskId taskId = new TaskId(expectedId);

    assertThat(expectedId, is(taskId.getId()));
  }

  @Test
  public void shouldGenerateId() {
    TaskId taskId = new TaskId();

    assertThat(taskId.getId(), instanceOf(UUID.class));
  }
}

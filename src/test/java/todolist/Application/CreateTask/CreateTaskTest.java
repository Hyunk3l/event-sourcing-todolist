package todolist.Application.CreateTask;

import org.junit.Test;
import org.mockito.Mockito;
import todolist.Domain.Task;
import todolist.Domain.TaskRepository;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class CreateTaskTest {

  private static final String VALID_TASK_DESCRIPTION = "just a task";

  @Test
  public void shouldCreateTask() {
    TaskRepository taskRepository = Mockito.mock(TaskRepository.class);

    CreateTask createTask = new CreateTask(taskRepository);

    Task createdTask = createTask.execute(VALID_TASK_DESCRIPTION);

    assertEquals(VALID_TASK_DESCRIPTION, createdTask.getDescription());
    assertTrue(createdTask.getId() != null);
  }
}

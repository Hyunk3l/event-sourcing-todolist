package todolist.Application.CreateTask;

import org.junit.Test;
import todolist.Domain.Task;
import todolist.Domain.TaskRepository;
import todolist.Infrastructure.Persistence.InMemoryTaskRepository;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class CreateTaskTest {

  private static final String VALID_TASK_DESCRIPTION = "just a task";

  @Test
  public void shouldCreateTask() {
    TaskRepository taskRepository = new InMemoryTaskRepository();

    CreateTask createTask = new CreateTask(taskRepository);

    CreateTaskResponse createdTaskResponse = createTask.execute(
        new CreateTaskRequest(VALID_TASK_DESCRIPTION)
    );

    assertEquals(VALID_TASK_DESCRIPTION, createdTaskResponse.getDescription());
    assertTrue(createdTaskResponse.getId() != null);
  }
}

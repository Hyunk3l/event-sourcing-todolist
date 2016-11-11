package todolist.Application.GetTasks;

import org.junit.Test;
import todolist.Domain.Task;
import todolist.Domain.TaskRepository;
import todolist.Infrastructure.Persistence.InMemoryTaskRepository;

import java.util.List;
import java.util.UUID;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class GetTasksTest {

  private static final String VALID_TASK_DESCRIPTION = "Just a task";

  @Test
  public void shouldReturnAnEmptyListOfTasks() {
    TaskRepository inMemoryTaskRepository = new InMemoryTaskRepository();
    List<Task> taskList = new GetTasks(inMemoryTaskRepository).execute();

    assertTrue(taskList.isEmpty());
  }

  @Test
  public void shouldReturnAListOfTasks() {
    TaskRepository inMemoryTaskRepository = new InMemoryTaskRepository();
    inMemoryTaskRepository.persist(new Task(
        UUID.randomUUID(),
        VALID_TASK_DESCRIPTION
    ));

    List<Task> taskList = new GetTasks(inMemoryTaskRepository).execute();

    assertTrue(!taskList.isEmpty());
    assertEquals(VALID_TASK_DESCRIPTION, taskList.get(0).getDescription());
  }
}

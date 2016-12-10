package todolist.Application.GetTasks;

import org.junit.Test;
import todolist.Domain.Task;
import todolist.Domain.TaskId;
import todolist.Domain.TaskRepository;
import todolist.Infrastructure.Persistence.InMemoryTaskRepository;

import java.util.List;
import java.util.UUID;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class GetTasksTest {

  private static final String VALID_TASK_DESCRIPTION = "Just a task";
  private static final TaskId VALID_ID = new TaskId();

  @Test
  public void shouldReturnAnEmptyListOfTasks() {
    TaskRepository inMemoryTaskRepository = new InMemoryTaskRepository();
    List<GetTasksResponse> getTasksResponseList = new GetTasks(inMemoryTaskRepository).execute();

    assertTrue(getTasksResponseList.isEmpty());
  }

  @Test
  public void shouldReturnAListOfTasks() {
    TaskRepository inMemoryTaskRepository = new InMemoryTaskRepository();
    inMemoryTaskRepository.persist(Task.create(
        VALID_ID,
        VALID_TASK_DESCRIPTION
    ));

    List<GetTasksResponse> getTasksResponseList = new GetTasks(inMemoryTaskRepository).execute();

    assertTrue(!getTasksResponseList.isEmpty());
    assertEquals(VALID_TASK_DESCRIPTION, getTasksResponseList.get(0).getDescription());
  }
}

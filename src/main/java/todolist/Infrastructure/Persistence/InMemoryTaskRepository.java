package todolist.Infrastructure.Persistence;

import todolist.Domain.Task;
import todolist.Domain.TaskRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryTaskRepository implements TaskRepository {
  private final ArrayList<Task> taskList;

  {
    this.taskList = new ArrayList<Task>();
  }

  @Override
  public void persist(Task task) {
    taskList.add(task);
  }

  @Override
  public List<Task> findAll() {
    return taskList;
  }
}

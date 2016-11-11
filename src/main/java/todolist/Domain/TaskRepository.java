package todolist.Domain;

import java.util.List;

public interface TaskRepository {
  void persist(Task task);

  List<Task> findAll();
}

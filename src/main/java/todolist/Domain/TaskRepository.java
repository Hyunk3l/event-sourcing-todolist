package todolist.Domain;

public interface TaskRepository {
  void persist(Task task);
}

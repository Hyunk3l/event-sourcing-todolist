package todolist.Infrastructure.Framework.Api.Controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import todolist.Application.CreateTask.CreateTask;
import todolist.Application.GetTasks.GetTasks;
import todolist.Domain.Task;
import todolist.Domain.TaskRepository;
import todolist.Infrastructure.Persistence.InMemoryTaskRepository;

import java.util.List;

@RestController
@RequestMapping(value = "/", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class TaskController {

  @RequestMapping(value = "/tasks", method = RequestMethod.POST)
  public ResponseEntity<Task> postTask(
    @RequestBody CreateTaskRequestBody createTaskRequestBody
  ) {
    TaskRepository taskRepository = new InMemoryTaskRepository();
    Task task = new CreateTask(taskRepository)
        .execute(createTaskRequestBody.getDescription());
    return ResponseEntity.ok(task);
  }

  @RequestMapping(value = "/tasks", method = RequestMethod.GET)
  public ResponseEntity<List<Task>> getTasks() {
    TaskRepository taskRepository = new InMemoryTaskRepository();
    GetTasks getTasksUseCase = new GetTasks(taskRepository);
    return ResponseEntity.ok(getTasksUseCase.execute());
  }
}

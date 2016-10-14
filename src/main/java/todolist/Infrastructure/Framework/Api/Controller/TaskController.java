package todolist.Infrastructure.Framework.Api.Controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import todolist.Application.CreateTask.CreateTask;
import todolist.Domain.Task;
import todolist.Domain.TaskRepository;
import todolist.Infrastructure.Persistence.InMemoryTaskRepository;

@RestController
public class TaskController {

  @RequestMapping(value = "/tasks", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<Task> postTask(
    @RequestBody CreateTaskRequestBody createTaskRequestBody
  ) {
    TaskRepository taskRepository = new InMemoryTaskRepository();
    Task task = new CreateTask(taskRepository)
        .execute(createTaskRequestBody.getDescription());
    return ResponseEntity.ok(task);
  }
}

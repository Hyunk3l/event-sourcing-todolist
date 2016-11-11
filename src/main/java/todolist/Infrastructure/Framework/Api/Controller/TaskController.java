package todolist.Infrastructure.Framework.Api.Controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import todolist.Application.CreateTask.CreateTask;
import todolist.Application.CreateTask.CreateTaskRequest;
import todolist.Application.CreateTask.CreateTaskResponse;
import todolist.Application.GetTasks.GetTasks;
import todolist.Domain.Task;
import todolist.Domain.TaskRepository;

import java.util.List;

@RestController
@RequestMapping(value = "/", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class TaskController {

  private final TaskRepository inMemoryRepository;

  public TaskController(TaskRepository inMemoryRepository) {
    this.inMemoryRepository = inMemoryRepository;
  }

  @RequestMapping(value = "/tasks", method = RequestMethod.POST)
  public ResponseEntity<CreateTaskResponse> postTask(
    @RequestBody CreateTaskRequestBody createTaskRequestBody
  ) {
    CreateTaskResponse createTaskResponse = new CreateTask(inMemoryRepository)
        .execute(
            new CreateTaskRequest(createTaskRequestBody.getDescription())
        );
    return ResponseEntity.ok(createTaskResponse);
  }

  @RequestMapping(value = "/tasks", method = RequestMethod.GET)
  public ResponseEntity<List<Task>> getTasks() {
    GetTasks getTasksUseCase = new GetTasks(inMemoryRepository);
    return ResponseEntity.ok(getTasksUseCase.execute());
  }
}

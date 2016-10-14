package todolist.Infrastructure.Framework.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import todolist.Infrastructure.Framework.Api.Controller.TaskController;

@Configuration
public class ControllerConfiguration {

  @Bean
  public TaskController taskController() {
    return new TaskController();
  }
}

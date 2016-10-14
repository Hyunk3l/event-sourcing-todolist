package todolist.Infrastructure.Framework.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import todolist.Domain.TaskRepository;
import todolist.Infrastructure.Persistence.InMemoryTaskRepository;

@Configuration
public class RepositoryConfiguration {

  @Bean
  public TaskRepository inMemoryTaskRepository() {
    return new InMemoryTaskRepository();
  }
}

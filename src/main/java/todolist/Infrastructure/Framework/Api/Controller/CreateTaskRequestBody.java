package todolist.Infrastructure.Framework.Api.Controller;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateTaskRequestBody {

  private final String description;

  public CreateTaskRequestBody(
      @JsonProperty("description") String description
  ) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }
}

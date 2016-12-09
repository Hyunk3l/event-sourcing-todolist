package todolist.Domain.Events;

public class UpdatedDescriptionEvent implements Event {
  private String newDescription;

  public UpdatedDescriptionEvent(String newDescription) {
    this.newDescription = newDescription;
  }

  public String getDescription() {
    return newDescription;
  }
}

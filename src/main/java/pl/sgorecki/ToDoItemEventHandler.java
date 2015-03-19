package pl.sgorecki;

import org.axonframework.eventhandling.annotation.EventHandler;
import pl.sgorecki.events.ToDoItemCompletedEvent;
import pl.sgorecki.events.ToDoItemCreatedEvent;

/**
 * @author Sebastian Górecki <gorecki.sebastian@gmail.com>
 */
public class ToDoItemEventHandler {
    @EventHandler
    public void handle(ToDoItemCreatedEvent event) {
        System.out.println("We've got something to do: " + event.getDescription() + " - " + event.getTodoId());
    }

    @EventHandler
    public void handle(ToDoItemCompletedEvent event) {
        System.out.println("We've completed the task: " + event.getTodoId());
    }
}

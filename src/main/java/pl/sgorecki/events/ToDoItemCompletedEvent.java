package pl.sgorecki.events;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;

/**
 * @author Sebastian Górecki <gorecki.sebastian@gmail.com>
 */
public class ToDoItemCompletedEvent {
    @TargetAggregateIdentifier
    private final String todoId;

    public ToDoItemCompletedEvent(String todoId) {
        this.todoId = todoId;
    }

    public String getTodoId() {
        return todoId;
    }
}

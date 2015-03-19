package pl.sgorecki.commands;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;

/**
 * @author Sebastian Górecki <gorecki.sebastian@gmail.com>
 */
public class MarkedCompletedCommand {
    @TargetAggregateIdentifier
    private final String todoId;

    public MarkedCompletedCommand(String todoId) {
        this.todoId = todoId;
    }

    public String getTodoId() {
        return todoId;
    }
}

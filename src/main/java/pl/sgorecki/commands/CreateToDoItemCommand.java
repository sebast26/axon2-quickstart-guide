package pl.sgorecki.commands;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;

/**
 * @author Sebastian Górecki <gorecki.sebastian@gmail.com>
 */
public class CreateToDoItemCommand {

    @TargetAggregateIdentifier
    private final String todoId;
    private final String description;

    public CreateToDoItemCommand(String todoId, String description) {
        this.todoId = todoId;
        this.description = description;
    }

    public String getTodoId() {
        return todoId;
    }

    public String getDescription() {
        return description;
    }
}

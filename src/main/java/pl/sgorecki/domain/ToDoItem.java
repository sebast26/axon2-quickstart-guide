package pl.sgorecki.domain;

import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.eventhandling.annotation.EventHandler;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;
import pl.sgorecki.commands.CreateToDoItemCommand;
import pl.sgorecki.commands.MarkedCompletedCommand;
import pl.sgorecki.events.ToDoItemCompletedEvent;
import pl.sgorecki.events.ToDoItemCreatedEvent;

/**
 * @author Sebastian Górecki <gorecki.sebastian@gmail.com>
 */
public class ToDoItem extends AbstractAnnotatedAggregateRoot {

    @AggregateIdentifier
    private String id;

    public ToDoItem() {
    }

    @CommandHandler
    public ToDoItem(CreateToDoItemCommand command) {
        apply(new ToDoItemCreatedEvent(command.getTodoId(), command.getDescription()));
    }

    @CommandHandler
    public void markCompleted(MarkedCompletedCommand command) {
        apply(new ToDoItemCompletedEvent(command.getTodoId()));
    }

    @EventHandler
    public void on(ToDoItemCreatedEvent event) {
        this.id = event.getTodoId();
    }
}

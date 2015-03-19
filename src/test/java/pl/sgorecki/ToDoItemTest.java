package pl.sgorecki;

import org.axonframework.test.FixtureConfiguration;
import org.axonframework.test.Fixtures;
import org.junit.Before;
import org.junit.Test;
import pl.sgorecki.commands.CreateToDoItemCommand;
import pl.sgorecki.commands.MarkedCompletedCommand;
import pl.sgorecki.domain.ToDoItem;
import pl.sgorecki.events.ToDoItemCompletedEvent;
import pl.sgorecki.events.ToDoItemCreatedEvent;

/**
 * @author Sebastian Górecki <gorecki.sebastian@gmail.com>
 */
public class ToDoItemTest {
    private FixtureConfiguration fixture;

    @Before
    public void setUp() throws Exception {
        fixture = Fixtures.newGivenWhenThenFixture(ToDoItem.class);
    }

    @Test
    public void testCreateToDoItem() throws Exception {
        fixture.given()
                .when(new CreateToDoItemCommand("todo1", "need to implement the aggregate"))
                .expectEvents(new ToDoItemCreatedEvent("todo1", "need to implement the aggregate"));
    }

    @Test
    public void testMarkToDoItemAsCompleted() throws Exception {
        fixture.given(new ToDoItemCreatedEvent("todo1", "need to implement the aggregate"))
                .when(new MarkedCompletedCommand("todo1"))
                .expectEvents(new ToDoItemCompletedEvent("todo1"));
    }
}

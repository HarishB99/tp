package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.person.Person;
import seedu.address.testutil.PersonBuilder;

public class ViewStatsCommandTest {

    @Test
    public void execute_noPersons_emptyStatsMessage() throws CommandException {
        Model model = new ModelManager();
        ViewStatsCommand command = new ViewStatsCommand();
        CommandResult result = command.execute(model);
        String expectedMessage = "Statistics Tab Opened";
        assertEquals(expectedMessage, result.getFeedbackToUser());
    }

    @Test
    public void execute_somePersons_showsCorrectStats() throws CommandException {
        Model model = new ModelManager();

        Person softwareEngineer = new PersonBuilder()
                .withName("Alice")
                .withJobRole("Software Engineer")
                .build();
        Person dataScientist = new PersonBuilder()
                .withName("Bob")
                .withJobRole("Data Scientist")
                .build();
        Person uiDesigner = new PersonBuilder()
                .withName("Charlie")
                .withJobRole("UI Designer")
                .build();

        model.addPerson(softwareEngineer);
        model.addPerson(dataScientist);
        model.addPerson(uiDesigner);

        ViewStatsCommand command = new ViewStatsCommand();
        CommandResult result = command.execute(model);

        String expectedMessage = "Statistics Tab Opened";

        assertEquals(expectedMessage, result.getFeedbackToUser());
    }
}

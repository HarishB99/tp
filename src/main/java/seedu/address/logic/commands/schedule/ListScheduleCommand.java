package seedu.address.logic.commands.schedule;

import static java.util.Objects.requireNonNull;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;

/**
 * Lists all schedules in the schedule board.
 */
public class ListScheduleCommand extends Command {

    public static final String COMMAND_WORD = "slist";

    public static final String MESSAGE_SUCCESS = "Listed all schedules. ";
    public static final String EMPTY_MESSAGE_SUCCESS = "There are no interview schedules at the moment. ";

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        if (model.getFilteredScheduleList().size() == 0) {
            return new CommandResult(EMPTY_MESSAGE_SUCCESS);
        }
        model.updateFilteredScheduleList(Model.PREDICATE_SHOW_ALL_SCHEDULES);
        return new CommandResult(MESSAGE_SUCCESS);
    }
}

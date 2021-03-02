package seedu.dictionote.logic.parser;

import seedu.dictionote.commons.core.index.Index;
import seedu.dictionote.commons.exceptions.IllegalValueException;
import seedu.dictionote.logic.commands.RemarkCommand;
import seedu.dictionote.logic.parser.exceptions.ParseException;
import seedu.dictionote.model.person.Remark;

import static java.util.Objects.requireNonNull;
import static seedu.dictionote.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.dictionote.logic.parser.CliSyntax.PREFIX_REMARK;

public class RemarkCommandParser {
    public RemarkCommand parse(String args) throws ParseException {
        requireNonNull(args);
        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(args,
                PREFIX_REMARK);

        Index index;
        try {
            index = ParserUtil.parseIndex(argMultimap.getPreamble());
        } catch (IllegalValueException ive) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    RemarkCommand.MESSAGE_USAGE), ive);
        }

        Remark remark = new Remark(argMultimap.getValue(PREFIX_REMARK).orElse(""));

        return new RemarkCommand(index, remark);
    }
}

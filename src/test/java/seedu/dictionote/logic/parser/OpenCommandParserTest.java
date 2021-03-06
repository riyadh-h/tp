package seedu.dictionote.logic.parser;

import static seedu.dictionote.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.dictionote.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.dictionote.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.dictionote.testutil.TypicalUiActions.EXPECTED_UI_OPTION;
import static seedu.dictionote.testutil.TypicalUiActions.VALID_UI_OPTIONS;

import org.junit.jupiter.api.Test;

import seedu.dictionote.logic.commands.OpenCommand;

/**
 * As we are only doing white-box testing, our test cases do not cover path variations
 * outside of the OpenCommand code. For example, inputs "1" and "1 abc" take the
 * same path through the DeleteCommand, and therefore we test only one of them.
 * The path variation for those two cases occur inside the ParserUtil, and
 * therefore should be covered by the ParserUtilTest.
 */
public class OpenCommandParserTest {

    private OpenCommandParser parser = new OpenCommandParser();

    @Test
    public void parse_validArgs_returnsOpenCommand() {

        for (int i = 0; i < VALID_UI_OPTIONS.length; i++) {
            assertParseSuccess(parser, VALID_UI_OPTIONS[i], new OpenCommand(EXPECTED_UI_OPTION[i]));
        }

    }

    @Test
    public void parse_invalidArgs_throwsParseException() {
        assertParseFailure(parser, "a123", String.format(MESSAGE_INVALID_COMMAND_FORMAT, OpenCommand.MESSAGE_USAGE));
    }
}

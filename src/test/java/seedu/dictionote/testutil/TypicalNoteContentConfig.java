package seedu.dictionote.testutil;

import seedu.dictionote.model.note.Note;
import seedu.dictionote.ui.NoteContentConfig;

/**
 * A utility class containing a arrau of {@code UiActionOption} objects to be used in tests.
 */
public class TypicalNoteContentConfig {


    public static NoteContentConfig getTypicalNoteContentConfigWitouthNote() {
        return new NoteContentConfigStubWithoutNote();
    }

    public static NoteContentConfig getTypicalNoteContentConfigWithNote() {
        return new NoteContentConfigStubWithNote();
    }

    public static NoteContentConfig getTypicalNoteContentConfigEditMode() {
        return new NoteContentConfigStubEditMode();
    }

    public static NoteContentConfig getTypicalNoteContentConfigEditModeNoteSame() {
        return new NoteContentConfigStubEditModeNoteSame();
    }

    public static NoteContentConfig getNoteContentConfigStubEditModeNoteEditedDuplicate() {
        return new NoteContentConfigStubEditModeNoteEditedDuplicate();
    }
    /**
     * A stub for note content config for failure test
     */
    private static class NoteContentConfigStubWithoutNote implements NoteContentConfig {
        protected Note note;
        @Override
        public void setNote(Note note) {
            this.note = note;
        }

        @Override
        public boolean haveNote() {
            return false;
        }

        @Override
        public void resetNote() {

        }

        @Override
        public String getEditedContent() {
            return null;
        }

        @Override
        public Note getNote() {
            return note;
        }

        @Override
        public boolean onEditMode() {
            return false;
        }
    }

    /**
     * A stub for note content config for success test
     */
    private static class NoteContentConfigStubWithNote extends NoteContentConfigStubWithoutNote {

        @Override
        public boolean haveNote() {
            return true;
        }
    }

    /**
     * A stub for note content config for success test
     */
    private static class NoteContentConfigStubEditMode extends NoteContentConfigStubWithNote {

        @Override
        public String getEditedContent() {
            return "edited";
        }

        @Override
        public boolean onEditMode() {
            return true;
        }
    }

    /**
     * A stub for note content config for note not change
     */
    private static class NoteContentConfigStubEditModeNoteSame extends NoteContentConfigStubEditMode {
        @Override
        public String getEditedContent() {
            return note.getNote();
        }
    }

    /**
     * A stub for note content config for duplicate test
     */
    private static class NoteContentConfigStubEditModeNoteEditedDuplicate
        extends NoteContentConfigStubEditModeNoteSame {

        @Override
        public Note getNote() {
            return new Note("");
        }

    }
}

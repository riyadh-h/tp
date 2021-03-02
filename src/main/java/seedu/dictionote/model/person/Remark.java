package seedu.dictionote.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.dictionote.commons.util.AppUtil.checkArgument;

/**
 * Represents a Person's remark in the dictionote book.
 * Guarantees: immutable; is always valid.
 */
public class Remark {
    public final String value;

    /**
     * Constructs an {@code Remark}.
     *
     * @param remark A valid remark.
     */
    public Remark(String remark) {
        requireNonNull(remark);
        value = remark;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Remark // instanceof handles nulls
                && value.equals(((Remark) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
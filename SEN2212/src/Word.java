import java.text.MessageFormat;

/**
 * Word is a custom object for holding a sub-string value and its start and end indices in a string.
 */
public class Word implements Comparable<Word> {

    private String value;
    private long startIndex;

    public String getValue() {
        return value;
    }

    public long getStartIndex() {
        return startIndex;
    }

    public Word(String value, long startIndex) {
        this.value = value;
        this.startIndex = startIndex;
    }

    @Override
    public String toString() {
        return MessageFormat.format("{0} [{1}:{2}]", value, String.valueOf(startIndex), value.length());
    }

    @Override
    public int compareTo(Word w) {
        return value.compareTo(w.getValue());
    }

}

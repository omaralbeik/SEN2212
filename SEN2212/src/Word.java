/**
 * Word is a custom object for holding a sub-string value and its start and end indices in a string.
 */
public class Word implements Comparable<Word> {

    private String value;
    private int startIndex;
    private int endIndex;

    public String getValue() {
        return value;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }

    public Word(String value, int startIndex, int endIndex) {
        this.value = value;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    public String toString() {
        return value + " " + "[" + startIndex + ":" + endIndex + "]";
    }

    @Override
    public int compareTo(Word w) {
        return value.compareTo(w.getValue());
    }

}

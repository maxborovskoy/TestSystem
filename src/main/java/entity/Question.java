package entity;

import java.io.Serializable;
import java.text.Collator;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class Question implements Comparable, Serializable {
    private long id;
    private String text;
    private List<Answer> answers;
    private long testId;

    public long getTestId() {
        return testId;
    }

    public void setTestId(long testId) {
        this.testId = testId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        Collections.copy(this.answers, answers);
    }

    @Override
    public String toString() {
        return "Question{" +
                "text='" + text + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Collator c = Collator.getInstance(new Locale("ru"));
        c.setStrength(Collator.PRIMARY);
        return c.compare(this.toString(), o.toString());
    }
}

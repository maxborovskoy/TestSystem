package entity;

import java.io.Serializable;
import java.text.Collator;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

public class Test implements Serializable {
    private long id;
    private String name;
    private List<Question> quest;
    private TestTypes type;
    private String description;
    private LocalDate creationDate;

    public Test(String name, List<Question> quest, TestTypes type) {
        this.name = name;
        this.quest = quest;
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Question> getQuest() {
        return quest;
    }

    public void setQuest(List<Question> quest) {
        this.quest = quest;
    }

    public TestTypes getType() {
        return type;
    }

    public void setType(TestTypes type) {
        this.type = type;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    @Override
    public String toString() {
        return "Test{" +
                "name='" + name + '\'' +
                ", quest=" + quest +
                ", type=" + type +
                '}';
    }
}

package entity;

import java.io.Serializable;
import java.text.Collator;
import java.util.List;
import java.util.Locale;

public class Test implements Comparable, Serializable {
    private long id;
    private String name;
    private List<Question> quest;
    private TestTypes type;

    public Test(long id, String name, List<Question> quest, TestTypes type) {
        this.id = id;
        this.name = name;
        this.quest = quest;
        this.type = type;
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

    @Override
    public String toString() {
        return "Test{" +
                "name='" + name + '\'' +
                ", quest=" + quest +
                ", type=" + type +
                '}';
    }


    @Override
    public int compareTo(Object o) {
        Collator c = Collator.getInstance(new Locale("ru"));
        c.setStrength(Collator.PRIMARY);
        return c.compare(this.toString(), o.toString());
    }
}

package entity;

public enum TestTypes {
    MATH("Math"),
    PHYSICS("Physics"),
    ENGLISH("English");

    private String name;

    TestTypes(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static TestTypes getType(String name) {
        switch (name) {
            case "Math": return TestTypes.MATH;
            case "Physics": return TestTypes.PHYSICS;
            case "English": return TestTypes.ENGLISH;
        }
        return null;
    }
}

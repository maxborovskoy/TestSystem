package entity;

public enum TestTypes {
    MATH( "Math" ),
    PHYSICS( "Physics" ),
    ENGLISH( "English" );

    private String name;

    TestTypes (String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
}

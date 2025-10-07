abstract class Person {
    private String name;
    private int age;
    private static int count=0;

    public Person() {
        this.name="No";
        this.age=0;
        count++;
    } 

    public Person(String name, int age) {
        this.name=name;
        this.age=age;
        count++;
    }

    public abstract void work();
    public abstract void status();

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public void setName(String name) {
        this.name=name;
    }
    public void setAge(int age) {this.age=age;}
    public static int getCount() {return count;}

    }
    
    
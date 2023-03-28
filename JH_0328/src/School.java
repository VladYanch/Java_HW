public class School {
    @StudentInfo(name = "Tom", surname = "Smith", age = 15)
    private Student student1;

    @StudentInfo(name = "Mary", surname = "Jennings", age = 17)
    private Student student2;

    @Override
    public String toString() {
        return "student1=" + student1 + ", student2=" + student2;
    }

    public void print () {
        System.out.println("student1=" + student1.name + " " + student1.surname + " " + student1.age +
                ", student2=" + student2.name + " " + student2.surname + " " + student2.age);
    }
}

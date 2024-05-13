public class Teacher {
    static Integer Globalid=1;
    int id;
    String name;
    double salary;
    Teacher(String name,double salary){

        this.name=name;
        this.salary=salary;
        this.id=Globalid;
        Globalid+=1;
    }

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public double getSalary() {
        return this.salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

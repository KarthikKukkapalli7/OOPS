import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SchoolMoneyManagement {
    HashMap<Integer, HashMap<Integer, Student>> StudentData= new HashMap<Integer, HashMap<Integer, Student>>();
    HashMap<Integer,Teacher> TeacherData= new HashMap<Integer,Teacher>();
    private String userName = "admin";
    private String password = "admin";
    public boolean login(){
        System.out.println("please enter username and password to login");
        Scanner sc = new Scanner(System.in);
        String UserName=sc.nextLine();
        String password=sc.nextLine();

        return this.userName.compareTo(UserName) == 0 && this.password.compareTo(password) == 0;
    }
    public boolean changePwd(String changeUserName,String changePassword){
        if(login()){
            this.userName=changeUserName;
            this.password=changePassword;
            return true;
        }
        return false;

    }
    public static <teacher> void main(String[] args) {
        System.out.println("Welcome School Management System");
        SchoolMoneyManagement Manage= new SchoolMoneyManagement();
        boolean Login= Manage.login();
        if(Login) {
            while (true) {
                System.out.println("you have log in to system");
                System.out.println("Please enter 1 to add student to school");
                System.out.println("Please enter 2 to add Teacher");
                System.out.println("Please enter 3 to grade wise fee details");
                System.out.println("Please enter 4 to to pay student fee");
                Scanner sc = new Scanner(System.in);
                int val = sc.nextInt();
                if (val == 1) {
                    System.out.println("Please enter grade");
                    int grade = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Please enter name");
                    String name = sc.nextLine();
                    System.out.println("Please enter fee want to pay");
                    int fee_paid = sc.nextInt();
                    int value = grade * 10000 + 10000;
                    String s = String.valueOf(value);
                    System.out.println("fee for grade is" + s);
                    Student student = new Student(name, grade, value, fee_paid);
                    HashMap<Integer, HashMap<Integer, Student>> studentDetails = Manage.StudentData;
                    if (studentDetails.containsKey(grade)) {
                        studentDetails.get(grade).put(student.getId(), student);
                    } else {
                        studentDetails.put(grade, new HashMap<Integer, Student>());
                        studentDetails.get(grade).put(student.getId(), student);
                    }
                } else if (val == 2) {
                    sc.nextLine();
                    System.out.println("Please enter Teacher name");
                    String name = sc.nextLine();
                    System.out.println("Please enter salary want to give");
                    int salary = sc.nextInt();
                    Teacher teacher = new Teacher(name, salary);
                    HashMap<Integer, Teacher> teacherDetails = Manage.TeacherData;
                    teacherDetails.put(teacher.getId(), teacher);
                } else if (val == 3) {
                    for (Map.Entry<Integer, HashMap<Integer, Student>> entry : Manage.StudentData.entrySet()) {
                        System.out.println("For grade " + entry.getKey());
                        for (Map.Entry<Integer, Student> value : entry.getValue().entrySet()) {
                            System.out.println("student id " + value.getValue().getId() + " student name " + value.getValue().getName() + " student amount to be paid " + (value.getValue().fee_total - value.getValue().fee_paid));
                        }


                    }
                } else {
                    System.out.println("Please enter grade");
                    int grade = sc.nextInt();
                    System.out.println("Please enter student id");
                    int id = sc.nextInt();
                    System.out.println("Amount to be paid "+(Manage.StudentData.get(grade).get(id).getFee_total()-Manage.StudentData.get(grade).get(id).getFee_paid()));
                    System.out.println("Please enter amount has payed");
                    int paid = sc.nextInt();
                    Manage.StudentData.get(grade).get(id).setFee_paid(Manage.StudentData.get(grade).get(id).getFee_paid()+paid);
                }
            }
            }else{
                System.out.println("log in failed ,Please check password entered");
            }

        }
    }


public class Student  {
    static Integer Global_id =1;
    int id ;
    String name;
    Integer Grade;
    double fee_total;
    double fee_paid;
    Student( String name, Integer Grade,double fee_total,double fee_paid){
        this.name=name;
        this.Grade=Grade;
        this.fee_total=fee_total;
        this.fee_paid=fee_paid;
        this.id= Global_id;
        Global_id +=1;
    }
    public Integer getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public Integer getGrade(){
        return  this.Grade;
    }
    public double getFee_total(){
        return fee_total;
    }
    public double getFee_paid(){
        return fee_paid;
    }

    public void setName(String name){
         this.name=name;
    }
    public  void setGrade(Integer grade){
        this.Grade=grade;
    }
    public void setFee_total(double fee_total){
        this.fee_total=fee_total;
    }
    public void setFee_paid(double fee_paid){
        this.fee_paid=fee_paid;
    }


}

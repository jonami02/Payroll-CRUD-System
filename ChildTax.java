import javax.swing.JOptionPane;
public class ChildTax extends ParentRecorder{
    private double SSS,philHealth,withholding;
    public void AddRecord(String name,String rate, String hrsworked,int empstatus){
        SSS = SSS_Tax(Salary);
        philHealth = pHealth(Salary,empstatus);
        withholding = WithholdingTax(Salary);
        double tax = SSS+philHealth+withholding;
        Salary -= tax;
        record.put(Name, Salary);
    }
    public double SSS_Tax(double Salary){
        double tax;
        if (Salary >= 7500 && Salary <= 9749.99) {
            tax = 750;
        }
        else if (Salary >=9750 && Salary <= 10249.99) {
            tax = 850;
        }
        else if (Salary >= 10250 && Salary <= 11749.99) {
            tax = 900;
        }
        else if (Salary >= 11750 && Salary <= 12249.99) {
            tax = 950;
        }
        else if (Salary >= 12250 && Salary <= 13749.99) {
            tax = 1000;
        }
        else if (Salary >= 13750 && Salary <= 14249.99) {
            tax = 1100;
        }
        else{
            tax = 1700;
        }
        return tax;
    }
    public double pHealth(double Salary, int empstatus){
        double tax,taxrate;
        if (empstatus == 0){
            taxrate = .02;
        }else taxrate = .01;
        tax = Salary * taxrate;
        return tax;
    }
    public double WithholdingTax(double salary){
        double tax;
        if (Salary < 20833.00) {
            tax = 0;
        }
        else if (Salary >=20833 && Salary < 33333 ) {
            tax = (Salary-20833)*.2;
        }
        else if (Salary >= 33333 && Salary < 66667) {
            tax = (Salary-33333)*.25+2500;
        }
        else if (Salary >= 66667 && Salary <166667) {
            tax = (Salary-66667)*.30+10833.33;
        }
        else if (Salary >= 166667 && Salary < 666667) {
            tax = (Salary-166667)*.32+40833.33;
        }
        else{
            tax = (Salary-666667)*.35+200833.33;
            
        }
        return tax;
    }
    @Override
    public void display(){
        JOptionPane.showMessageDialog(displayer, "Name: "+Name+"\nHourly Rate: "+Rate+"\nHours Worked: "+HrsWorked);
        JOptionPane.showMessageDialog(displayer,"SSS Tax: "+SSS+"\nPhilHealth Tax: "+philHealth+"\nWithholding Tax: "+withholding+"\nNet Salary: "+Salary);
    }
}

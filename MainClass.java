import javax.swing.*;
public class MainClass { 
    public static void main(String[] args) {
        JFrame input = new JFrame();
        int choice;
        String name,rate,hrsworked;
        do{
            String menu = JOptionPane.showInputDialog(input,"[A] Add a Record\n[B] Edit a Record\n[C] Delete a Record\n[D] Show Records").toLowerCase();
            switch (menu) {
                case "a":
                    ParentRecorder.showRecords();
                    name = JOptionPane.showInputDialog(input, "Enter Name");
                    rate = JOptionPane.showInputDialog(input,"Enter Hourly Rate\n(Tax will be Collected when salary reaches 7500.00)");
                    while (InputValidation(rate) != true){
                        JOptionPane.showMessageDialog(input,rate+" Not Valid");
                        rate = JOptionPane.showInputDialog(input,"Enter Hourly Rate\n(Tax will be Collected when salary reaches 7500.00)");
                    }
                    hrsworked = JOptionPane.showInputDialog(input,"Enter Hours Worked\n(Tax will be Collected when salary reaches 7500.00)");
                    while(InputValidation(hrsworked)!=true){
                        JOptionPane.showMessageDialog(input, hrsworked+" Not Valid");
                        hrsworked = JOptionPane.showInputDialog(input,"Enter Hours Worked\n(Tax will be Collected when salary reaches 7500.00)");
                    }
                    ParentRecorder obj = new ParentRecorder();
                    obj.AddRecord(name,rate,hrsworked);
                    if (obj.salarycheck()<7500){
                        obj.display();
                    }
                    else{
                        ChildTax objwithtax = new ChildTax();
                        int empstatus = JOptionPane.showConfirmDialog(input,"Are you an Employer? ");
                        objwithtax.AddRecord(name, rate, hrsworked,empstatus);
                        objwithtax.display();                
                    }
                    break;
                case "b":
                    ParentRecorder edit = new ParentRecorder();
                    name = JOptionPane.showInputDialog(input,"Record: "+ParentRecorder.record+"\nEnter Name of which you wish to edit the record");
                    if(edit.findkey(name)!=true){
                        JOptionPane.showMessageDialog(input,name+" Not Found in the record");
                        break;
                    }
                    rate = JOptionPane.showInputDialog(input,"Enter Hourly Rate\n(Tax will be Collected when salary reaches 7500.00)");
                    while (InputValidation(rate) != true){
                        JOptionPane.showMessageDialog(input,rate+" Not Valid");
                        rate = JOptionPane.showInputDialog(input,"Enter Hourly Rate\n(Tax will be Collected when salary reaches 7500.00)");
                    }
                    hrsworked = JOptionPane.showInputDialog(input,"Enter Hours Worked\n(Tax will be Collected when salary reaches 7500.00)");
                    while(InputValidation(hrsworked)!=true){
                        JOptionPane.showMessageDialog(input, hrsworked+" Not Valid");
                        hrsworked = JOptionPane.showInputDialog(input,"Enter Hours Worked\n(Tax will be Collected when salary reaches 7500.00)");
                    }
                    edit.AddRecord(name, rate, hrsworked);
                    if (edit.salarycheck()<7500){
                        edit.display();
                    }
                    else{
                        ChildTax objwithtax = new ChildTax();
                        int empstatus = JOptionPane.showConfirmDialog(input,"Are you an Employer? ");
                        objwithtax.AddRecord(name, rate, hrsworked,empstatus);
                        objwithtax.display();                
                    }
                    break;
                case "c":
                    ParentRecorder.showRecords();
                    ParentRecorder removekey = new ParentRecorder();
                    name = JOptionPane.showInputDialog(input,"Record: "+ParentRecorder.record+"\nEnter Name to delete record");
                    if(removekey.findkey(name)==true){
                            if(JOptionPane.showConfirmDialog(input,"Are you sure you want to delete the record of "+name+"?")==0){
                                removekey.keyremoval(name);}
                    }else JOptionPane.showMessageDialog(input, name+" is not in the record");
                    break;
                case "d":
                    ParentRecorder.showRecords();
                    break;
                default:
                    JOptionPane.showMessageDialog(input,"Invalid Input");
            }            
            
            choice = JOptionPane.showConfirmDialog(input, "Do you want to try again?");
        } while (choice == 0);  
        JOptionPane.showMessageDialog(input, "Now Cleaning memory");
        ParentRecorder.wipe();
    }
    public static boolean InputValidation(String val){
        try {
            Double.parseDouble(val);
            return true;
        } catch (NumberFormatException err) {
            return false;
        }
    }

}
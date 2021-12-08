import java.util.*;
import javax.swing.*;
class ParentRecorder {
    protected static double Rate, HrsWorked,Salary;
    protected static String Name;
    protected static HashMap<String,Double> record = new HashMap();
    JFrame displayer = new JFrame();
    public void AddRecord(String name,String rate, String hrsworked){
        Rate = Double.parseDouble(rate);
        HrsWorked = Double.parseDouble(hrsworked);
        Salary = Rate*HrsWorked;
        Name = name;
        record.put(Name,Salary);
    }
    public boolean findkey(String nameval){
        return record.containsKey(nameval);
    }
    public void keyremoval(String name){
        record.remove(name);
    }
    public double salarycheck(){
        return Salary;
    }
    public void display(){
        JOptionPane.showMessageDialog(displayer, "Name: "+Name+"\nHourly Rate: "+Rate+"\nHours Worked: "+HrsWorked);
        JOptionPane.showMessageDialog(displayer,Name + "'s Salary: " +record.get(Name));
    }
    public static void wipe(){
        record.clear();
    }
    public static void showRecords(){
        JOptionPane.showMessageDialog(new JFrame(),"Record: "+ record);
    }
}

import models.Student;
import service.StudentService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ManageStudents {
    private StudentService service = new StudentService();
    private JTable table;
    ManageStudents() {
        JFrame frame = new JFrame("Manage Students");
        addStudentsToTable();
        JScrollPane sp=new JScrollPane(table);
        frame.add(sp);
        frame.setSize(1000, 500);
        frame.setVisible(true);
    }

    private void addStudentsToTable(){
        table = new JTable();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.addColumn("Id");
        model.addColumn("First Name");
        model.addColumn("Last Name");
        List<Student> list = service.getAllStudents();
        Object[] rowData = new Object[3];
        for (Student student : list) {
            rowData[0] = student.getId();
            rowData[1] = student.getFirstName();
            rowData[2] = student.getLastName();
            model.addRow(rowData);
        }
    }
}

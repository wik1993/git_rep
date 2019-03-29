import models.Student;
import service.StudentService;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class ManageStudents {
    private StudentService service = new StudentService();
    private JTable table;
    private JTextField t1, t2, t3;

    ManageStudents() {
        JFrame frame = new JFrame("Manage Students");
        addStudentsToTable();
        tableMouseClicked();
        JScrollPane sp = new JScrollPane();
        sp.setPreferredSize(new Dimension(500, 600));
        sp.setLocation(300, 200);
        sp.getViewport().add(table);

        JPanel panel = new JPanel();
        panel.add(sp);


        JLabel l1 = new JLabel("ID");
        JLabel l2 = new JLabel("First Name");
        JLabel l3 = new JLabel("Last Name");
        l1.setBounds(20, 50, 100, 30);
        l2.setBounds(20, 100, 100, 30);
        l3.setBounds(20, 150, 100, 30);


        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t1.setBounds(90, 50, 200, 30);
        t2.setBounds(90, 100, 200, 30);
        t3.setBounds(90, 150, 200, 30);

        JButton delete = new JButton("Delete");
        JButton add = new JButton("Add");
        JButton update = new JButton("Update");
        delete.setBounds(10, 200, 95, 30);
        add.setBounds(120, 200, 95, 30);
        update.setBounds(230, 200, 95, 30);

        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = t1.getText();
                Student student = service.getStudentById(Integer.valueOf(id));
                service.deleteStudent(student);
            }
        });
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = t1.getText();
                String fName = t2.getText();
                String lName = t3.getText();
                Student student = new Student();
                student.setId(Integer.parseInt(id));
                student.setFirstName(fName);
                student.setLastName(lName);
                service.addStudent(student);
            }
        });
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = t1.getText();
                String fName = t2.getText();
                String lName = t3.getText();
                Student student = service.getStudentById(Integer.valueOf(id));
                student.setFirstName(fName);
                student.setLastName(lName);
                service.updateStudent(student);
            }
        });

        frame.add(delete);
        frame.add(add);
        frame.add(update);
        frame.add(t1);
        frame.add(t2);
        frame.add(t3);
        frame.add(l1);
        frame.add(l2);
        frame.add(l3);
        frame.add(panel);
        frame.setSize(1200, 800);
        frame.setLocation(150, 150);
        frame.setVisible(true);
    }

    private void addStudentsToTable() {
        table = new JTable();
        //table.setEnabled(false);
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

    private void tableMouseClicked() {
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                int rowIndex = table.getSelectedRow();
                t1.setText(table.getValueAt(rowIndex, 0).toString());
                t2.setText(table.getValueAt(rowIndex, 1).toString());
                t3.setText(table.getValueAt(rowIndex, 2).toString());
            }
        });
    }
}

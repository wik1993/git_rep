package controller;

import model.Student;
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
    private JTable table = new JTable();
    private DefaultTableModel model = (DefaultTableModel) table.getModel();
    private JTextField id, firstName, lastName;

    public ManageStudents() {
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


        id = new JTextField();
        firstName = new JTextField();
        lastName = new JTextField();
        id.setBounds(90, 50, 200, 30);
        firstName.setBounds(90, 100, 200, 30);
        lastName.setBounds(90, 150, 200, 30);

        JButton delete = new JButton("Delete");
        JButton add = new JButton("Add");
        JButton update = new JButton("Update");
        delete.setBounds(10, 200, 95, 30);
        add.setBounds(120, 200, 95, 30);
        update.setBounds(230, 200, 95, 30);

         delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer id1 = Integer.valueOf(id.getText());
                service.deleteStudent(id1);
            }
        });

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fName = firstName.getText();
                String lName = lastName.getText();
                Student student = new Student();
                student.setFirstName(fName);
                student.setLastName(lName);
                service.addStudent(student);
                table.repaint();
                table.revalidate();
            }
        });

        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer id1 = Integer.valueOf(id.getText());
                String fName = firstName.getText();
                String lName = lastName.getText();
                Student student = service.getStudent(id1);
                student.setFirstName(fName);
                student.setLastName(lName);
                service.updateStudent(student,id1);
            }
        });

        frame.add(delete);
        frame.add(add);
        frame.add(update);
        frame.add(id);
        frame.add(firstName);
        frame.add(lastName);
        frame.add(l1);
        frame.add(l2);
        frame.add(l3);
        frame.add(panel);
        frame.setSize(1200, 650);
        frame.setLocation(100, 50);
        frame.setVisible(true);
    }

    private void addStudentsToTable() {
        model.addColumn("Id");
        model.addColumn("First Name");
        model.addColumn("Last Name");
       /* Student student = service.getStudent(2);
        Object[] rowData = new Object[3];
        rowData[0] = student.getId();
        rowData[1] = student.getFirstName();
        rowData[2] = student.getLastName();
        model.addRow(rowData);*/
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
                id.setText(table.getValueAt(rowIndex, 0).toString());
                firstName.setText(table.getValueAt(rowIndex, 1).toString());
                lastName.setText(table.getValueAt(rowIndex, 2).toString());

            }

        });
    }
}

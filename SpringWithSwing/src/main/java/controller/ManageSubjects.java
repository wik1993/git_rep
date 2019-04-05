package controller;

import model.Subject;
import service.SubjectService;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ManageSubjects {

    private SubjectService service = new SubjectService();
    private JTable table = new JTable();
    private DefaultTableModel model = (DefaultTableModel) table.getModel();
    private JTextField id, subjectName, numberOfHours;

    public ManageSubjects() {
        JFrame frame = new JFrame("Manage Subjects");
        addSubjectsToTable();
        tableMouseClicked();
        JScrollPane sp = new JScrollPane();
        sp.setPreferredSize(new Dimension(500, 600));
        sp.setLocation(300, 200);
        sp.getViewport().add(table);

        JPanel panel = new JPanel();
        panel.add(sp);

        JLabel l1 = new JLabel("ID");
        JLabel l2 = new JLabel("Subject name");
        JLabel l3 = new JLabel("Number Of Hours");
        l1.setBounds(20, 50, 100, 30);
        l2.setBounds(20, 100, 100, 30);
        l3.setBounds(20, 150, 100, 30);


        id = new JTextField();
        subjectName = new JTextField();
        numberOfHours = new JTextField();
        id.setBounds(120, 50, 200, 30);
        subjectName.setBounds(120, 100, 200, 30);
        numberOfHours.setBounds(120, 150, 200, 30);

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
                service.deleteSubject(id1);
            }
        });

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String subjectNameText = subjectName.getText();
                String numberOfHoursText = numberOfHours.getText();
                Subject subject = new Subject();
                subject.setName(subjectNameText);
                subject.setNumberHour(Integer.parseInt(numberOfHoursText));
                service.addSubject(subject);
                table.repaint();
                table.revalidate();
            }
        });

        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer id1 = Integer.valueOf(id.getText());
                String subjectNameText = subjectName.getText();
                String numberOfHoursText = numberOfHours.getText();
                Subject subject = service.getSubject(id1);
                subject.setName(subjectNameText);
                subject.setNumberHour(Integer.parseInt(numberOfHoursText));
                service.updateSubject(subject, id1);
            }
        });

        frame.add(delete);
        frame.add(add);
        frame.add(update);
        frame.add(id);
        frame.add(subjectName);
        frame.add(numberOfHours);
        frame.add(l1);
        frame.add(l2);
        frame.add(l3);
        frame.add(panel);
        frame.setSize(1200, 650);
        frame.setLocation(100, 50);
        frame.setVisible(true);
    }

    private void addSubjectsToTable() {
        model.addColumn("Id");
        model.addColumn("Subject Name");
        model.addColumn("Number of Hours");
        List<Subject> list = service.getAllSubjects();
        Object[] rowData = new Object[3];
        for (Subject subject : list) {
            rowData[0] = subject.getId();
            rowData[1] = subject.getName();
            rowData[2] = subject.getNumberHour();
            model.addRow(rowData);
        }

    }

    private void tableMouseClicked() {
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                int rowIndex = table.getSelectedRow();
                id.setText(table.getValueAt(rowIndex, 0).toString());
                subjectName.setText(table.getValueAt(rowIndex, 1).toString());
                numberOfHours.setText(table.getValueAt(rowIndex, 2).toString());

            }

        });
    }
}

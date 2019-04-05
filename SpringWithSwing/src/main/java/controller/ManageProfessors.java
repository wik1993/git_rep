package controller;

import model.Professor;
import service.ProfessorService;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class ManageProfessors {

    private ProfessorService service = new ProfessorService();
    private JTable table = new JTable();
    private DefaultTableModel model = (DefaultTableModel) table.getModel();
    private JTextField id, firstName, lastName;

    public ManageProfessors() {
        JFrame frame = new JFrame("Manage Professors");
        addProfessorsToTable();
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
                service.deleteProfessor(id1);
            }
        });

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fName = firstName.getText();
                String lName = lastName.getText();
                Professor professor = new Professor();
                professor.setFirstName(fName);
                professor.setLastName(lName);
                service.addProfessor(professor);
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
                Professor professor = service.getProfessor(id1);
                professor.setFirstName(fName);
                professor.setLastName(lName);
                service.updateProfessor(professor, id1);
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

    private void addProfessorsToTable() {
        model.addColumn("Id");
        model.addColumn("First Name");
        model.addColumn("Last Name");
        List<Professor> list = service.getAllProfessors();
        Object[] rowData = new Object[3];
        for (Professor professor : list) {
            rowData[0] = professor.getId();
            rowData[1] = professor.getFirstName();
            rowData[2] = professor.getLastName();
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

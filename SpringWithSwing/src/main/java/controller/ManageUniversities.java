package controller;

import model.University;
import service.UniversityService;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ManageUniversities {

    private UniversityService service = new UniversityService();
    private JTable table = new JTable();
    private DefaultTableModel model = (DefaultTableModel) table.getModel();
    private JTextField id, name, shortName;

    public ManageUniversities() {
        JFrame frame = new JFrame("Manage Professors");
        addUniversitiesToTable();
        tableMouseClicked();
        JScrollPane sp = new JScrollPane();
        sp.setPreferredSize(new Dimension(500, 600));
        sp.setLocation(300, 200);
        sp.getViewport().add(table);

        JPanel panel = new JPanel();
        panel.add(sp);

        JLabel l1 = new JLabel("ID");
        JLabel l2 = new JLabel("Name");
        JLabel l3 = new JLabel("Short Name");
        l1.setBounds(20, 50, 100, 30);
        l2.setBounds(20, 100, 100, 30);
        l3.setBounds(20, 150, 100, 30);


        id = new JTextField();
        name = new JTextField();
        shortName = new JTextField();
        id.setBounds(90, 50, 200, 30);
        name.setBounds(90, 100, 200, 30);
        shortName.setBounds(90, 150, 200, 30);

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
                service.deleteUniversity(id1);
            }
        });

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name1 = name.getText();
                String shortName1 = shortName.getText();
                University university = new University();
                university.setName(name1);
                university.setShortName(shortName1);
                service.addUniversity(university);
                table.repaint();
                table.revalidate();
            }
        });

        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer id1 = Integer.valueOf(id.getText());
                String name1 = name.getText();
                String shortName1 = shortName.getText();
                University university = service.getUniversity(id1);
                university.setName(name1);
                university.setShortName(shortName1);
                service.updateUniversity(university,id1);
            }
        });

        frame.add(delete);
        frame.add(add);
        frame.add(update);
        frame.add(id);
        frame.add(name);
        frame.add(shortName);
        frame.add(l1);
        frame.add(l2);
        frame.add(l3);
        frame.add(panel);
        frame.setSize(1200, 650);
        frame.setLocation(150, 150);
        frame.setVisible(true);
    }

    private void addUniversitiesToTable() {
        model.addColumn("Id");
        model.addColumn("Name");
        model.addColumn("Short Name");
       /* University university = service.getUniversity(2);
        Object[] rowData = new Object[3];
        rowData[0] = university.getId();
        rowData[1] = university.getName();
        rowData[2] = university.getShortName();
        model.addRow(rowData);*/
        List<University> list = service.getAllUniversities();
        Object[] rowData = new Object[3];
        for (University university : list) {
            rowData[0] = university.getId();
            rowData[1] = university.getName();
            rowData[2] = university.getShortName();
            model.addRow(rowData);
        }

    }

    private void tableMouseClicked() {
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                int rowIndex = table.getSelectedRow();
                id.setText(table.getValueAt(rowIndex, 0).toString());
                name.setText(table.getValueAt(rowIndex, 1).toString());
                shortName.setText(table.getValueAt(rowIndex, 2).toString());

            }

        });
    }
}

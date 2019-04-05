package controller;

import model.Mark;
import service.MarkService;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ManageMarks {
    private MarkService service = new MarkService();
    private JTable table = new JTable();
    private DefaultTableModel model = (DefaultTableModel) table.getModel();
    private JTextField id, value;

    public ManageMarks() {
        JFrame frame = new JFrame("Manage Marks");
        addMarksToTable();
        tableMouseClicked();
        JScrollPane sp = new JScrollPane();
        sp.setPreferredSize(new Dimension(500, 600));
        sp.setLocation(300, 200);
        sp.getViewport().add(table);

        JPanel panel = new JPanel();
        panel.add(sp);

        JLabel l1 = new JLabel("ID");
        JLabel l2 = new JLabel("Value");

        l1.setBounds(20, 50, 100, 30);
        l2.setBounds(20, 100, 100, 30);



        id = new JTextField();
        value = new JTextField();
        id.setBounds(90, 50, 200, 30);
        value.setBounds(90, 100, 200, 30);


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
                service.deleteMark(id1);
            }
        });

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String valueText = value.getText();
                Mark mark = new Mark();
                mark.setValue(Integer.parseInt(valueText));
                service.addMark(mark);
                table.repaint();
                table.revalidate();
            }
        });

        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer id1 = Integer.valueOf(id.getText());
                String valueText = value.getText();
                Mark mark = service.getMark(Integer.valueOf(valueText));
                mark.setValue(Integer.parseInt(valueText));
                service.updateMark(mark,id1);
            }
        });

        frame.add(delete);
        frame.add(add);
        frame.add(update);
        frame.add(id);
        frame.add(value);
        frame.add(l1);
        frame.add(l2);
        frame.add(panel);
        frame.setSize(1200, 650);
        frame.setLocation(100, 50);
        frame.setVisible(true);
    }

    private void addMarksToTable() {
        model.addColumn("Id");
        model.addColumn("Value");
        List<Mark> list = service.getAllMarks();
        Object[] rowData = new Object[3];
        for (Mark student : list) {
            rowData[0] = student.getId();
            rowData[1] = student.getValue();
            model.addRow(rowData);
        }

    }

    private void tableMouseClicked() {
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                int rowIndex = table.getSelectedRow();
                id.setText(table.getValueAt(rowIndex, 0).toString());
                value.setText(table.getValueAt(rowIndex, 1).toString());
            }

        });
    }
}

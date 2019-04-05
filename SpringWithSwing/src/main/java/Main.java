

import controller.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Main Frame");

        final JButton students = new JButton("Students");
        students.setBounds(25, 50, 100, 40);
        frame.add(students);
        students.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ManageStudents();
            }
        });

        final JButton professors = new JButton("Professors");
        professors.setBounds(150, 50, 100, 40);
        frame.add(professors);
        professors.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ManageProfessors();
            }
        });

        final JButton universities = new JButton("Marks");
        universities.setBounds(25, 125, 100, 40);
        frame.add(universities);
        universities.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ManageMarks();
            }
        });

        final JButton subjects = new JButton("Universities");
        subjects.setBounds(150, 125, 105, 40);
        frame.add(subjects);
        subjects.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ManageUniversities();
            }
        });

        final JButton marks = new JButton("Subjects");
        marks.setBounds(85, 200, 100, 40);
        frame.add(marks);
        marks.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ManageSubjects();
            }
        });

        frame.setSize(300, 300);
        frame.setLocation(500, 200);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}


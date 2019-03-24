
import service.ProfessorService;
import service.StudentService;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainWindow {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Main Frame");
        final JButton button = new JButton("Student");
        button.setBounds(30,100,100,50);
        frame.add(button);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ManageStudents();
            }
        });

        frame.setSize(500,300);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

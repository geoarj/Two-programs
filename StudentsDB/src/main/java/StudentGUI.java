import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

//Реализовать консольный или графический пользовательский интерфейс,
//        с помощью которого можно: добавить студента,
//        удалить студента по уникальному номеру,
//        вывести список студентов.

public class StudentGUI extends JFrame {

        JTextArea studentTextArea = new JTextArea();

        JLabel idLabel = new JLabel("ID: ");
        JTextField idTextField = new JTextField(10);
        JLabel nameLabel = new JLabel("Name: ");
        JTextField nameTextField = new JTextField(10);

        JButton addButton = new JButton("Add Student");
        JButton deleteButton = new JButton("Delete Student");
        JButton displayAllButton = new JButton("Display All Students");
        JButton exitButton = new JButton("Exit");

        //Class Instance Data:
        private LinkedList <Students> studentLinkedList = new LinkedList<Students>();


        public StudentGUI() {

            JPanel flow1Panel = new JPanel (new FlowLayout(FlowLayout.CENTER));
            JPanel flow2Panel = new JPanel (new FlowLayout(FlowLayout.CENTER));
            JPanel gridPanel = new JPanel (new GridLayout(2, 1));

            studentTextArea.setEditable(false);

            flow1Panel.add (idLabel);
            flow1Panel.add (idTextField);
            flow1Panel.add (nameLabel);
            flow1Panel.add (nameTextField);

            flow2Panel.add (addButton);
            flow2Panel.add (deleteButton);
            flow2Panel.add (displayAllButton);
            flow2Panel.add (exitButton);

            gridPanel.add (flow1Panel);
            gridPanel.add (flow2Panel);

            add (studentTextArea, BorderLayout.CENTER);
            add (gridPanel, BorderLayout.SOUTH);

            addButton.addActionListener(event -> addStudent());
            displayAllButton.addActionListener(event -> displayAll());
            exitButton.addActionListener(event -> exitFromApp());
            deleteButton.addActionListener(event -> deleteStudent());
        }


        private boolean isStudentIdInLinkedList(String idStr) {

            boolean isIDUnique = true;

            for (Students stud : studentLinkedList) {
                if (stud.getId().compareToIgnoreCase (idStr) == 0)
                {
                    isIDUnique = false;
                }
            }

            return isIDUnique;
        }

        private void addStudent() {

            boolean isIDUnique = true;

            for (Students stud : studentLinkedList) {
                if (stud.getId().compareToIgnoreCase (idTextField.getText()) == 0)
                {
                    isIDUnique = false;
                }
            }

            if (isStudentIdInLinkedList(idTextField.getText()) == false)
            {
                JOptionPane.showMessageDialog(null, "Error: student ID is already in the database.");
            }
            else {
                studentLinkedList.add
                        (new Students(nameTextField.getText(),
                                idTextField.getText()));
                displayAll();
            }
        }

        private void deleteStudent() {

        }

        private void displayAll() {
            studentTextArea.setText("");

            for (Students stud : studentLinkedList) {
                studentTextArea.append(stud + "\n");
            }
        }

        private void exitFromApp() {
            
            System.exit(0);
        }

    public static void main(String[] args) {
        StudentGUI app = new StudentGUI();

        app.setVisible(true);
        app.setSize(500, 500);
        app.setLocation(200, 100);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    }


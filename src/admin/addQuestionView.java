package admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class addQuestionView extends JFrame {
    addQuestionView() throws SQLException {
        super("Examinator");
        // initialization code...
        setSize(800, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);
        //icon
        Image icon = new javax.swing.ImageIcon("images/logo_b.png").getImage();
        setIconImage(icon);
        getContentPane().setBackground(Color.GRAY);
        setVisible(true);
        //set layout manager null
        setLayout(null);
        //adding button
        JButton add_category = new JButton("Add Question and Answers");
        add_category.setBounds(10, 10, 200, 30);
        add(add_category);


        JLabel label = new JLabel("Category");
        label.setBounds(15, 50, 60, 20);
        add(label);


        //add question JTextArea
        JTextArea add_question = new JTextArea();
        add_question.setBounds(250, 10, 480, 70);
        add(add_question);

        //add Answer JTextArea
        JTextArea add_answer_1 = new JTextArea();
        add_answer_1.setBounds(250, 100, 80, 40);
        add(add_answer_1);

        //add Answer JTextArea
        JTextArea add_answer_2 = new JTextArea();
        add_answer_2.setBounds(350, 100, 80, 40);
        add(add_answer_2);

        //add Answer JTextArea
        JTextArea add_answer_3 = new JTextArea();
        add_answer_3.setBounds(450, 100, 80, 40);
        add(add_answer_3);

        //add Answer JTextArea
        JTextArea add_answer_4 = new JTextArea();
        add_answer_4.setBounds(550, 100, 80, 40);
        add(add_answer_4);


        //add Answer JTextArea
        JTextArea add_answer_5 = new JTextArea();
        add_answer_5.setBounds(650, 100, 80, 40);
        add(add_answer_5);

        //List model and list view
        categoryController categoryController = new categoryController();

        List<categoryModel> categoryList = categoryController.getCategory();
        DefaultComboBoxModel combolistModel = new DefaultComboBoxModel();

        for (int i = 0; i < categoryList.size(); i++)
            combolistModel.addElement(categoryList.get(i).getName());

        JComboBox comboBox = new JComboBox(combolistModel);

        comboBox.setBounds(15, 100, 60, 20);
        add(comboBox);

        add_category.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println(comboBox.getSelectedItem());
//                try {
////                    int res = new categoryController().addCategory(add_category_name.getText().toString());
////                    if (res==1){
////                        System.out.println("Inserted");
////                        JOptionPane.showMessageDialog(null,"Category Inserted");
////                    }else{
////                        System.out.println("Error");
////                    }
////                } catch (SQLException e) {
////                    e.printStackTrace();
////                }
            }
        });
        repaint();
    }

    public static void main(String[] args) throws SQLException {
        new addQuestionView();
    }
}


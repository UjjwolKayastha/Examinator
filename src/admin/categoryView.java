package admin;
import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;
public class categoryView extends JFrame {
    categoryView() throws SQLException {
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
        JButton add_category = new JButton("Add Category");
        add_category.setBounds(10, 10, 150, 30);
        add(add_category);
        JTextField add_category_name = new JTextField();
        add_category_name.setBounds(250, 10, 200, 30);
        add(add_category_name);
        //List model and list view
        categoryController categoryController = new categoryController();
        List<categoryModel> categoryModelList = categoryController.getCategory();
        DefaultListModel listModel = new DefaultListModel();

        for (int i = 0; i < categoryModelList.size(); i++)
            listModel.addElement(categoryModelList.get(i).getName());

        JList<List> list = new JList(listModel);
        JScrollPane jScrollPane = new JScrollPane();
        list.setLayoutOrientation(JList.VERTICAL);
        jScrollPane.setViewportView(list);
        jScrollPane.setBounds(50, 50, 650, 650);
        add(jScrollPane);
        System.out.println(add_category_name.getText());
        add_category.addActionListener(actionEvent -> {
            System.out.println(add_category_name.getText());
            if (add_category_name.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"Empty Category");
            }else{
                try {
                    int res = new categoryController().addCategory(add_category_name.getText());
                    if (res==1){
                        System.out.println("Inserted");
                        JOptionPane.showMessageDialog(null,"Category Inserted");
                    }else{
                        System.out.println("Error");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
        repaint();
    }
    public static void main(String[] args) throws SQLException {
        new categoryView();
    }
}

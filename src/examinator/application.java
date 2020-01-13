import javax.swing.*;
import java.awt.*;

public class application extends JFrame {

    application(){
        super("Examinator");
        // initialization code...
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        //icon
        Image icon = new javax.swing.ImageIcon("images/logo_b.png").getImage();
        setIconImage(icon);
        getContentPane().setBackground(Color.GRAY);
        setVisible(true);

        //dashboard preparation

        //adding button
        JButton login  = new JButton("Login");
        login.setBounds(150,150,100,50);
        JButton register  = new JButton("Register");
        register.setBounds(150,100,100,50);
        add(login);
        add(register);
    }

    public static void main(String[] args) {
            new application();
    }
}

package com.assignment.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView extends JFrame{
    private JTextField username_tf;
    private JPasswordField password_pf;
    private JButton login_btn;
    private JPanel rootPanel;
    private JButton registerButton;
    private JLabel message_lbl;

    public String getUsername(){
        return this.username_tf.getText();
    }
    public String getPassword(){
        return new String(password_pf.getPassword());
    }
    public void setMessage(String msg){this.message_lbl.setText(msg);}

    public void setLoginActionListener(ActionListener listener){
        this.login_btn.addActionListener(listener);
    }

    public void setRegisterActionListener(ActionListener listener){
        this.registerButton.addActionListener(listener);
    }

    public LoginView() {
        add(rootPanel);
        setTitle("StoreApp");
        setResizable(false);
        setSize(400,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}

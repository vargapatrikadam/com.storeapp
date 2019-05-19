package com.assignment.views;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

public class RegistrationView extends JFrame{
    private JFormattedTextField username_tf;
    private JFormattedTextField email_tf;
    private JFormattedTextField firstname_tf;
    private JFormattedTextField lastname_tf;
    private JFormattedTextField postalcode_tf;
    private JFormattedTextField city_tf;
    private JFormattedTextField street_tf;
    private JFormattedTextField streetnumber_tf;
    private JButton registerButton;
    private JPasswordField password_pf;
    private JPanel rootPanel;
    private JLabel message_lbl;

    public String getUsername(){
        return this.username_tf.getText();
    }
    public String getEmail(){
        return this.email_tf.getText();
    }
    public String getFirstName(){
        return this.firstname_tf.getText();
    }
    public String getLastName(){
        return this.lastname_tf.getText();
    }
    public String getPostalCode(){
        return this.postalcode_tf.getText();
    }
    public String getCity(){
        return this.city_tf.getText();
    }
    public String getStreet(){
        return this.street_tf.getText();
    }
    public String getStreetNumber(){
        return this.streetnumber_tf.getText();
    }
    public String getPassword(){
        return new String(this.password_pf.getPassword());
    }
    public void setMessage(String msg){
        this.message_lbl.setText(msg);
    }
    public void setRegisterActionListener(ActionListener listener){
        this.registerButton.addActionListener(listener);
    }

    public RegistrationView(){
        add(rootPanel);
        setTitle("Registration");
        setResizable(false);
        setSize(400,400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}

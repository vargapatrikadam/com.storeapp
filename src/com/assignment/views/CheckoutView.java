package com.assignment.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CheckoutView extends JFrame{
    private JPanel rootPanel;
    private JButton nextButton;
    private JTextField email_tf;
    private JTextField firstname_tf;
    private JTextField lastname_tf;
    private JTextField postalcode_tf;
    private JTextField city_tf;
    private JTextField street_tf;
    private JTextField streetnumber_tf;
    private JRadioButton bank_card;
    private JRadioButton c_o_d;
    private JLabel paymentStatus;
    private ButtonGroup paymentType;


    public void setNextButtonActionListener(ActionListener listener){
        this.nextButton.addActionListener(listener);
    }

    public void setBank_cardActionListener(ActionListener listener){
        this.bank_card.addActionListener(listener);
    }

    public void setC_o_dActionListener(ActionListener listener){
        this.c_o_d.addActionListener(listener);
    }

    public void setPaymentStatus(String status){
        this.paymentStatus.setText(status);
    }

    public void setEmail_tf(String email) {
        this.email_tf.setText(email);
    }

    public void setFirstname_tf(String firstname) {
        this.firstname_tf.setText(firstname);
    }

    public void setLastname_tf(String lastname) {
        this.lastname_tf.setText(lastname);
    }

    public void setPostalcode_tf(String postalcode) {
        this.postalcode_tf.setText(postalcode);
    }

    public void setCity_tf(String city) {
        this.city_tf.setText(city);
    }

    public void setStreet_tf(String street) {
        this.street_tf.setText(street);
    }

    public void setStreetnumber_tf(String streetnumber) {
        this.streetnumber_tf.setText(streetnumber);
    }

    public CheckoutView() {
        add(rootPanel);
        setTitle("Checkout");
        setResizable(false);
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.streetnumber_tf.setEnabled(false);
        this.street_tf.setEnabled(false);
        this.city_tf.setEnabled(false);
        this.postalcode_tf.setEnabled(false);
        this.email_tf.setEnabled(false);
        this.firstname_tf.setEnabled(false);
        this.lastname_tf.setEnabled(false);
        paymentType = new ButtonGroup();

        paymentType.add(bank_card);
        paymentType.add(c_o_d);
    }
}

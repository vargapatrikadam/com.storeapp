package com.assignment.views;

import javax.swing.*;
import java.awt.event.ActionListener;

public class BankCardPaymentView extends JFrame{
    private JTextField bankcardnumber_tf;
    private JTextField expdate_tf;
    private JTextField cvc_tf;
    private JButton payButton;
    private JPanel rootPanel;
    private JLabel card_validation_lbl;

    public void setPayButtonActionListener(ActionListener listener){
        this.payButton.addActionListener(listener);
    }

    public String getBankCardNumber(){
        return this.bankcardnumber_tf.getText();
    }
    public String getExpDate(){
        return this.expdate_tf.getText();
    }
    public String getCvc(){
        return this.cvc_tf.getText();
    }

    public void setCard_validation_lbl(String state){
        this.card_validation_lbl.setText(state);
    }

    public BankCardPaymentView() {
        add(rootPanel);
        setTitle("Bank card payment");
        setResizable(false);
        setSize(500, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}

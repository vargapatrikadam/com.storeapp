package com.assignment.controllers;

import com.assignment.Classes.BankCardInfo;
import com.assignment.Strategy.BankCardPayment;
import com.assignment.models.Models.BankCardPaymentModel;
import com.assignment.views.BankCardPaymentView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankCardPaymentController {
    private BankCardPaymentView view;
    private BankCardPaymentModel model;
    private CheckoutController checkoutController;

    public BankCardPaymentController(BankCardPaymentView view, BankCardPaymentModel model, CheckoutController checkoutController) {
        this.view = view;
        this.model = model;
        this.checkoutController = checkoutController;

        this.view.setPayButtonActionListener(new PayButtonActionListener());
    }

    class PayButtonActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            model.setBank_card_number(view.getBankCardNumber());
            model.setCvc(view.getCvc());
            model.setExp_date(view.getExpDate());

            ((BankCardInfo)checkoutController.info).setCard_number(model.getBank_card_number());
            ((BankCardInfo)checkoutController.info).setCvc(model.getCvc());
            ((BankCardInfo)checkoutController.info).setExp_date(model.getExp_date());

            view.setVisible(false);
        }
    }
}

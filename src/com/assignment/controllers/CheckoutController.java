package com.assignment.controllers;

import com.assignment.Classes.BankCardInfo;
import com.assignment.Classes.CODInfo;
import com.assignment.Exceptions.PaymentFailedException;
import com.assignment.Interfaces.IPaymentInfo;
import com.assignment.Strategy.BankCardPayment;
import com.assignment.Strategy.CODPayment;
import com.assignment.Strategy.PaymentStrategy;
import com.assignment.models.DB_Models.PaymentMethod;
import com.assignment.models.DB_Models.User;
import com.assignment.models.DB_Models.Ware;
import com.assignment.models.Models.*;
import com.assignment.views.BankCardPaymentView;
import com.assignment.views.CheckoutView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckoutController {
    private CheckoutModel model;
    private CheckoutView view;
    private CheckoutController controller;
    private StoreController storeController;
    private ReceiptModel receiptModel;
    private WareReceiptModel wareReceiptModel;
    private PaymentMethodModel paymentMethodModel;
    PaymentStrategy strategy;
    IPaymentInfo info;

    public CheckoutController(CheckoutModel model, CheckoutView view, StoreController storeController) {
        this.model = model;
        this.view = view;
        this.controller = this;
        this.storeController = storeController;
        this.receiptModel = new ReceiptModel();
        this.wareReceiptModel = new WareReceiptModel();
        this.paymentMethodModel = new PaymentMethodModel();

        User user = model.getUser();
        this.view.setCity_tf(user.getCity());
        this.view.setEmail_tf(user.getEmail());
        this.view.setFirstname_tf(user.getFirst_name());
        this.view.setLastname_tf(user.getLast_name());
        this.view.setPostalcode_tf(user.getPostal_code());
        this.view.setStreet_tf(user.getStreet());
        this.view.setStreetnumber_tf(user.getStreet_number());
        this.view.setC_o_dActionListener(new CodPaymentSelectedListener());
        this.view.setBank_cardActionListener(new BankCardPaymentSelectedListener());
        this.view.setNextButtonActionListener(new PayButtonListener());

    }

    class BankCardPaymentSelectedListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            BankCardPaymentModel bankcardmodel = new BankCardPaymentModel();
            BankCardPaymentView bankcardview = new BankCardPaymentView();
            BankCardPaymentController bankcardcontroller = new BankCardPaymentController(
                    bankcardview,
                    bankcardmodel,
                    controller
            );
            bankcardview.setVisible(true);
            info = new BankCardInfo();
            strategy = new BankCardPayment();
            view.setNextButtonStatus(true);
        }
    }

    class CodPaymentSelectedListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            info = new CODInfo();
            ((CODInfo) info).setUser(model.getUser());
            strategy = new CODPayment();
            view.setNextButtonStatus(true);
        }
    }
    class PayButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                view.setPaymentStatus(strategy.Pay(info));
                User user = storeController.getUser();

                PaymentMethod method = paymentMethodModel.getPaymentMethodByName(info.info());

                long id = receiptModel.createReceipt(user, method);

                wareReceiptModel.createWareReceipt(storeController.getShoppingList(), id);

            }
            catch(PaymentFailedException ex) {
                view.setNextButtonStatus(false);
                view.setPaymentStatus(ex.getMessage());
            }
        }
    }
}

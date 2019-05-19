package com.assignment.controllers;

import com.assignment.models.Models.LoginModel;
import com.assignment.models.Models.RegisterModel;
import com.assignment.views.LoginView;
import com.assignment.views.RegistrationView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController {
    private LoginView view;
    private LoginModel model;

    public LoginController(LoginView view, LoginModel model) {
        this.view = view;
        this.model = model;

        view.setRegisterActionListener(new RegisterListener());
    }
    class RegisterListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            RegisterModel regmodel = new RegisterModel();
            RegistrationView regview = new RegistrationView();
            RegisterController regcontroller = new RegisterController(regview, regmodel);
            regview.setVisible(true);
        }
    }
}

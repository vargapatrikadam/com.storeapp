package com.assignment.controllers;

import com.assignment.models.DB_Models.User;
import com.assignment.models.Models.LoginModel;
import com.assignment.models.Models.RegisterModel;
import com.assignment.models.Models.StoreModel;
import com.assignment.views.LoginView;
import com.assignment.views.RegistrationView;
import com.assignment.views.StoreView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Logger;


public class LoginController {
    private static final Logger LOGGER = Logger.getLogger( LoginController.class.getName() );

    private LoginView view;
    private LoginModel model;

    public LoginController(LoginView view, LoginModel model) {
        this.view = view;
        this.model = model;

        view.setLoginActionListener(new LoginListener());
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
    class LoginListener implements  ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String username = view.getUsername();
            String password = view.getPassword();
            try {
                 User user = model.Login(username, password);
                 if (user != null) {
                     //store redirection
                     StoreModel storemod = new StoreModel();
                     storemod.setLoggedInUser(user);
                     StoreView storeview = new StoreView();
                     StoreController controller = new StoreController(storemod, storeview);
                     storeview.setVisible(true);
                     LOGGER.info("username: " + username + " password: "+ password + " successfully logged in");
                     view.setVisible(false);
                 }
                 else {
                     LOGGER.info("username: " + username + " password: "+ password + " failed to login");
                     view.setMessage("Login unsuccessful!");
                 }
            }
            catch(SQLException ex){
                LOGGER.info("username: " + username + "password: "+ password + " failed to login");
                view.setMessage("Login unsuccessful!");
            }
        }
    }
}

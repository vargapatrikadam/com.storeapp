package com.assignment.controllers;

import com.assignment.models.DB_Models.User;
import com.assignment.models.Models.RegisterModel;
import com.assignment.views.RegistrationView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class RegisterController {
    private RegistrationView view;
    private RegisterModel model;

    public RegisterController(RegistrationView view, RegisterModel model) {
        this.view = view;
        this.model = model;
        view.setRegisterActionListener(new RegisterListener());
    }


    class RegisterListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                User newUser = new User(
                    view.getUsername(),
                    view.getPassword(),
                    view.getEmail(),
                    view.getFirstName(),
                    view.getLastName(),
                    view.getPostalCode(),
                    view.getCity(),
                    view.getStreet(),
                    view.getStreetNumber()
                );
                model.Register(newUser);
                view.setMessage("Successful registration!");
            }
            catch (SQLException ex){
                view.setMessage("Error during registration!");
            }
        }
    }
}

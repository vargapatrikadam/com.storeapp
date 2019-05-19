package com.assignment;

import com.assignment.controllers.LoginController;
import com.assignment.models.Models.DbConnector;
import com.assignment.models.Models.LoginModel;
import com.assignment.views.LoginView;
import com.assignment.views.RegistrationView;
import sun.rmi.runtime.Log;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        LoginView view = new LoginView();
        LoginModel model = new LoginModel();
        LoginController controller = new LoginController(view, model);
        view.setVisible(true);
    }
}

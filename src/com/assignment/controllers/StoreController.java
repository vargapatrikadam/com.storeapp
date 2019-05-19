package com.assignment.controllers;

import com.assignment.models.DB_Models.Ware;
import com.assignment.models.Models.CheckoutModel;
import com.assignment.models.Models.StoreModel;
import com.assignment.views.CheckoutView;
import com.assignment.views.StoreView;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StoreController {
    private StoreModel model;
    private StoreView view;

    public StoreController(StoreModel model, StoreView view) {
        this.model = model;
        this.view = view;
        model.getAllWares();
        showTableData(view.getStore_table(), model.wares);
        showTableData(view.getShopping_list_table(), model.shoppingList);

        view.setAddToShoppingListActionListener(new AddToShoppingList());
        view.removeFromShoppingListActionListener(new RemoveFromShoppingList());
        view.setCheckoutButtonActionListener(new GoToCheckout());
    }

    public void showTableData(JTable table, ArrayList<Ware> list){
        DefaultTableModel model = (DefaultTableModel)table.getModel();

        int rowCount = model.getRowCount();

        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }

        for (Ware ware: list) {
            model.addRow(new Object[]{ware.getId(), ware.getWare_name(), ware.getPrice(), ware.getWare_type(), ware.getManufacturer_name()});
        }

        table.setModel(model);
    }

    class AddToShoppingList implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int column = 0;
            int row = view.getStore_table().getSelectedRow();

            String value = view.getStore_table().getModel().getValueAt(row, column).toString();

            model.addToShoppingListById(Integer.parseInt(value));

            showTableData(view.getShopping_list_table(), model.shoppingList);

            view.setPriceLabel(model.getTotalPrice());
        }
    }
    class RemoveFromShoppingList implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int column = 0;
            int row = view.getShopping_list_table().getSelectedRow();

            String value = view.getShopping_list_table().getModel().getValueAt(row, column).toString();

            DefaultTableModel shopping_list_model = (DefaultTableModel)view.getShopping_list_table().getModel();
            shopping_list_model.removeRow(row);

            model.removeFromShoppingListById(Integer.parseInt(value));

            showTableData(view.getShopping_list_table(), model.shoppingList);

            view.setPriceLabel(model.getTotalPrice());
        }
    }

    class GoToCheckout implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(model.getShoppingList().size() > 0) {
                CheckoutView checkoutView = new CheckoutView();
                CheckoutModel checkoutModel = new CheckoutModel();
                checkoutModel.setUser(model.getLoggedInUser());
                CheckoutController checkoutController = new CheckoutController(
                        checkoutModel,
                        checkoutView
                );
                checkoutView.setVisible(true);
            }
        }
    }
}

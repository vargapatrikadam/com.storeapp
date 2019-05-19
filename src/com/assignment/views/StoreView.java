package com.assignment.views;

import com.mysql.cj.xdevapi.Table;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class StoreView extends JFrame{

    private JTable store_table;
    private JButton buy_btn;
    private JTable shopping_list_table;
    private JButton remove_btn;
    private JPanel rootPanel;
    private JScrollPane store_table_scroll_panel;
    private JScrollPane shopping_list_table_scoll_panel;
    private JLabel price_lbl;
    private JButton checkoutButton;

    public void setPriceLabel(int price){
        this.price_lbl.setText(Integer.toString(price));
    }

    public void setAddToShoppingListActionListener(ActionListener listener){
        this.buy_btn.addActionListener(listener);
    }

    public void removeFromShoppingListActionListener(ActionListener listener){
        this.remove_btn.addActionListener(listener);
    }

    public void setCheckoutButtonActionListener(ActionListener listener){
        this.checkoutButton.addActionListener(listener);
    }

    public JButton getRemove_btn() {
        return remove_btn;
    }

    public JTable getStore_table() {
        return store_table;
    }

    public void setStore_table(JTable store_table) {
        this.store_table = store_table;
    }

    public JTable getShopping_list_table() {
        return shopping_list_table;
    }

    public void setShopping_list_table(JTable shopping_list_table) {
        this.shopping_list_table = shopping_list_table;
    }

    public StoreView(){
        add(rootPanel);
        setTitle("StoreApp");
        setResizable(false);
        setSize(800,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[] colnames = {"id", "ware name", "price", "ware type", "manufacturer"};

        DefaultTableModel store_model = new DefaultTableModel();
        store_model.setColumnIdentifiers(colnames);
        store_table.setModel(store_model);

        DefaultTableModel shoppinglist_model = new DefaultTableModel();
        shoppinglist_model.setColumnIdentifiers(colnames);
        shopping_list_table.setModel(shoppinglist_model);

        shopping_list_table_scoll_panel.setViewportView(this.shopping_list_table);
        store_table_scroll_panel.setViewportView(this.store_table);

        shopping_list_table.setRowSelectionAllowed(true);
        store_table.setRowSelectionAllowed(true);

        this.buy_btn.setEnabled(false);
        this.remove_btn.setEnabled(false);

        store_table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (store_table.getSelectedRow() > -1) {
                    buy_btn.setEnabled(true);
                }
                else buy_btn.setEnabled(false);
            }
        });

        shopping_list_table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (shopping_list_table.getSelectedRow() > -1) {
                    remove_btn.setEnabled(true);
                }
                else {
                    remove_btn.setEnabled(false);
                }
            }
        });
    }
}

package test;

import com.assignment.models.DB_Models.Ware;
import com.assignment.models.Models.StoreModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StoreModelTest {

    @Test
    void getTotalPrice() {
        StoreModel model = new StoreModel();
        Ware ware1 = new Ware();
        Ware ware2 = new Ware();
        ware1.setId(1);
        ware1.setPrice(20000);
        ware2.setId(2);
        ware2.setPrice(2000);
        model.addWare(ware1);
        model.addWare(ware2);
        model.addToShoppingListById(1);
        model.addToShoppingListById(2);

        int expected = 22000;
        int actual = model.getTotalPrice();

        assertEquals(expected, actual);
    }

    @Test
    void addToShoppingListById() {
        StoreModel model = new StoreModel();
        Ware ware1 = new Ware();
        ware1.setId(1);
        model.addWare(ware1);
        model.addToShoppingListById(1);

        boolean actual = model.shoppingList.contains(ware1);

        assertTrue(actual);
    }

    @Test
    void removeFromShoppingListById() {
        StoreModel model = new StoreModel();
        Ware ware1 = new Ware();
        ware1.setId(1);
        model.addWare(ware1);
        model.addToShoppingListById(1);
        model.removeFromShoppingListById(1);

        boolean actual = model.shoppingList.contains(ware1);

        assertFalse(actual);
    }

    @Test
    void getAllWares() {
        StoreModel model = new StoreModel();
        Ware ware1 = new Ware();
        Ware ware2 = new Ware();
        Ware ware3 = new Ware();
        model.addWare(ware1);
        model.addWare(ware2);
        model.addWare(ware3);

        int expected = 3;
        int actual = model.wares.size();

        assertEquals(expected, actual);

    }
}
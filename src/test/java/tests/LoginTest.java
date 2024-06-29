package tests;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class LoginTest extends BaseTest {
    @Test
    public void correctLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertEquals(productsPage.getTitle(), "Products");
    }

    @Test
    public void incorrectLogin() {
        loginPage.open();
        loginPage.login("user", "secret_sauce");
        assertEquals("Error text is not correctt", "Epic sadface: Username and password do not match any user in this service", productsPage.getErrorText());
    }

    @Test
    public void incorrectPassword() {
        loginPage.open();
        loginPage.login("standard_user", "secret");
        assertEquals("Error text is not correct", "Epic sadface: Username and password do not match any user in this service", productsPage.getErrorText());
    }

    @Test
    public void emptyInputFields() {
        loginPage.open();
        loginPage.login("", "");
        assertEquals("Error text is not correct", "Epic sadface: Username is required", productsPage.getErrorText());

    }
}
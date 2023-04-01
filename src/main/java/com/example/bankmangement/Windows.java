package com.example.bankmangement;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Windows {
    private static Windows instance = null;
    private static final String VIWES = "/layout/views.fxml";
    private static final String LEASE_AGREEMENT = "/layout/lease_form.fxml";
    private static final String ADD_ACCOUNT = "/layout/add_account_layout.fxml";
    private static final String LOGIN_LAYOUT = "/layout/login_layout.fxml";
    private static final String VISITATION = "/layout/visitation_card.fxml";
    private static final String CONTACT_TO_CUSTOMER = "/layout/contact_to_customer.fxml";
    private Stage leaseAgreementWindow;
    private Stage viewWindow;
    private Stage visitationWindow;
    private Stage customerContactWindow;
    private Stage loginWindow;
    private Stage addAccountWindow;

    private Windows() {
        leaseAgreementWindow = getWindow(LEASE_AGREEMENT, "Lease Agreement", 600, 300);
        viewWindow = getWindow(VIWES, "View Info", 1000, 300);
        visitationWindow = getWindow(VISITATION, "Visitation", 500, 320);
        customerContactWindow = getWindow(CONTACT_TO_CUSTOMER, "Contact to customer", 500, 300);
        loginWindow = getWindow(LOGIN_LAYOUT, "Login", 400, 300);
        addAccountWindow = getWindow(ADD_ACCOUNT, "Add Account", 500, 300);
    }

    private static Stage getWindow(String layout, String title, Integer minSize, Integer maxSize) {
        try {
            Parent firstRoot = FXMLLoader.load(Objects.requireNonNull(Windows.class.getResource(layout)));
            Scene scene = new Scene(firstRoot);
            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(scene);
            stage.sizeToScene();
            stage.setMinWidth(minSize);
            stage.setMinHeight(maxSize);
            return stage;
        } catch (IOException e) {
            System.out.println("Can not create Window");
        }
        return new Stage();
    }

    public static Windows getInstance() {
        if (instance == null) {
            instance = new Windows();
        }
        return instance;
    }

    public Stage leaseAgreementWindow() {
        return leaseAgreementWindow;
    }

    public Stage infoViewWindow() {
        return viewWindow;
    }

    public Stage visitationWindow() {
        return visitationWindow;
    }

    public Stage customerContactWindow() {
        return customerContactWindow;
    }

    public Stage addAccountWindow() {
        return addAccountWindow;
    }

    public Stage loginWindow() {
        return loginWindow;
    }
}
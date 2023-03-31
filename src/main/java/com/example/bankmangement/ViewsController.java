package com.example.bankmangement;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ViewsController implements Initializable {


    @FXML
    private TableView<Lease> leaseTabTable;

    @FXML
    private TableColumn<Lease, Integer> leaseTabCustomerID;

    @FXML
    private TableColumn<Lease, Integer> leaseTabBoxNo;

    @FXML
    private TableColumn<Lease, String> leaseVisitRentDate;

    @FXML
    private TableColumn<Lease, String> leaseTabExpireDate;

    @FXML
    private TableColumn<Lease, Integer> leaseTabAmount;

    @FXML
    private TableColumn<Lease, String> leaseTabDeputyName;



    //
    @FXML
    private TableView<VisitationCard> visitingCardTabTable;
    @FXML
    private TableColumn<VisitationCard, Integer> visitingCardTabCustomerIDColumn;
    @FXML
    private TableColumn<VisitationCard, Integer> visitingCardTabBoxNumberColumn;
    @FXML
    private TableColumn<VisitationCard, String> visitingCardTabVisitDateColumn;
    @FXML
    private TableColumn<VisitationCard, String> visitingCardTabVisitTimeColumn;
    @FXML
    private TableColumn<VisitationCard, Boolean> visitingCardTabAsDeputyColumn;
    @FXML
    private TableColumn<VisitationCard, String> visitingCardTabDescriptionColumn;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeVisitTab();
        initializeLeaseTab();
    }
    public void initializeVisitTab() {
        // Set up the table columns to display the data from the VisitationCard objects
        visitingCardTabCustomerIDColumn.setCellValueFactory(new PropertyValueFactory<>("customerID"));
        visitingCardTabBoxNumberColumn.setCellValueFactory(new PropertyValueFactory<>("boxNumber"));
        visitingCardTabVisitDateColumn.setCellValueFactory(new PropertyValueFactory<>("visitDate"));
        visitingCardTabVisitTimeColumn.setCellValueFactory(new PropertyValueFactory<>("visitTime"));
        visitingCardTabAsDeputyColumn.setCellValueFactory(new PropertyValueFactory<>("asDeputy"));
        visitingCardTabDescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        // Create a list of VisitationCard objects to display in the table
        List<VisitationCard> visitCards = Fao.read(TableName.VISITATION_CARD_TABLE);
        visitingCardTabTable.getItems().addAll(visitCards);
    }
    public void initializeLeaseTab() {
        leaseTabCustomerID.setCellValueFactory(new PropertyValueFactory<>("customerID"));
        leaseTabBoxNo.setCellValueFactory(new PropertyValueFactory<>("boxNumber"));
        leaseVisitRentDate.setCellValueFactory(new PropertyValueFactory<>("rentDate"));
        leaseTabExpireDate.setCellValueFactory(new PropertyValueFactory<>("expireDate"));
        leaseTabAmount.setCellValueFactory(new PropertyValueFactory<>("depositAmount"));
        leaseTabDeputyName.setCellValueFactory(new PropertyValueFactory<>("deputyName"));
        List<Lease> leaseList = Fao.read(TableName.LEASE_TABLE);
        leaseTabTable.getItems().addAll(leaseList);
    }

}

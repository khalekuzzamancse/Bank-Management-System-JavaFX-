package com.example.bankmangement;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ViewsController implements Initializable {

    //Customer tab

    @FXML
    private TableView<Customer> customerTable;

    @FXML
    private TableColumn<Customer, String> nameCol;

    @FXML
    private TableColumn<Customer, String> emailCol;

    @FXML
    private TableColumn<Customer, String> phoneCol;

    @FXML
    private TableColumn<Customer, String> firmCol;

    @FXML
    private TableColumn<Customer, String> addressCol;

    @FXML
    private TableColumn<Customer, String> eyeColorCol;

    @FXML
    private TableColumn<Customer, String> hairColorCol;

    @FXML
    private TableColumn<Customer, String> heightCol;

    @FXML
    private TableColumn<Customer, String> weightCol;

    @FXML
    private TableColumn<Customer, Double> balanceCol;

    @FXML
    private TableColumn<Customer, Integer> userIdCol;


    ///


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

    //historyTab
    @FXML
    private TableView<HistoryCard> historyCardTable;
    @FXML
    private TableColumn <HistoryCard,Integer> historyTabCustomerID;
    @FXML
    private TableColumn  <HistoryCard,Integer> historyTabBoxNo;
    @FXML
    private TableColumn  <HistoryCard,String> historyTabRentDate;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeCustomerTab();
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

    private void initializeLeaseTab() {
        leaseTabCustomerID.setCellValueFactory(new PropertyValueFactory<>("customerID"));
        leaseTabBoxNo.setCellValueFactory(new PropertyValueFactory<>("boxNumber"));
        leaseVisitRentDate.setCellValueFactory(new PropertyValueFactory<>("rentDate"));
        leaseTabExpireDate.setCellValueFactory(new PropertyValueFactory<>("expireDate"));
        leaseTabAmount.setCellValueFactory(new PropertyValueFactory<>("depositAmount"));
        leaseTabDeputyName.setCellValueFactory(new PropertyValueFactory<>("deputyName"));
        List<Lease> leaseList = Fao.read(TableName.LEASE_TABLE);
        leaseTabTable.getItems().addAll(leaseList);
    }

    private void initializeCustomerTab() {
        nameCol.setCellValueFactory(new PropertyValueFactory<>("userID"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        phoneCol.setCellValueFactory(new PropertyValueFactory<>("balance"));
        firmCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        addressCol.setCellValueFactory(new PropertyValueFactory<>("address"));
        eyeColorCol.setCellValueFactory(new PropertyValueFactory<>("eyeColor"));
        hairColorCol.setCellValueFactory(new PropertyValueFactory<>("hairColor"));
        heightCol.setCellValueFactory(new PropertyValueFactory<>("height"));
        weightCol.setCellValueFactory(new PropertyValueFactory<>("weight"));
        balanceCol.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        userIdCol.setCellValueFactory(new PropertyValueFactory<>("firm"));
        List<Customer> customerList = new ArrayList<>();
        customerList = Fao.read(TableName.CUSTOMER_TABLE);
        customerTable.getItems().addAll(customerList);
    }
    private void initializeHistoryTab(){
        historyTabCustomerID.setCellValueFactory(new PropertyValueFactory<>("customerID"));
        historyTabBoxNo.setCellValueFactory(new PropertyValueFactory<>("boxNumber"));
        historyTabRentDate.setCellValueFactory(new PropertyValueFactory<>("rentDate"));
        List<HistoryCard> historyCardList = new ArrayList<>();
        historyCardList = Fao.read(TableName.HISTORY_CARD_TABLE);
        historyCardTable.getItems().addAll(historyCardList);
    }

}

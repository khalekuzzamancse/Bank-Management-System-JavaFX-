package com.example.bankmangement;

import javafx.stage.Stage;


public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws Exception {
       Windows.getInstance().leaseAgreementWindow().show();
       Windows.getInstance().infoViewWindow().show();
        //  Windows.getInstance().customerContactWindow().show();
        //  Windows.getInstance().visitationWindow().show();
//Windows.getInstance().addAccountWindow().show();
//    Windows.getInstance().loginWindow().show();
     //   Windows.getInstance().getExperimental().show();

    }


    public static void main(String[] args) {
        launch(args);
    }

}



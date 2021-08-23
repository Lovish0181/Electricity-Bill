package ElectricityBill;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class ElectricityBillFormController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private CheckBox chkac;

    @FXML
    private CheckBox chkcooler;

    @FXML
    private Button btnbill;

    @FXML
    private RadioButton raddomestic;

    @FXML
    private ToggleGroup rad;

    @FXML
    private RadioButton radcommercial;

    @FXML
    private Button btnnetbill;

    @FXML
    private TextField txtnet;

    @FXML
    private TextField txtdiscount;

    @FXML
    private TextField txttotal;

    @FXML
    private TextField txtcooler;

    @FXML
    private TextField txtac;

    @FXML
    private ComboBox<String> loadcombo;
    
    int bill,net;
    String load;
    @FXML
    void dobill(ActionEvent event) {
    	String acwatt=txtac.getText();
    	String coolerwatt=txtcooler.getText();
    	bill=(100*(Integer.parseInt(load)))+(100*(Integer.parseInt(acwatt))+(50*(Integer.parseInt(coolerwatt))));
    	txttotal.setText(String.valueOf(bill));
    }

    @FXML
    void dochkac(ActionEvent event) {
    	if(chkac.isSelected())
    	{
    		txtac.setDisable(false);
    	}
    	else
    	{
    		txtac.setDisable(true);
    		txtac.setText("");
    	}
    }

    @FXML
    void dochkcooler(ActionEvent event) {
    	if(chkcooler.isSelected())
    	{
    		txtcooler.setDisable(false);
    	}
    	else
    	{
    		txtcooler.setDisable(true);
    		txtcooler.setText("");
    	}
    }

    @FXML
    void doloadcombo(ActionEvent event) {
    load=loadcombo.getSelectionModel().getSelectedItem();
    }

    @FXML
    void donetbill(ActionEvent event) {
    	txtdiscount.setText(String.valueOf(net));
    	txtnet.setText(String.valueOf(bill-net));
    }

    @FXML
    void doradcommercial(ActionEvent event) {
    	if(radcommercial.isSelected())
    	{
    		net=bill-(bill/10);
    	}
    }

    @FXML
    void doraddomestic(ActionEvent event) {
    	if(raddomestic.isSelected())
    	{
    		net=bill-(bill/5);
    	}
    }

    @FXML
    void initialize() {
        ArrayList<String> load=new ArrayList<String>(Arrays.asList("100","150","200","250","300"));
        loadcombo.getSelectionModel().select(3);
        loadcombo.getItems().addAll(load);
        txtac.setDisable(true);
        txtcooler.setDisable(true);
    }
}

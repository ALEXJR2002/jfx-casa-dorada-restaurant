package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
/*import javafx.fxml.FXMLLoader;
import model.Restaurant;
import javafx.scene.Parent;*/
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;

public class InventoryGUI {

	//admin_orders_pane.fxml attributes
	
	@FXML
    private AnchorPane orderPane;

    @FXML
    private ListView<?> lvOrders;

    @FXML
    private Label labOrderId;

    @FXML
    private Label labOrderTotalPrice;

    @FXML
    private Label labOrderStatus;

    @FXML
    private Label labOrderClientName;

    @FXML
    private Label labOrderEmployeeName;

    @FXML
    private TableView<?> tvProducts;

    @FXML
    private TableColumn<?, ?> tcOrderProductName1;

    @FXML
    private TableColumn<?, ?> tcOrderProductName;

    @FXML
    private TableColumn<?, ?> tcOrderProductType;

    @FXML
    private TableColumn<?, ?> tcOrderProductSize;

    @FXML
    private TableColumn<?, ?> tcOrderProductPrice;

    @FXML
    private Label labOrderComments;

    @FXML
    private Label labClientComments;

    @FXML
    private TextField adminImportSeparatorTxt;

    @FXML
    private TextField adminExportSeparatorTxt;

    @FXML
    private DatePicker datePicker;

    @FXML
    private ChoiceBox<?> timePicker;
    
    //products_pane.fxml attributes
    
    @FXML
    private AnchorPane productsPane;

    @FXML
    private ListView<?> lvProducts;

    @FXML
    private ComboBox<?> cbIngredients;

    @FXML
    private TextField sizeNameTxt;

    @FXML
    private TableView<?> tvIngredients;

    @FXML
    private TableColumn<?, ?> tcProductIngredientName;

    @FXML
    private TableColumn<?, ?> tcProductIngredientCode;

    @FXML
    private TableView<?> tvSizes;

    @FXML
    private TableColumn<?, ?> tcProductSizeName;

    @FXML
    private TableColumn<?, ?> tcProductSizePrice;

    @FXML
    private TextField sizePriceTxt;

    @FXML
    private TextField newProductNameTxt;

    @FXML
    private ComboBox<?> cbTypeForNewProduct;

    @FXML
    private ComboBox<?> cbIngredientForNewProduct;

    @FXML
    private TableView<?> tvIngredientsForNewProduct;

    @FXML
    private TableColumn<?, ?> tcIngredientsNameNewProduct;

    @FXML
    private TableColumn<?, ?> tcIngredientsCodeNewProduct;

    @FXML
    private TableView<?> tvSizesForNewProduct;

    @FXML
    private TableColumn<?, ?> tcSizeNameNewProduct;

    @FXML
    private TableColumn<?, ?> tcSizePriceNewProduct;

    @FXML
    private TextField newSizePriceTxt;

    @FXML
    private TextField newSizeTxt;

    @FXML
    private Label labProductId;

    @FXML
    private TextField productNameTxt;

    @FXML
    private ToggleButton tbAvailability;

    @FXML
    private ComboBox<?> cbCategoryInProducts;

    @FXML
    private TextField productsImportSeparatorTxt;

    @FXML
    private TextField productsExportSeparatorTxt;
    
    //type_of_products_pnae.fxml attributes
    
    @FXML
    private AnchorPane typePane;

    @FXML
    private ListView<?> lvTypes;

    @FXML
    private Label labTypeId;

    @FXML
    private TextField typeNameTxt;

    @FXML
    private ToggleButton tbTypeAvailability;

    @FXML
    private TextField newTypeNameTxt;

    @FXML
    private ToggleButton tbNewTypeAvailability;

    @FXML
    private TextField typeImportSeparatorTxt;

    @FXML
    private TextField typeExportSeparator;
    
    public InventoryGUI() {
    	
    }
    
    //Orders Pane ActionEvent methods
    
    @FXML
    public void exportAdminsList(ActionEvent event) {

    }

    @FXML
    public void filterOrders(ActionEvent event) {

    }

    @FXML
    public void importAdminsList(ActionEvent event) {

    }
    
    //Products Pane ActionEvent methods
    
    @FXML
    public void addIIngredientToNewProduct(ActionEvent event) {

    }

    @FXML
    public void addISizeToNewProduct(ActionEvent event) {

    }

    @FXML
    public void addIngredient(ActionEvent event) {

    }

    @FXML
    public void addSize(ActionEvent event) {

    }

    @FXML
    public void changeAvailability(ActionEvent event) {

    }

    @FXML
    public void createNewProduct(ActionEvent event) {

    }

    @FXML
    public void exportProductsList(ActionEvent event) {

    }

    @FXML
    public void importProductsList(ActionEvent event) {

    }

    @FXML
    public void updateProductName(ActionEvent event) {

    }
    
	//Type of Product ActionEvent methods
    
    @FXML
    public void changeNewTypeAvailability(ActionEvent event) {

    }

    @FXML
    public void changeTypeAvailability(ActionEvent event) {

    }

    @FXML
    public void createNewType(ActionEvent event) {

    }

    @FXML
    public void exportTypeList(ActionEvent event) {

    }

    @FXML
    public void importTypeList(ActionEvent event) {

    }

    @FXML
    public void updateType(ActionEvent event) {

    }
    
}
package ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import model.Ingredient;
import model.PriceBySize;
import model.Restaurant;

public class InventoryGUI {

	//admin_orders_pane.fxml attributes
	
	@FXML
    private AnchorPane orderPane;

    @FXML
    private ListView<String> lvOrders;

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
    private TextField ordersImportSeparatorTxt;

    @FXML
    private TextField ordersExportSeparatorTxt;

    @FXML
    private DatePicker datePicker;

    @FXML
    private ChoiceBox<?> timePicker;
    
    @FXML
    private DatePicker datePicker1;

    @FXML
    private ChoiceBox<?> timePicker1;

    
    //products_pane.fxml attributes
    
    @FXML
    private AnchorPane productsPane;

    @FXML
    private ListView<String> lvProducts;

    @FXML
    private ComboBox<String> cbIngredients;

    @FXML
    private TextField sizeNameTxt;

    @FXML
    private TableView<Ingredient> tvIngredients;

    @FXML
    private TableColumn<Ingredient, String> tcProductIngredientName;

    @FXML
    private TableColumn<Ingredient, String> tcProductIngredientCode;

    @FXML
    private TableView<PriceBySize> tvSizes;

    @FXML
    private TableColumn<PriceBySize, String> tcProductSizeName;

    @FXML
    private TableColumn<PriceBySize, Integer> tcProductSizePrice;

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
    
    //type_of_products_pane.fxml attributes
    
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

	private Restaurant restaurant;
    
    public InventoryGUI() {
 
    }
    
    public void injectAdminGUI(Restaurant restaurant) {
    	this.restaurant = restaurant;
    }
    
    //Orders Pane ActionEvent methods
    
    public void loadOrders() {
    	ObservableList<String> orders = FXCollections.observableArrayList(restaurant.getIdOrders());
    	lvOrders.setItems(orders);
    }
    
    @FXML
    public void exportOrdersList(ActionEvent event) {
    	FileChooser chooser = new FileChooser();
	    chooser.setTitle("Choose location To Save Report");
	    File selectedFile = null;
	    while(selectedFile== null){
	        selectedFile = chooser.showSaveDialog(null);
	    }
	    File file = new File(selectedFile.getAbsolutePath());
	    String separator = ordersExportSeparatorTxt.getText();
	    String listViewId = "";
	    /*try {
			restaurant.exportOrders(file.getName(), separator, listViewId);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
    }

    @FXML
    public void filterOrders(ActionEvent event) {

    }

    @FXML
    public void importOrdersList(ActionEvent event) {
    	FileChooser fileChooser = new FileChooser();
    	fileChooser.setTitle("Abrir archivo");
    	File file = fileChooser.showOpenDialog(orderPane.getScene().getWindow());
    	if(file != null) {
    		try {
    			try {
					restaurant.importOrders(file.getAbsolutePath(), ordersImportSeparatorTxt.getText());
				} catch (ParseException e) {
					System.out.println("Parse Exception");
					e.printStackTrace();
				}
    			Alert alert = new Alert(AlertType.INFORMATION);
    		    alert.setTitle("Importar pedidos");
    		    alert.setHeaderText(null);
    		    alert.setContentText("Los pedidos han sido importados");
    		    alert.showAndWait();
    		    loadOrders();
    		} catch(IOException io) {
    			Alert alert = new Alert(AlertType.ERROR);
    		    alert.setTitle("Importar pedidos");
    		    alert.setHeaderText(null);
    		    alert.setContentText("Los pedidos no han podido ser importados");
    		    alert.showAndWait();
    		}
    	}
    }
    
    //Products Pane ActionEvent methods
    
    public void loadProducts() {
    	ObservableList<String> products = FXCollections.observableArrayList(restaurant.getIdProducts());
    	lvOrders.setItems(products);
    }
    
    @FXML
    public void addIIngredientToNewProduct(ActionEvent event) {
    	
    }

    @FXML
    public void addISizeToNewProduct(ActionEvent event) {

    }

    @FXML
    public void addIngredient(ActionEvent event) {
    	int index = lvProducts.getSelectionModel().getSelectedIndex();
    	for(int i = 0; i<restaurant.getIngredients().size(); i++) {
    		if(restaurant.getIngredients().get(i).getName().equals(cbIngredients.getSelectionModel().getSelectedItem())) {
    			restaurant.getProducts().get(index).addIngredient(restaurant.getIngredients().get(i));
    		}
    	}
    	loadIngredientsProduct(index);
    }

    @FXML
    public void addSize(ActionEvent event) {
    	int index = lvProducts.getSelectionModel().getSelectedIndex();
    	if(sizeNameTxt.getText().isEmpty() || sizePriceTxt.getText().isEmpty()) {
    		Alert alert = new Alert(AlertType.ERROR);
	    	alert.setTitle("");
	    	alert.setHeaderText(null);
	    	alert.setContentText("�Ups! No has llenado todos los campos para a�adir un tama�o y su precio");
	    	alert.showAndWait();
    	}
    	else {
    		PriceBySize newPriceBySize = new PriceBySize(sizeNameTxt.getText(), Integer.parseInt(sizePriceTxt.getText()));
    		restaurant.getProducts().get(index).addPriceBySize(newPriceBySize);
    		loadPricesBySizeProduct(index);
    	}
    }

    @FXML
    public void changeAvailability(ActionEvent event) {
    	int index = lvProducts.getSelectionModel().getSelectedIndex();
    	if(tbAvailability.getText().equals("Habilitado")) {
    		restaurant.getProducts().get(index).setAvailability(false);
    		tbAvailability.setText("Deshabilitado");
    	}
    	else {
    		restaurant.getProducts().get(index).setAvailability(true);
    		tbAvailability.setText("Habilitado");
    	}
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
    	int index = lvProducts.getSelectionModel().getSelectedIndex();
    	restaurant.getProducts().get(index).setName(productNameTxt.getText());
    }
    
    public void loadIngredientsProduct(int indexProduct) {
    	ObservableList<Ingredient> ingredientsProduct = FXCollections.observableArrayList(restaurant.getProducts().get(indexProduct).getIngredients());
		tvIngredients.setItems(ingredientsProduct);
		tcProductIngredientName.setCellValueFactory(new PropertyValueFactory<Ingredient,String>("name"));
		tcProductIngredientCode.setCellValueFactory(new PropertyValueFactory<Ingredient,String>("id"));
    }
    
    public void loadPricesBySizeProduct(int indexProduct) {
    	ObservableList<PriceBySize> pricesBySize = FXCollections.observableArrayList(restaurant.getProducts().get(indexProduct).getPricesBySizes());
		tvSizes.setItems(pricesBySize);
		tcProductSizeName.setCellValueFactory(new PropertyValueFactory<PriceBySize,String>("size"));
		tcProductSizePrice.setCellValueFactory(new PropertyValueFactory<PriceBySize,Integer>("price"));
    }
    
	@FXML 
	public void handleMouseClick(MouseEvent arg0) {
		int index = lvProducts.getSelectionModel().getSelectedIndex();
		productNameTxt.setText(restaurant.getProducts().get(index).getName());
		if(restaurant.getProducts().get(index).isAvailability()) {
			tbAvailability.setText("Habilitado");
		}
		else {
			tbAvailability.setText("Deshabilitado");
		}
		cbCategoryInProducts.setPromptText(restaurant.getProducts().get(index).getType().getName());
		
		loadIngredientsProduct(index);
		loadPricesBySizeProduct(index);
		
		//Separating ingredients enable
		ArrayList<String> ingredients = new ArrayList<>();
		for(int i = 0; i<restaurant.getIngredients().size(); i++) {
			if(restaurant.getIngredients().get(i).isAvailability()) {
				ingredients.add(restaurant.getIngredients().get(i).getName());
			}
		}
		ObservableList<String> ingredientsEnable = FXCollections.observableArrayList(ingredients);
		cbIngredients.setItems(ingredientsEnable);
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

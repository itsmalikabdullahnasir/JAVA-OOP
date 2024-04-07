import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {

    private TableView<Contact> tableView;
    private TextField nameField, phoneNumberField, emailField;
    private ObservableList<Contact> contacts;

    @Override
    public void start(Stage primaryStage) {
        // Initialize contacts list
        contacts = FXCollections.observableArrayList();

        // Create form elements
        Label nameLabel = new Label("Name:");
        nameField = new TextField();

        Label phoneNumberLabel = new Label("Phone Number:");
        phoneNumberField = new TextField();

        Label emailLabel = new Label("Email:");
        emailField = new TextField();

        Button addButton = new Button("Add");
        addButton.setOnAction(e -> addContact());

        // Form layout
        VBox formLayout = new VBox(10);
        formLayout.getChildren().addAll(nameLabel, nameField, phoneNumberLabel, phoneNumberField, emailLabel, emailField, addButton);

        // Table setup
        tableView = new TableView<>();
        TableColumn<Contact, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Contact, String> phoneNumberColumn = new TableColumn<>("Phone Number");
        phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));

        TableColumn<Contact, String> emailColumn = new TableColumn<>("Email");
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

        tableView.getColumns().addAll(nameColumn, phoneNumberColumn, emailColumn);
        tableView.setItems(contacts);

        // Main layout
        VBox mainLayout = new VBox(10);
        mainLayout.getChildren().addAll(formLayout, tableView);

        // Show scene
        Scene scene = new Scene(mainLayout, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Address Book");
        primaryStage.show();
    }

    private void addContact() {
        String name = nameField.getText();
        String phoneNumber = phoneNumberField.getText();
        String email = emailField.getText();

        if (!name.isEmpty() && !phoneNumber.isEmpty() && !email.isEmpty()) {
            Contact contact = new Contact(name, phoneNumber, email);
            contacts.add(contact);

            nameField.clear();
            phoneNumberField.clear();
            emailField.clear();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

class Contact {
    private String name;
    private String phoneNumber;
    private String email;

    public Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

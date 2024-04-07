import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class StudentRegistrationForm extends Application {

    private TableView<Student> tableView;
    private TextField nameField, idField, emailField;
    private ToggleGroup genderGroup;
    private CheckBox termsCheckBox;
    private ObservableList<Student> students;

    @Override
    public void start(Stage primaryStage) {
        // Initialize students list
        students = FXCollections.observableArrayList();

        // Create form elements
        Label nameLabel = new Label("Name:");
        nameField = new TextField();

        Label idLabel = new Label("ID:");
        idField = new TextField();

        Label emailLabel = new Label("Email:");
        emailField = new TextField();

        Label genderLabel = new Label("Gender:");
        RadioButton maleRadioButton = new RadioButton("Male");
        RadioButton femaleRadioButton = new RadioButton("Female");
        RadioButton otherRadioButton = new RadioButton("Other");
        maleRadioButton.setUserData("Male");
        femaleRadioButton.setUserData("Female");
        otherRadioButton.setUserData("Other");
        genderGroup = new ToggleGroup();
        maleRadioButton.setToggleGroup(genderGroup);
        femaleRadioButton.setToggleGroup(genderGroup);
        otherRadioButton.setToggleGroup(genderGroup);

        Label termsLabel = new Label("Agree to Terms and Conditions:");
        termsCheckBox = new CheckBox();

        Button registerButton = new Button("Register");
        registerButton.setOnAction(e -> registerStudent());

        // Form layout
        GridPane formLayout = new GridPane();
        formLayout.setVgap(10);
        formLayout.setHgap(10);
        formLayout.addRow(0, nameLabel, nameField);
        formLayout.addRow(1, idLabel, idField);
        formLayout.addRow(2, emailLabel, emailField);
        formLayout.addRow(3, genderLabel, new HBox(10, maleRadioButton, femaleRadioButton, otherRadioButton));
        formLayout.addRow(4, termsLabel, termsCheckBox);
        formLayout.add(registerButton, 1, 5);

        // Table setup
        tableView = new TableView<>();
        TableColumn<Student, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Student, String> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Student, String> emailColumn = new TableColumn<>("Email");
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

        TableColumn<Student, String> genderColumn = new TableColumn<>("Gender");
        genderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));

        tableView.getColumns().addAll(nameColumn, idColumn, emailColumn, genderColumn);
        tableView.setItems(students);

        // Main layout
        VBox mainLayout = new VBox(10);
        mainLayout.getChildren().addAll(formLayout, tableView);

        // Show scene
        Scene scene = new Scene(mainLayout, 500, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Student Registration Form");
        primaryStage.show();
    }

    private void registerStudent() {
        String name = nameField.getText();
        String id = idField.getText();
        String email = emailField.getText();
        String gender = genderGroup.getSelectedToggle() != null ?
                genderGroup.getSelectedToggle().getUserData().toString() : "";

        if (!name.isEmpty() && !id.isEmpty() && !email.isEmpty() && !gender.isEmpty() && termsCheckBox.isSelected()) {
            Student student = new Student(name, id, email, gender);
            students.add(student);

            // Clear form fields
            nameField.clear();
            idField.clear();
            emailField.clear();
            genderGroup.selectToggle(null);
            termsCheckBox.setSelected(false);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Incomplete Information");
            alert.setHeaderText(null);
            alert.setContentText("Please fill in all fields and agree to the terms and conditions.");
            alert.showAndWait();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

class Student {
    private String name;
    private String id;
    private String email;
    private String gender;

    public Student(String name, String id, String email, String gender) {
        this.name = name;
        this.id = id;
        this.email = email;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}

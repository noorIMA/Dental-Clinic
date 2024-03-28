package com.mysql.databrase;

import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import java.sql.Connection;
import javafx.application.Application;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;
import javafx.util.converter.LongStringConverter;

public class FullProjDataBase extends Application {

    ArrayList<Patient> dataPatient;
    private ObservableList<Patient> dataListPatient;

    ArrayList<Doctor> dataDoctor;
    private ObservableList<Doctor> dataListDoctor;

    ArrayList<description> datadescription;
    private ObservableList<description> dataListdescription;

    ArrayList<Appointment> dataApointment;
    private ObservableList<Appointment> dataListApointment;

    ArrayList<medication> dataMedication;
    private ObservableList<medication> dataListMedication;

    private String dbURL;
    private String dbUsername = "root";
    private String dbPassword = "moath000";
    private String URL = "127.0.0.1";
    private String port = "3306";
    private String dbName = "dental_clinic";
    private Connection con;

    @Override
    public void start(Stage stage) {
        mainInterFace(stage);
        stage.show();
    }

    public void mainInterFace(Stage stage) {
        BorderPane bp = new BorderPane();
        VBox vb = new VBox();

        ImageView EnterIm = new ImageView("https://img.icons8.com/cute-clipart/344/enter-2.png");
        EnterIm.setFitWidth(40);
        EnterIm.setFitHeight(40);
        Button Enter = new Button(" Enter ", EnterIm);
        Enter.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 25));
        Enter.setTranslateX(600);
        Enter.setTranslateY(400);
        Enter.setPrefSize(220, 90);
        Enter.setStyle("-fx-border-color:green");

        Image image = new Image("C:\\Users\\Admin\\Desktop\\Data Base\\Capture.PNG");
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        imageView.setFitWidth(700);
        imageView.setFitHeight(250);
        imageView.setTranslateY(-20);
        imageView.setTranslateX(350);

        vb.getChildren().addAll(Enter, imageView);
        vb.setSpacing(40);

        bp.setCenter(vb);

        Enter.setOnAction(e -> {
            try {
                list(stage);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });
        bp.setStyle("-fx-background-color: white;");
        Scene scene = new Scene(bp, 1370, 700);
        stage.setScene(scene);
        stage.show();
    }

    public void interfasePass() {

        Stage s = new Stage();

        TextField tpass = new TextField("entr your pass");

    }

    public void list(Stage stage) throws Exception {
        BorderPane bp = new BorderPane();
        VBox vb = new VBox();

        ImageView PatientIm = new ImageView("https://cdn-icons-png.flaticon.com/512/3470/3470248.png");
        PatientIm.setFitWidth(40);
        PatientIm.setFitHeight(40);
        Button Patient = new Button(" Patient ", PatientIm);
        Patient.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 25));
        Patient.setTranslateX(90);
        Patient.setTranslateY(120);
        Patient.setPrefSize(250, 90);
        Patient.setStyle("-fx-border-color:green");

        ImageView doctorIm = new ImageView("https://cdn-icons-png.flaticon.com/512/9193/9193824.png");
        doctorIm.setFitWidth(40);
        doctorIm.setFitHeight(40);
        Button doctor = new Button(" Doctors ", doctorIm);
        doctor.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 25));
        doctor.setTranslateX(420);
        doctor.setTranslateY(22);
        doctor.setPrefSize(255, 93);
        doctor.setStyle("-fx-border-color:green");

        ImageView descriptionIm = new ImageView("https://cdn-icons-png.flaticon.com/512/3176/3176218.png");
        descriptionIm.setFitWidth(40);
        descriptionIm.setFitHeight(40);
        Button description = new Button(" Description  ", descriptionIm);
        description.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 25));
        description.setTranslateX(90);
        description.setTranslateY(80);
        description.setPrefSize(250, 90);
        description.setStyle("-fx-border-color:green");

        ImageView appointmentsIm = new ImageView("https://cdn-icons-png.flaticon.com/512/4428/4428204.png");
        appointmentsIm.setFitWidth(40);
        appointmentsIm.setFitHeight(40);
        Button appointments = new Button(" Appointments  ", appointmentsIm);
        appointments.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 25));
        appointments.setTranslateX(420);
        appointments.setTranslateY(-18);
        appointments.setPrefSize(250, 90);
        appointments.setStyle("-fx-border-color:green");

        ImageView backIm = new ImageView("https://cdn-icons-png.flaticon.com/512/3368/3368865.png");
        backIm.setFitWidth(40);
        backIm.setFitHeight(40);
        Button back = new Button(" Back  ", backIm);
        back.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 25));
        back.setTranslateX(250);
        back.setTranslateY(30);
        back.setPrefSize(250, 90);
        back.setStyle("-fx-border-color:green");

        Image image = new Image("C:\\Users\\Admin\\Desktop\\Data Base\\Capture.PNG");
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        imageView.setFitWidth(500);
        imageView.setFitHeight(250);
        imageView.setTranslateY(-300);
        imageView.setTranslateX(800);

        vb.getChildren().addAll(Patient, doctor, description, appointments, back, imageView);
        vb.setSpacing(40);

        bp.setCenter(vb);

        Patient.setOnAction(e -> {

            dataPatient = new ArrayList<>();

            try {
                getDataPatient();
            } catch (ClassNotFoundException | SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

            dataListPatient = FXCollections.observableArrayList(dataPatient);

            TablePatient(stage);
        });

        doctor.setOnAction(e -> {
            dataDoctor = new ArrayList<>();

            try {
                getDataDoctor();
            } catch (ClassNotFoundException | SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

            dataListDoctor = FXCollections.observableArrayList(dataDoctor);

            DoctorTabl(stage);

        });

        description.setOnAction(e -> {

            datadescription = new ArrayList<>();

            try {
                getDataDescription();
            } catch (ClassNotFoundException | SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

            dataListdescription = FXCollections.observableArrayList(datadescription);

            descriptionTabel(stage);

        });

        appointments.setOnAction(e -> {
            dataApointment = new ArrayList<>();

            try {
                getDataAppointmentt();
            } catch (ClassNotFoundException | SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

            dataListApointment = FXCollections.observableArrayList(dataApointment);

            AppTabel(stage);

        });

        back.setOnAction(e -> {
            try {
                start(stage);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

        bp.setStyle("-fx-background-color: white;");
        Scene scene = new Scene(bp, 1370, 700);
        stage.setScene(scene);
        stage.show();
    }

    ///////////////////////////////////// Patient /////////////////////////////////////////////////////////////////////
    @SuppressWarnings("unchecked")
    public void TablePatient(Stage stage) {
        BorderPane bp = new BorderPane();
        VBox vb = new VBox();

        TableView<Patient> TPatient = new TableView<>();
        TPatient.setPrefSize(800, 300);
        TPatient.setTranslateX(500);
        TPatient.setTranslateY(80);
        TPatient.setEditable(true);

        TableColumn<Patient, Integer> id_Col = new TableColumn<Patient, Integer>("ID");
        id_Col.setMinWidth(40);
        id_Col.setCellValueFactory(p -> new SimpleIntegerProperty(p.getValue().getPID()).asObject());
        id_Col.setCellFactory(TextFieldTableCell.<Patient, Integer>forTableColumn(new IntegerStringConverter()));

        id_Col.setOnEditCommit((CellEditEvent<Patient, Integer> t) -> {
            ((Patient) t.getTableView().getItems().get(t.getTablePosition().getRow())).setPID(t.getNewValue());
        });

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        TableColumn<Patient, String> name_Col = new TableColumn<Patient, String>("PName");
        name_Col.setPrefWidth(80);
        name_Col.setCellValueFactory(p -> new SimpleStringProperty(p.getValue().getPName()));
        name_Col.setCellFactory(TextFieldTableCell.<Patient>forTableColumn());

        name_Col.setOnEditCommit((CellEditEvent<Patient, String> t) -> {
            ((Patient) t.getTableView().getItems().get(t.getTablePosition().getRow())).setPName(t.getNewValue());

        });

        /////////////////////////////////////////////////////////////////////////////////////////////////
        TableColumn<Patient, String> gender_col = new TableColumn<Patient, String>("PGender");
        gender_col.setMinWidth(40);
        gender_col.setCellValueFactory(p -> new SimpleStringProperty(p.getValue().getPGender()));
        gender_col.setCellFactory(TextFieldTableCell.<Patient>forTableColumn());

        gender_col.setOnEditCommit((CellEditEvent<Patient, String> t) -> {
            ((Patient) t.getTableView().getItems().get(t.getTablePosition().getRow())).setPGender(t.getNewValue());
        });
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        TableColumn<Patient, Double> age_col = new TableColumn<Patient, Double>("PAge");
        age_col.setMinWidth(40);
        age_col.setCellValueFactory(p -> new SimpleDoubleProperty(p.getValue().getPAge()).asObject());
        age_col.setCellFactory(TextFieldTableCell.<Patient, Double>forTableColumn(new DoubleStringConverter()));

        age_col.setOnEditCommit((CellEditEvent<Patient, Double> t) -> {
            ((Patient) t.getTableView().getItems().get(t.getTablePosition().getRow())).setPAge(t.getNewValue());
//			updateAge(t.getRowValue().getPID(), t.getNewValue());

        });

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////

        TableColumn<Patient, String> stateOfHealthe_col = new TableColumn<Patient, String>("State_Of_healthe");
        stateOfHealthe_col.setMinWidth(100);
        stateOfHealthe_col.setCellValueFactory(p -> new SimpleStringProperty(p.getValue().getState_Of_healthe()));
        stateOfHealthe_col.setCellFactory(TextFieldTableCell.<Patient>forTableColumn());

        stateOfHealthe_col.setOnEditCommit((CellEditEvent<Patient, String> t) -> {
            ((Patient) t.getTableView().getItems().get(t.getTablePosition().getRow()))
                    .setState_Of_healthe(t.getNewValue());

        });

        /////////////////////////////////////////////////////////////////////////////////////////////////////

        TableColumn<Patient, String> diangnosis_col = new TableColumn<Patient, String>("diangnosis");
        diangnosis_col.setMinWidth(100);
        diangnosis_col.setCellValueFactory(p -> new SimpleStringProperty(p.getValue().getDiangnosis()));
        diangnosis_col.setCellFactory(TextFieldTableCell.<Patient>forTableColumn());

        diangnosis_col.setOnEditCommit((CellEditEvent<Patient, String> t) -> {
            ((Patient) t.getTableView().getItems().get(t.getTablePosition().getRow())).setDiangnosis(t.getNewValue());
        });
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        TableColumn<Patient, Long> insuranceNum_col = new TableColumn<Patient, Long>("insuranceN");
        insuranceNum_col.setCellValueFactory(p -> new SimpleLongProperty(p.getValue().getInsurance_num()).asObject());
        insuranceNum_col.setCellFactory(TextFieldTableCell.<Patient, Long>forTableColumn(new LongStringConverter()));
        insuranceNum_col.setCellFactory(TextFieldTableCell.<Patient, Long>forTableColumn(new LongStringConverter()));

        insuranceNum_col.setOnEditCommit((CellEditEvent<Patient, Long> t) -> {
            ((Patient) t.getTableView().getItems().get(t.getTablePosition().getRow()))
                    .setInsurance_num(t.getNewValue());
        });
        insuranceNum_col.setPrefWidth(80);

        //// __________________________________________

//        TableColumn<Patient, Double> amountPaid_col = new TableColumn<Patient, Double>("AmountOfPaid");
//        amountPaid_col.setMinWidth(40);
//        amountPaid_col.setCellValueFactory(p -> new SimpleDoubleProperty(p.getValue().getAmountPaid()).asObject());
//        amountPaid_col.setCellFactory(TextFieldTableCell.<Patient, Double>forTableColumn(new DoubleStringConverter()));
//
//        amountPaid_col.setOnEditCommit((CellEditEvent<Patient, Double> t) -> {
//            ((Patient) t.getTableView().getItems().get(t.getTablePosition().getRow())).setAmountPaid(t.getNewValue());
//        });

//_________________________________________

//        TableColumn<Patient, Long> medicineNum_col = new TableColumn<Patient, Long>("M.ID");
//        medicineNum_col.setCellValueFactory(p -> new SimpleLongProperty(p.getValue().getMedicineNum()).asObject());
//        medicineNum_col.setCellFactory(TextFieldTableCell.<Patient, Long>forTableColumn(new LongStringConverter()));
//        medicineNum_col.setCellFactory(TextFieldTableCell.<Patient, Long>forTableColumn(new LongStringConverter()));
//
//        medicineNum_col.setOnEditCommit((CellEditEvent<Patient, Long> t) -> {
//            ((Patient) t.getTableView().getItems().get(t.getTablePosition().getRow())).setMedicineNum(t.getNewValue());
//        });
//        medicineNum_col.setPrefWidth(40);

//-----------------------------------------------------------------------------------------------------------------------

        TableColumn<Patient, Long> phonNumber_col = new TableColumn<Patient, Long>("PhoneNummber");
        phonNumber_col.setCellValueFactory(p -> new SimpleLongProperty(p.getValue().getPhonNumber()).asObject());
        phonNumber_col.setCellFactory(TextFieldTableCell.<Patient, Long>forTableColumn(new LongStringConverter()));
        phonNumber_col.setCellFactory(TextFieldTableCell.<Patient, Long>forTableColumn(new LongStringConverter()));

        phonNumber_col.setOnEditCommit((CellEditEvent<Patient, Long> t) -> {
            ((Patient) t.getTableView().getItems().get(t.getTablePosition().getRow())).setPhonNumber(t.getNewValue());
        });
        phonNumber_col.setPrefWidth(100);

        TableColumn<Patient, String> aderess_col = new TableColumn<Patient, String>("Adress");
        aderess_col.setMinWidth(100);
        aderess_col.setCellValueFactory(p -> new SimpleStringProperty(p.getValue().getAddress()));
        aderess_col.setCellFactory(TextFieldTableCell.<Patient>forTableColumn());

        aderess_col.setOnEditCommit((CellEditEvent<Patient, String> t) -> {
            ((Patient) t.getTableView().getItems().get(t.getTablePosition().getRow())).setAddress(t.getNewValue());
        });

//____________________________________

//        TableColumn<Patient, Long> appointmentNum_col = new TableColumn<Patient, Long>("APP.ID");
//        appointmentNum_col
//                .setCellValueFactory(p -> new SimpleLongProperty(p.getValue().getAppointmentNum()).asObject());
//        appointmentNum_col.setCellFactory(TextFieldTableCell.<Patient, Long>forTableColumn(new LongStringConverter()));
//        appointmentNum_col.setCellFactory(TextFieldTableCell.<Patient, Long>forTableColumn(new LongStringConverter()));
//
//        appointmentNum_col.setOnEditCommit((CellEditEvent<Patient, Long> t) -> {
//            ((Patient) t.getTableView().getItems().get(t.getTablePosition().getRow()))
//                    .setAppointmentNum(t.getNewValue());
//        });
//        appointmentNum_col.setPrefWidth(40);

//        TableColumn<Patient, Integer> DoctorNum_col = new TableColumn<Patient, Integer>("D.ID");
//        DoctorNum_col.setCellValueFactory(p -> new SimpleIntegerProperty(p.getValue().getDoctorNum()).asObject());
//        DoctorNum_col.setCellFactory(TextFieldTableCell.<Patient, Integer>forTableColumn(new IntegerStringConverter()));
//
//        DoctorNum_col.setOnEditCommit((CellEditEvent<Patient, Integer> t) -> {
//            ((Patient) t.getTableView().getItems().get(t.getTablePosition().getRow())).setDoctorNum(t.getNewValue());
//        });
//        DoctorNum_col.setPrefWidth(40);

        // ______________

        TPatient.setEditable(true);

        TPatient.getColumns().addAll(id_Col, name_Col, gender_col, age_col, stateOfHealthe_col, diangnosis_col,
                insuranceNum_col, phonNumber_col, aderess_col);

        TPatient.setItems(dataListPatient);

        TPatient.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

//_____________label and taxt__________________

        Label lID = new Label("ID : ");
        lID.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));
        lID.setPrefWidth(80);
        lID.setTranslateY(50);
        lID.setTranslateX(50);
        TextField tID = new TextField();
        tID.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));
        tID.setTranslateX(130);
        tID.setTranslateY(-18);
        tID.setPrefWidth(50);
        tID.setStyle("-fx-border-color:green");

        Label lName = new Label("Name : ");
        lName.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));
        lName.setPrefWidth(80);
        lName.setTranslateY(-45);
        lName.setTranslateX(50);
        TextField tNAme = new TextField();
        tNAme.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));
        tNAme.setTranslateX(130);
        tNAme.setTranslateY(-108);
        // tNAme.setPrefWidth(150);
        // tNAme.setPrefSize(50,15);
        tNAme.setStyle("-fx-border-color:green");

        Label lGender = new Label("Gender : ");
        lGender.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));
        lGender.setPrefWidth(80);
        lGender.setTranslateY(-140);
        lGender.setTranslateX(40);
        TextField tGender = new TextField();
        tGender.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));
        tGender.setTranslateX(130);
        tGender.setTranslateY(-200);
        tGender.setPrefWidth(200);
        tGender.setStyle("-fx-border-color:green");

        Label lAge = new Label("Age : ");
        lAge.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));
        lAge.setPrefWidth(80);
        lAge.setTranslateY(-230);
        lAge.setTranslateX(60);
        TextField tAge = new TextField();
        tAge.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));
        tAge.setTranslateX(130);
        tAge.setTranslateY(-290);
        tAge.setPrefWidth(200);
        tAge.setStyle("-fx-border-color:green");

        Label lState = new Label("State of Health: ");
        lState.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));
        lState.setPrefWidth(110);
        lState.setTranslateY(-320);
        lState.setTranslateX(10);
        TextField tState = new TextField();
        tState.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));
        tState.setTranslateX(130);
        tState.setTranslateY(-382);
        tState.setPrefWidth(200);
        tState.setStyle("-fx-border-color:green");

        Label ldiangnosis = new Label("Diangnosis: ");
        ldiangnosis.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));
        ldiangnosis.setPrefWidth(100);
        ldiangnosis.setTranslateY(-410);
        ldiangnosis.setTranslateX(35);
        TextField tdiangnosis = new TextField();
        tdiangnosis.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));
        tdiangnosis.setTranslateX(130);
        tdiangnosis.setTranslateY(-475);
        tdiangnosis.setPrefWidth(200);
        tdiangnosis.setStyle("-fx-border-color:green");

        Label lInsurance = new Label("Insurance Number:");
        lInsurance.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));
        lInsurance.setPrefWidth(130);
        lInsurance.setTranslateY(-500);
        lInsurance.setTranslateX(5);
        TextField tInsurance = new TextField();
        tInsurance.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));
        tInsurance.setTranslateX(130);
        tInsurance.setTranslateY(-563);
        tInsurance.setPrefWidth(200);
        tInsurance.setStyle("-fx-border-color:green");


        Label lphonNumber = new Label("phone Num: ");
        lphonNumber.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));
        lphonNumber.setPrefWidth(130);
        lphonNumber.setTranslateY(-590);
        lphonNumber.setTranslateX(20);
        TextField tphonNumber = new TextField();
        tphonNumber.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));
        tphonNumber.setTranslateX(130);
        tphonNumber.setTranslateY(-655);
        tphonNumber.setPrefWidth(200);
        tphonNumber.setStyle("-fx-border-color:green");


        Label lAdress = new Label("Adress : ");
        lAdress.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));
        lAdress.setPrefWidth(100);
        lAdress.setTranslateY(-685);
        lAdress.setTranslateX(35);
        TextField tAdress = new TextField();
        tAdress.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));
        tAdress.setTranslateX(130);
        tAdress.setTranslateY(-745);
        tAdress.setPrefWidth(200);
        tAdress.setStyle("-fx-border-color:green");

//__________End label text _____________________

        ImageView addIm = new ImageView("https://cdn-icons-png.flaticon.com/512/863/863782.png");
        addIm.setFitWidth(20);
        addIm.setFitHeight(20);
        Button addB = new Button(" ADD Patient ", addIm);
        addB.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));
        addB.setTranslateX(200);
        addB.setTranslateY(-700);
        addB.setPrefSize(200, 30);
        addB.setStyle("-fx-border-color:green");

        ImageView dAllIm = new ImageView("https://cdn-icons-png.flaticon.com/512/3496/3496416.png");
        dAllIm.setFitWidth(20);
        dAllIm.setFitHeight(20);
        Button dAll = new Button(" Delete All ", dAllIm);
        dAll.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));
        dAll.setTranslateX(450);
        dAll.setTranslateY(-780);
        dAll.setPrefSize(200, 30);
        dAll.setStyle("-fx-border-color:green");

        ImageView delSelctedIm = new ImageView("https://cdn-icons-png.flaticon.com/512/1251/1251555.png");
        delSelctedIm.setFitWidth(20);
        delSelctedIm.setFitHeight(20);
        Button delSelcted = new Button(" Delete Selected ", delSelctedIm);
        delSelcted.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));
        delSelcted.setTranslateX(200);
        delSelcted.setTranslateY(-750);
        delSelcted.setPrefSize(200, 30);
        delSelcted.setStyle("-fx-border-color:green");

        ImageView backIm = new ImageView("https://cdn-icons-png.flaticon.com/512/3368/3368865.png");
        backIm.setFitWidth(20);
        backIm.setFitHeight(20);
        Button back = new Button(" Back  ", backIm);
        back.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));
        back.setTranslateX(450);
        back.setTranslateY(-830);
        back.setPrefSize(200, 30);
        back.setStyle("-fx-border-color:green");

        Image image = new Image("C:\\Users\\Admin\\Desktop\\Data Base\\Capture.PNG");
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        imageView.setFitWidth(250);
        imageView.setFitHeight(200);
        imageView.setTranslateY(-1075);
        imageView.setTranslateX(900);

        vb.getChildren().addAll(lID, tID, lName, tNAme, lGender, tGender, lAge, tAge, lState, tState, ldiangnosis,
                tdiangnosis, lInsurance, tInsurance, lphonNumber, tphonNumber,lAdress, tAdress,addB, dAll, delSelcted, back, imageView);
        vb.setSpacing(40);

        bp.setCenter(vb);

//		Label lTotalNum = new Label();

        addB.setOnAction((ActionEvent e) -> {
            Patient p;
            String id = tID.getText();
            String name = tNAme.getText();
            String gender = tGender.getText();
            String age = tAge.getText();
            String stateOfHelthe = tState.getText();
            String diangnosis = tdiangnosis.getText();
            String insurance = tInsurance.getText();
            String phonNumber = tphonNumber.getText();
            String adress = tAdress.getText();

            if (!id.equals("") && !name.equals("") && !gender.equals("") && !age.equals("") && !stateOfHelthe.equals("")
                    && !diangnosis.equals("") && !insurance.equals("") && !phonNumber.equals("")
                    && !adress.equals("")) {

                p = new Patient(Integer.parseInt(id), name, gender, Double.parseDouble(age), stateOfHelthe, diangnosis,
                        Long.parseLong(insurance), Long.parseLong(phonNumber), adress);

                dataListPatient.add(p);
                insertDatainPatient(p);

//				labelTotalUsers.setText("Total Users: " + table.getItems().size());
                tID.setText("");
                tNAme.setText("");
                tGender.setText("");
                tAge.setText("");
                tState.setText("");
                tdiangnosis.setText("");
                tInsurance.setText("");
                tphonNumber.setText("");
                tAdress.setText("");

            }
            System.out.println("empty String!!!");

        });

        dAll.setOnAction(e -> {
            TPatient.getItems().clear();
//           labelTotalUsers.setText("Total Users: " + TPatient.getItems().size());

        });

        delSelcted.setOnAction((ActionEvent e) -> {

            ObservableList<Patient> selectedRows = TPatient.getSelectionModel().getSelectedItems();
            ArrayList<Patient> rows = new ArrayList<>(selectedRows);
            rows.forEach(row -> {
                TPatient.getItems().remove(row);
                deleteRowinPatient(row);
                TPatient.refresh();
            });
        });

        back.setOnAction(e -> {
            try {
                list(stage);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

        Group b = new Group();

        b.getChildren().add(TPatient);
        b.getChildren().add(bp);

        bp.setStyle("-fx-background-color: white;");
        Scene scene = new Scene(b, 1370, 700);
        stage.setScene(scene);
        stage.show();
    }

    private void insertDatainPatient(Patient pa) {

        try {

            System.out.println(
                    "Insert into patient (pnum ,pname, gender ,age ,  staetOfhealth , diangnosis , insurance_num , phonNumber , address) values('"
                            + pa.getPName() + "','" + pa.getPGender() + "'," + pa.getPAge() + ",'"
                            + pa.getState_Of_healthe() + "','" + pa.getDiangnosis() + "'," + pa.getInsurance_num() + ","
                            + pa.getPhonNumber() + ",'" + pa.getAddress() + "'," + ");");

            connectDB();
            ExecuteStatement(
                    "Insert into patient (pnum ,pname, gender ,age ,  staetOfhealth , diangnosis , insurance_num , phonNumber , address) values('"
                            + pa.getPName() + "','" + pa.getPGender() + "'," + pa.getPAge() + ",'"
                            + pa.getState_Of_healthe() + "','" + pa.getDiangnosis() + "'," + pa.getInsurance_num() + ","
                            + pa.getPhonNumber() + ",'" + pa.getAddress() + "'," + ");");

            con.close();
            System.out.println("Connection closed" + dataPatient.size());

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void deleteRowinPatient(Patient row) {
        try {
            System.out.println("delete from  Patient where pnum=" + row.getPID() + ";");
            connectDB();
            ExecuteStatement("delete from  Patient where pnum=" + row.getPID() + ";");
            con.close();
            System.out.println("Connection closed");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void getDataPatient() throws SQLException, ClassNotFoundException {
        String SQL;

        connectDB();
        System.out.println("Connection established");

        SQL = "select pnum , pname , gender , age , staetOfhealth , diangnosis , insurance_num , phonNumber , address  from patient order by pnum";
        Statement stmt = con.createStatement();
        ResultSet pa = stmt.executeQuery(SQL);

        while (pa.next())
            dataPatient.add(new Patient(Integer.parseInt(pa.getString(1)), pa.getString(2), pa.getString(3),
                    Double.parseDouble(pa.getString(4)), pa.getString(5), pa.getString(6),
                    Long.parseLong(pa.getString(7)), Long.parseLong(pa.getString(8)), pa.getString(9)));

        pa.close();
        stmt.close();

        con.close();
        System.out.println("Connection closed" + dataPatient.size());

    }

    public void updateName(String string, String pname) {

        try {
            System.out.println("update  patient set pname = '" + pname + "' where pnum = " + string);
            connectDB();
            ExecuteStatement("update  patient set pname = '" + pname + "' where pnum = " + string + ";");
            con.close();
            System.out.println("Connection closed");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void updateGender(int pnum, String gender) {

        try {
            System.out.println("update  patient set gender = '" + gender + "' where pnum = " + pnum);
            connectDB();
            ExecuteStatement("update  patient set gender = '" + gender + "' where pnum = " + pnum + ";");
            con.close();
            System.out.println("Connection closed");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void updateAge(int pnum, double age) {

        try {
            System.out.println("update  patient set age = " + age + " where pnum = " + pnum);
            connectDB();
            ExecuteStatement("update  patient set age = " + age + " where pnum = " + pnum + ";");
            con.close();
            System.out.println("Connection closed");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void updatedocNum(int pnum, double docNum) {

        try {
            System.out.println("update  patient set DocNumber = " + docNum + " where pnum = " + pnum);
            connectDB();
            ExecuteStatement("update  patient set DocNumber = " + docNum + " where pnum = " + pnum + ";");
            con.close();
            System.out.println("Connection closed");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

//--------------------------For All Table------------------------------------------------------------------------------------------

    private void connectDB() throws ClassNotFoundException, SQLException {

        dbURL = "jdbc:mysql://" + URL + ":" + port + "/" + dbName + "?verifyServerCertificate=false";
        Properties p = new Properties();
        p.setProperty("user", dbUsername);
        p.setProperty("password", dbPassword);
        p.setProperty("useSSL", "false");
        p.setProperty("autoReconnect", "true");
        Class.forName("com.mysql.jdbc.Driver");

        con = DriverManager.getConnection(dbURL, p);

    }

    public void ExecuteStatement(String SQL) throws SQLException {

        try {

            Statement stmt = con.createStatement();
            stmt.executeUpdate(SQL);
            stmt.close();

        } catch (SQLException s) {
            s.printStackTrace();
            System.out.println("SQL statement is not executed!");

        }

    }

    public void DoctorTabl(Stage stage) {

        BorderPane b = new BorderPane();

        HBox h = new HBox();

        TableView<Doctor> TableDoctor = new TableView<>();
//		TableDoctor.setPrefSize(300, 100);
//		TableDoctor.setPrefHeight(100);
//		TableDoctor.setPrefWidth(20);
//		TableDoctor.setTranslateX(1);
//		TableDoctor.setTranslateY(100);
        TableDoctor.setMaxHeight(400);
        TableDoctor.setMaxWidth(600);

        TableColumn<Doctor, Integer> id_Col = new TableColumn<Doctor, Integer>("ID");
        id_Col.setMinWidth(40);
        id_Col.setCellValueFactory(p -> new SimpleIntegerProperty(p.getValue().getDoctor_Num()).asObject());
        id_Col.setCellFactory(TextFieldTableCell.<Doctor, Integer>forTableColumn(new IntegerStringConverter()));

        id_Col.setOnEditCommit((CellEditEvent<Doctor, Integer> t) -> {
            ((Doctor) t.getTableView().getItems().get(t.getTablePosition().getRow())).setDoctor_Num(t.getNewValue());
        });

        TableColumn<Doctor, String> name_Col = new TableColumn<Doctor, String>("DName");
        name_Col.setPrefWidth(150);
        name_Col.setCellValueFactory(p -> new SimpleStringProperty(p.getValue().getDoctor_Name()));
        name_Col.setCellFactory(TextFieldTableCell.<Doctor>forTableColumn());

        name_Col.setOnEditCommit((CellEditEvent<Doctor, String> t) -> {
            ((Doctor) t.getTableView().getItems().get(t.getTablePosition().getRow())).setDoctor_Name(t.getNewValue());

        });

        TableColumn<Doctor, String> WorkDays_Col = new TableColumn<Doctor, String>("Works Days");
        WorkDays_Col.setPrefWidth(150);
        WorkDays_Col.setCellValueFactory(p -> new SimpleStringProperty(p.getValue().getWorkDays()));
        WorkDays_Col.setCellFactory(TextFieldTableCell.<Doctor>forTableColumn());

        WorkDays_Col.setOnEditCommit((CellEditEvent<Doctor, String> t) -> {
            ((Doctor) t.getTableView().getItems().get(t.getTablePosition().getRow())).setWorkDays(t.getNewValue());

        });

        TableDoctor.getColumns().addAll(id_Col, name_Col, WorkDays_Col);
        TableDoctor.setItems(dataListDoctor);

        TableDoctor.setEditable(true);

        ImageView addIm = new ImageView("https://cdn-icons-png.flaticon.com/512/863/863782.png");
        addIm.setFitWidth(40);
        addIm.setFitHeight(40);
        Button addB = new Button(" ADD Doctor ", addIm);
        addB.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 25));
//		addB.setTranslateX(100);
//		addB.setTranslateY(-490);
        addB.setPrefSize(250, 50);
        addB.setStyle("-fx-border-color:green");

        ImageView dAllIm = new ImageView("https://cdn-icons-png.flaticon.com/512/3496/3496416.png");
        dAllIm.setFitWidth(40);
        dAllIm.setFitHeight(40);
        Button dAll = new Button(" Delete All ", dAllIm);
        dAll.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 25));
//		dAll.setTranslateX(900);
//		dAll.setTranslateY(-590);
        dAll.setPrefSize(250, 50);
        dAll.setStyle("-fx-border-color:green");

        ImageView delSelctedIm = new ImageView("https://cdn-icons-png.flaticon.com/512/1251/1251555.png");
        delSelctedIm.setFitWidth(40);
        delSelctedIm.setFitHeight(40);
        Button delSelcted = new Button(" Delete Selected ", delSelctedIm);
        delSelcted.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 25));
//		delSelcted.setTranslateX(600);
//		delSelcted.setTranslateY(-690);
        delSelcted.setPrefSize(250, 50);
        delSelcted.setStyle("-fx-border-color:green");

        ImageView backIm = new ImageView("https://cdn-icons-png.flaticon.com/512/3368/3368865.png");
        backIm.setFitWidth(40);
        backIm.setFitHeight(40);
        Button back = new Button(" Back  ", backIm);
        back.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 25));
//		back.setTranslateX(750);
//		back.setTranslateY(-850);
        back.setPrefSize(250, 50);
        back.setStyle("-fx-border-color:green");

        Label lID = new Label("ID : ");
        lID.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));
        lID.setPrefWidth(100);
//		lID.setTranslateY(180);
//		lID.setTranslateX(95);
        TextField tID = new TextField();
        tID.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));
//		tID.setTranslateX(200);
//		tID.setTranslateY(100);
        tID.setPrefWidth(250);
        tID.setStyle("-fx-border-color:green");

        Label lName = new Label("Name : ");
        lName.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));
        lName.setPrefWidth(100);
//		lName.setTranslateY(80);
//		lName.setTranslateX(90);
        TextField tNAme = new TextField();
        tNAme.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));
//		tNAme.setTranslateX(200);
//		tNAme.setTranslateY(0);
        tNAme.setPrefWidth(250);
        tNAme.setStyle("-fx-border-color:green");

        Label lWorkDays = new Label("Works Days : ");
        lWorkDays.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));
        lWorkDays.setPrefWidth(100);
//		lWorkDays.setTranslateY(-20);
//		lWorkDays.setTranslateX(90);
        TextField tWorkDays = new TextField();
        tWorkDays.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));
//		tWorkDays.setTranslateX(200);
//		tWorkDays.setTranslateY(-100);
        tWorkDays.setPrefWidth(250);
        tWorkDays.setStyle("-fx-border-color:green");

//		v.setSpacing(41);
//		v.getChildren().addAll(lID, tID, lName, tNAme, lWorkDays, tWorkDays, addB, delSelcted, back);
//		v.setAlignment(Pos.CENTER);
//
//		b.setCenter(v);

        addB.setOnAction(e -> {
            Doctor d;
            String id = tID.getText();
            String name = tNAme.getText();
            String workDays = tWorkDays.getText();

            if (!id.equals("") && !name.equals("") && !workDays.equals("")) {
                d = new Doctor(Integer.parseInt(id), name, workDays);

                dataListDoctor.add(d);
                insertDataDoctor(d);

                tID.setText("");
                tNAme.setText("");
                tWorkDays.setText("");

            }

        });

        dAll.setOnAction(e -> {
            TableDoctor.getItems().clear();
        });

        delSelcted.setOnAction(e -> {
            ObservableList<Doctor> selectedRows = TableDoctor.getSelectionModel().getSelectedItems();
            ArrayList<Doctor> rows = new ArrayList<>(selectedRows);
            rows.forEach(row -> {
                TableDoctor.getItems().remove(row);
                deleteRowinDoctor(row);
                TableDoctor.refresh();
            });
        });
        back.setOnAction(e -> {
            try {
                list(stage);
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        });

        GridPane g = new GridPane();
        g.setAlignment(Pos.CENTER_LEFT);
        g.add(lID, 0, 0);
        g.add(tID, 1, 0);
        g.add(lName, 0, 1);
        g.add(tNAme, 1, 1);
        g.add(lWorkDays, 0, 2);
        g.add(tWorkDays, 1, 2);
        g.setAlignment(Pos.CENTER_LEFT);

        h.getChildren().addAll(addB, delSelcted, dAll, back);
        h.setSpacing(10);
        h.setAlignment(Pos.BOTTOM_CENTER);

        b.setCenter(TableDoctor);
        BorderPane.setAlignment(TableDoctor, Pos.CENTER);

        b.setLeft(g);
        BorderPane.setAlignment(g, Pos.CENTER_LEFT);

        b.setBottom(h);
        BorderPane.setAlignment(h, Pos.BOTTOM_CENTER);

        b.setStyle("-fx-background-color: white;");
        Scene scene = new Scene(b, 1370, 700);
        stage.setScene(scene);
        stage.show();

    }

    private void getDataDoctor() throws SQLException, ClassNotFoundException {
        String SQL;

        connectDB();
        System.out.println("Connection established");

        SQL = "select DocNumber , DocName ,WorkDays from Doctor order by DocNumber";
        Statement stmt = con.createStatement();
        ResultSet pa = stmt.executeQuery(SQL);

        while (pa.next())
            dataDoctor.add(new Doctor(Integer.parseInt(pa.getString(1)), pa.getString(2), pa.getString(3)));

        pa.close();
        stmt.close();

        con.close();
        System.out.println("Connection closed" + dataDoctor.size());

    }

    private void insertDataDoctor(Doctor d) {

        try {
            System.out.println("Insert into Doctor (DocNumber , DocName, WorkDays) values(" + d.getDoctor_Num() + ",'"
                    + d.doctor_Name + "','" + d.getWorkDays() + "');");

            connectDB();
            ExecuteStatement("Insert into Doctor (DocNumber , DocName, WorkDays) values(" + d.getDoctor_Num() + ",'"
                    + d.doctor_Name + "','" + d.getWorkDays() + "');");

            con.close();
            System.out.println("Connection closed" + dataDoctor.size());

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void deleteRowinDoctor(Doctor d) {
        try {
            System.out.println("delete from  Doctor where DocNumber=" + d.getDoctor_Num() + ";");
            connectDB();
            ExecuteStatement("delete from  Doctor where DocNumber=" + d.getDoctor_Num() + ";");
            con.close();
            System.out.println("Connection closed");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void descriptionTabel(Stage stage) {

        BorderPane b = new BorderPane();
//		VBox v = new VBox();

        TableView<description> Tabledescription = new TableView<>();
//		Tabledescription.setPrefSize(300, 100);
//		Tabledescription.setPrefHeight();
//		Tabledescription.setPrefWidth(20);
//		Tabledescription.setTranslateX(1);
//		Tabledescription.setTranslateY(100);
        Tabledescription.setMaxHeight(400);
        Tabledescription.setMaxWidth(600);

        TableColumn<description, Integer> idD_Col = new TableColumn<description, Integer>("Doctor ID ");
        idD_Col.setMinWidth(40);
        idD_Col.setCellValueFactory(p -> new SimpleIntegerProperty(p.getValue().getDoctorID()).asObject());
        idD_Col.setCellFactory(TextFieldTableCell.<description, Integer>forTableColumn(new IntegerStringConverter()));

        idD_Col.setOnEditCommit((CellEditEvent<description, Integer> t) -> {
            ((description) t.getTableView().getItems().get(t.getTablePosition().getRow())).setDoctorID(t.getNewValue());
        });

        TableColumn<description, Integer> idP_Col = new TableColumn<description, Integer>("Patient ID ");
        idP_Col.setMinWidth(40);
        idP_Col.setCellValueFactory(p -> new SimpleIntegerProperty(p.getValue().getPatientID()).asObject());
        idP_Col.setCellFactory(TextFieldTableCell.<description, Integer>forTableColumn(new IntegerStringConverter()));

        idD_Col.setOnEditCommit((CellEditEvent<description, Integer> t) -> {
            ((description) t.getTableView().getItems().get(t.getTablePosition().getRow()))
                    .setPatientID(t.getNewValue());
        });

        TableColumn<description, Integer> idM_Col = new TableColumn<description, Integer>("Medication ID ");
        idD_Col.setMinWidth(40);
        idD_Col.setCellValueFactory(p -> new SimpleIntegerProperty(p.getValue().getMedicationID()).asObject());
        idD_Col.setCellFactory(TextFieldTableCell.<description, Integer>forTableColumn(new IntegerStringConverter()));

        idD_Col.setOnEditCommit((CellEditEvent<description, Integer> t) -> {
            ((description) t.getTableView().getItems().get(t.getTablePosition().getRow()))
                    .setMedicationID(t.getNewValue());
        });

        TableColumn<description, String> description_Col = new TableColumn<description, String>(" Description ");
        description_Col.setPrefWidth(150);
        description_Col.setCellValueFactory(p -> new SimpleStringProperty(p.getValue().getDescription()));
        description_Col.setCellFactory(TextFieldTableCell.<description>forTableColumn());

        description_Col.setOnEditCommit((CellEditEvent<description, String> t) -> {
            ((description) t.getTableView().getItems().get(t.getTablePosition().getRow()))
                    .setDescription(t.getNewValue());

        });

        Tabledescription.getColumns().addAll(idD_Col, idP_Col, idM_Col, description_Col);
        Tabledescription.setItems(dataListdescription);

        Tabledescription.setEditable(true);

        ImageView addIm = new ImageView("https://cdn-icons-png.flaticon.com/512/863/863782.png");
        addIm.setFitWidth(40);
        addIm.setFitHeight(40);
        Button addB = new Button(" ADD description ", addIm);
        addB.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 25));
//		addB.setTranslateX(100);
//		addB.setTranslateY(-490);
        addB.setPrefSize(300, 50);
        addB.setStyle("-fx-border-color:green");

        ImageView dAllIm = new ImageView("https://cdn-icons-png.flaticon.com/512/3496/3496416.png");
        dAllIm.setFitWidth(40);
        dAllIm.setFitHeight(40);
        Button dAll = new Button(" Delete All ", dAllIm);
        dAll.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 25));
//		dAll.setTranslateX(600);
//		dAll.setTranslateY(-400);
        dAll.setPrefSize(250, 50);
        dAll.setStyle("-fx-border-color:green");

        ImageView delSelctedIm = new ImageView("https://cdn-icons-png.flaticon.com/512/1251/1251555.png");
        delSelctedIm.setFitWidth(40);
        delSelctedIm.setFitHeight(40);
        Button delSelcted = new Button(" Delete Selected ", delSelctedIm);
        delSelcted.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 25));
//		delSelcted.setTranslateX(600);
//		delSelcted.setTranslateY(-790);
        delSelcted.setPrefSize(250, 50);
        delSelcted.setStyle("-fx-border-color:green");

        ImageView backIm = new ImageView("https://cdn-icons-png.flaticon.com/512/3368/3368865.png");
        backIm.setFitWidth(40);
        backIm.setFitHeight(40);
        Button back = new Button(" Back  ", backIm);
        back.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 25));
//		back.setTranslateX(550);
//		back.setTranslateY(-650);
        back.setPrefSize(250, 50);
        back.setStyle("-fx-border-color:green");

        ImageView medicationIm = new ImageView("https://cdn-icons-png.flaticon.com/512/1546/1546140.png");
        medicationIm.setFitWidth(40);
        medicationIm.setFitHeight(40);
        Button medication = new Button(" Medication  ", medicationIm);
        medication.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 25));
//		medication.setTranslateX(900);
//		medication.setTranslateY(-80);
        medication.setPrefSize(250, 50);
        medication.setStyle("-fx-border-color:green");

        Label lID = new Label(" Number Medication: ");
        lID.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));
        lID.setPrefWidth(250);
//		lID.setTranslateY(180);
//		lID.setTranslateX(95);
        TextField tID = new TextField();
        tID.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));
//		tID.setTranslateX(200);
//		tID.setTranslateY(100);
        tID.setPrefWidth(200);
        tID.setStyle("-fx-border-color:green");

        Label DID = new Label("Doctor ID : ");
        DID.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));
        DID.setPrefWidth(250);
//		DID.setTranslateY(-20);
//		DID.setTranslateX(90);
        TextField DIDTF = new TextField();
        DIDTF.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));
//		DIDTF.setTranslateX(200);
//		DIDTF.setTranslateY(-100);
        DIDTF.setPrefWidth(250);
        DIDTF.setStyle("-fx-border-color:green");

        Label PID = new Label("Patient ID : ");
        PID.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));
        PID.setPrefWidth(250);
//		PID.setTranslateY(-20);
//		PID.setTranslateX(90);
        TextField PIDTF = new TextField();
        PIDTF.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));
//		PIDTF.setTranslateX(200);
//		PIDTF.setTranslateY(-100);
        PIDTF.setPrefWidth(250);
        PIDTF.setStyle("-fx-border-color:green");

        Label description = new Label("Description : ");
        description.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));
        description.setPrefWidth(250);
//		description.setTranslateY(-20);
//		description.setTranslateX(90);
        TextField descriptionTA = new TextField();
        descriptionTA.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));
//		descriptionTA.setTranslateX(100);
//		descriptionTA.setTranslateY(-10);
        descriptionTA.setPrefWidth(250);
        descriptionTA.setStyle("-fx-border-color:green");

        GridPane g = new GridPane();

        g.add(DID, 0, 0);
        g.add(DIDTF, 1, 0);

        g.add(PID, 0, 1);
        g.add(PIDTF, 1, 1);

        g.add(lID, 0, 2);
        g.add(tID, 1, 2);

        g.add(description, 0, 3);
        g.add(descriptionTA, 1, 3);

        g.setAlignment(Pos.CENTER_LEFT);
        g.setVgap(20);
        g.setHgap(20);

        b.setLeft(g);
        b.setAlignment(g, Pos.CENTER_LEFT);

        HBox h = new HBox();
        h.setSpacing(30);
        h.setAlignment(Pos.BOTTOM_CENTER);

        h.getChildren().addAll(addB, dAll, delSelcted, medication, back);

//		b.setRight(Tabledescription);
//		b.setAlignment(Tabledescription, Pos.CENTER_RIGHT);

//		v.setSpacing(41);
//		v.getChildren().addAll(DID, DIDTF, PID, PIDTF, lID, tID, description, descriptionTA, addB, delSelcted, back);
//		v.setAlignment(Pos.CENTER);
//
//		b.setCenter(v);

        addB.setOnAction(e -> {
            description D;
            String DT = DIDTF.getText();
            String PT = PIDTF.getText();
            String MT = tID.getText();
            String DA = descriptionTA.getText();

            if (!DT.equals("") && !PT.equals("") && !MT.equals("") && !DA.equals("")) {
                D = new description(Integer.parseInt(DT), Integer.parseInt(PT), Integer.parseInt(MT), DA);

                insertDataDescribtion(D);

                DIDTF.setText("");
                PIDTF.setText("");
                tID.setText("");
                descriptionTA.setText("");

            }

        });
        dAll.setOnAction(e -> {
            Tabledescription.getItems().clear();
        });
        delSelcted.setOnAction(e -> {
            ObservableList<description> selectedRows = Tabledescription.getSelectionModel().getSelectedItems();
            ArrayList<description> rows = new ArrayList<>(selectedRows);
            rows.forEach(row -> {
                Tabledescription.getItems().remove(row);
                deleteRowinDescription(row);
                Tabledescription.refresh();
            });
        });

        medication.setOnAction(e -> {

            dataMedication = new ArrayList<>();

            try {
                getDataMedication();
            } catch (ClassNotFoundException | SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

            dataListMedication = FXCollections.observableArrayList(dataMedication);

            MedicationTabl(stage);

        });
        back.setOnAction(e -> {
            try {
                list(stage);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

        ;

        b.setCenter(Tabledescription);
        BorderPane.setAlignment(Tabledescription, Pos.CENTER);

//		b.setCenter(v);
//		BorderPane.setAlignment(v, Pos.CENTER);

        b.setBottom(h);
        b.setAlignment(h, Pos.BOTTOM_CENTER);

        b.setStyle("-fx-background-color: white;");
        Scene scene = new Scene(b, 1370, 700);
        stage.setScene(scene);
        stage.show();

    }

    private void deleteRowinDescription(description D) {
        try {
            System.out.println("delete from  descrip where DocNumber=" + D.getDoctorID() + "And pnum="
                    + D.getPatientID() + "And MedNumber=" + D.getMedicationID() + ";");
            connectDB();
            ExecuteStatement("delete from  descrip where DocNumber=" + D.getDoctorID() + "And pnum=" + D.getPatientID()
                    + "And MedNumber=" + D.getMedicationID() + ";");
            con.close();
            System.out.println("Connection closed");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void insertDataDescribtion(description D) {

        try {
            System.out.println(
                    " insert into descrip ( DocNumber , pnum , MedNumber ,  description1  ) values (" + D.getDoctorID()
                            + "," + D.getPatientID() + "," + D.getMedicationID() + ",'" + D.getDescription() + "');");

            connectDB();
            ExecuteStatement(
                    " insert into descrip ( DocNumber , pnum , MedNumber ,  description1  ) values (" + D.getDoctorID()
                            + "," + D.getPatientID() + "," + D.getMedicationID() + ",'" + D.getDescription() + "');");

            con.close();
            System.out.println("Connection closed" + datadescription.size());

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void getDataDescription() throws SQLException, ClassNotFoundException {
        String SQL;

        connectDB();
        System.out.println("Connection established");

        SQL = "select DocNumber , pnum , MedNumber , description1   from descrip order by DocNumber , pnum , MedNumber";
        Statement stmt = con.createStatement();
        ResultSet pa = stmt.executeQuery(SQL);

//		DocNumber int,
//		   pnum int ,
//		    MedNumber int ,
//		   description varchar(500),

        while (pa.next())
            datadescription.add(new description(Integer.parseInt(pa.getString(1)), Integer.parseInt(pa.getString(2)),
                    Integer.parseInt(pa.getString(3)), pa.getString(4)));

        pa.close();
        stmt.close();

        con.close();
        System.out.println("Connection closed" + datadescription.size());

    }

    public void AppTabel(Stage stage) {
        BorderPane bp = new BorderPane();

        TableView<Appointment> TAppintment = new TableView<>();
        TAppintment.setPrefSize(400, 400);
//			TAppintment.setTranslateX(500);
//			TAppintment.setTranslateY(80);
        TAppintment.setEditable(true);
        TableColumn<Appointment, Integer> id_Col = new TableColumn<Appointment, Integer>("Appointmeent id ");
        id_Col.setCellValueFactory(p -> new SimpleIntegerProperty(p.getValue().getAppNumber()).asObject());
        id_Col.setCellFactory(TextFieldTableCell.<Appointment, Integer>forTableColumn(new IntegerStringConverter()));
//			id_Col.setCellFactory(TextFieldTableCell.<Patient, Long>forTableColumn(new LongStringConverter())); // id not Edit
        id_Col.setOnEditCommit((CellEditEvent<Appointment, Integer> t) -> {
            ((Appointment) t.getTableView().getItems().get(t.getTablePosition().getRow()))
                    .setAppNumber(t.getNewValue());
        });
        id_Col.setPrefWidth(70);

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        TableColumn<Appointment, Integer> docid_Col = new TableColumn<Appointment, Integer>("ID Doctor");
        id_Col.setCellValueFactory(p -> new SimpleIntegerProperty(p.getValue().getDocNumber()).asObject());
        id_Col.setCellFactory(TextFieldTableCell.<Appointment, Integer>forTableColumn(new IntegerStringConverter()));
//			id_Col.setCellFactory(TextFieldTableCell.<Patient, Long>forTableColumn(new LongStringConverter())); // id not Edit
        id_Col.setOnEditCommit((CellEditEvent<Appointment, Integer> t) -> {
            ((Appointment) t.getTableView().getItems().get(t.getTablePosition().getRow()))
                    .setDocNumber(t.getNewValue());
        });
        docid_Col.setPrefWidth(70);

        /////////////////////////////////////////////////////////////////////////////////////////////////
        TableColumn<Appointment, String> nextDate_col = new TableColumn<Appointment, String>("Next Date ");
        nextDate_col.setCellValueFactory(p -> new SimpleStringProperty(p.getValue().getNext_review()));
        nextDate_col.setCellFactory(TextFieldTableCell.<Appointment>forTableColumn());
//			id_Col.setCellFactory(TextFieldTableCell.<Patient, Long>forTableColumn(new LongStringConverter())); // id not Edit
        nextDate_col.setOnEditCommit((CellEditEvent<Appointment, String> t) -> {
            ((Appointment) t.getTableView().getItems().get(t.getTablePosition().getRow()))
                    .setNext_review(t.getNewValue());
        });
        nextDate_col.setPrefWidth(70);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        TableColumn<Appointment, String> firstDate_col = new TableColumn<Appointment, String>("first reviw Date ");
        nextDate_col.setCellValueFactory(p -> new SimpleStringProperty(p.getValue().getDtae_of_firstRev()));
        nextDate_col.setCellFactory(TextFieldTableCell.<Appointment>forTableColumn());
//			id_Col.setCellFactory(TextFieldTableCell.<Patient, Long>forTableColumn(new LongStringConverter())); // id not Edit
        firstDate_col.setOnEditCommit((CellEditEvent<Appointment, String> t) -> {
            ((Appointment) t.getTableView().getItems().get(t.getTablePosition().getRow()))
                    .setDtae_of_firstRev(t.getNewValue());
        });
        nextDate_col.setPrefWidth(70);
        TAppintment.getColumns().addAll(id_Col, docid_Col, nextDate_col, firstDate_col);

        TAppintment.setItems(dataListApointment);

        /////////////////////////////////////////////////////////////////////////////////////////////////////

        ImageView addIm = new ImageView("https://cdn-icons-png.flaticon.com/512/863/863782.png");
        addIm.setFitWidth(40);
        addIm.setFitHeight(40);
        Button addB = new Button(" ADD Appointment ", addIm);
        addB.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 25));
//			addB.setTranslateX(100);
//			addB.setTranslateY(440);
        addB.setPrefSize(300, 50);
        addB.setStyle("-fx-border-color:green");

        ImageView dAllIm = new ImageView("https://cdn-icons-png.flaticon.com/512/3496/3496416.png");
        dAllIm.setFitWidth(40);
        dAllIm.setFitHeight(40);
        Button dAll = new Button(" Delete All ", dAllIm);
        dAll.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 25));
//			dAll.setTranslateX(900);
//			dAll.setTranslateY(590);
        dAll.setPrefSize(300, 50);
        dAll.setStyle("-fx-border-color:green");

        ImageView delSelctedIm = new ImageView("https://cdn-icons-png.flaticon.com/512/1251/1251555.png");
        delSelctedIm.setFitWidth(40);
        delSelctedIm.setFitHeight(40);
        Button delSelcted = new Button(" Delete Selected ", delSelctedIm);
        delSelcted.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 25));
//			delSelcted.setTranslateX(600);
//			delSelcted.setTranslateY(690);
        delSelcted.setPrefSize(300, 50);
        delSelcted.setStyle("-fx-border-color:green");
        Button update = new Button(" Update next reviw  ");
        update.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 25));
//			update.setTranslateX(750);
//			update.setTranslateY(850);
        update.setPrefSize(300, 50);
        update.setStyle("-fx-border-color:green");

        ImageView backIm = new ImageView("https://cdn-icons-png.flaticon.com/512/3368/3368865.png");
        backIm.setFitWidth(40);
        backIm.setFitHeight(40);
        Button back = new Button(" Back  ", backIm);
        back.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 25));
//			back.setTranslateX(750);
//			back.setTranslateY(850);
        back.setPrefSize(300, 50);
        back.setStyle("-fx-border-color:green");

        Label lID = new Label(" Appointment ID : ");
        lID.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));
//			lID.setPrefWidth(100);
//			lID.setTranslateY(180);
//			lID.setTranslateX(95);
        TextField tID = new TextField();
        Label dlID = new Label(" Doctor ID : ");
        dlID.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));
//			dlID.setPrefWidth(100);
//			dlID.setTranslateY(180);
//			dlID.setTranslateX(95);
        TextField dtID = new TextField();

        Label nextrev = new Label("Next reviw Date : ");
        nextrev.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));
//			nextrev.setPrefWidth(100);
//			nextrev.setTranslateY(180);
//			nextrev.setTranslateX(95);
        TextField tnextrev = new TextField();

        Label firstrev = new Label("First reviw Date : ");
        firstrev.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));
//			firstrev.setPrefWidth(100);
//			firstrev.setTranslateY(180);
//			firstrev.setTranslateX(95);

        TextField tfirstrev = new TextField();
        VBox v1 = new VBox();
        v1.setSpacing(30);

        VBox v2 = new VBox();
        v2.setSpacing(30);

        HBox hb1 = new HBox();

        v1.getChildren().addAll(lID, dlID, nextrev, firstrev);
        HBox hb2 = new HBox();
        HBox hb3 = new HBox();
        hb2.setSpacing(30);
        v2.getChildren().addAll(tID, dtID, tnextrev, tfirstrev);
        hb1.getChildren().addAll(v1, v2);
        hb1.setSpacing(60);
        // HBox hb3 = new HBox();
        hb2.getChildren().addAll(addB, dAll);
        hb3.getChildren().addAll(delSelcted, back);
        hb3.setSpacing(30);

        VBox v4 = new VBox();
        v4.getChildren().addAll(hb2, hb3);
        VBox v3 = new VBox();
        v3.setSpacing(30);
        v3.getChildren().addAll(hb1, hb2, v4);

//
        addB.setOnAction((ActionEvent e) -> {
            Appointment p;

            String id = tID.getText();
            String docid = dtID.getText();
            String nextreviw = tnextrev.getText();
            String firstreviw = tfirstrev.getText();

            if (!id.equals("") && !docid.equals("") && !nextreviw.equals("") && !firstreviw.equals("")) {

                p = new Appointment(Integer.parseInt(id), firstreviw, nextreviw, Integer.parseInt(docid));

                dataListApointment.add(p);
                insertDataApoinntment(p);

                // labelTotalUsers.setText("Total Users: " + TAppintment.getItems().size());
                tID.setText("");
                dtID.setText("");
                tnextrev.setText("");
                tfirstrev.setText("");

            }

        });

        dAll.setOnAction(e -> {
            TAppintment.getItems().clear();
            // labelTotalUsers.setText("Total Users: " + TAppintment.getItems().size());

        });

        delSelcted.setOnAction((ActionEvent e) -> {

            ObservableList<Appointment> selectedRows = TAppintment.getSelectionModel().getSelectedItems();
            ArrayList<Appointment> rows = new ArrayList<>(selectedRows);
            rows.forEach(row -> {
                TAppintment.getItems().remove(row);
                deleteRowAppointment(row);
                TAppintment.refresh();
            });
        });

        back.setOnAction(e -> {
            try {
                // list(stage);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

        bp.setLeft(v3);
        bp.setRight(TAppintment);

        bp.setStyle("-fx-background-color: white;");
        Scene scene = new Scene(bp, 1370, 700);
        stage.setScene(scene);
        stage.show();

    }

    private void deleteRowAppointment(Appointment row) {
        try {
            System.out.println("delete from  appointment where PID=" + row.getAppNumber() + ";");
            connectDB();
            ExecuteStatement("delete from  appointmen where PID=" + row.getAppNumber() + ";");
            con.close();
            System.out.println("Connection closed");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void getDataAppointmentt() throws SQLException, ClassNotFoundException {
        String SQL;

        connectDB();
        System.out.println("Connection established");

        SQL = "select AppNumber , next_review , dtae_of_firstRev ,  DocNumber from Appointments order by AppNumber";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(SQL);

        while (rs.next())
            dataApointment.add(new Appointment(Integer.parseInt(rs.getString(1)), rs.getString(2), rs.getString(3),
                    Integer.parseInt(rs.getString(4))));

        rs.close();
        stmt.close();

        con.close();
        System.out.println("Connection closed" + dataApointment.size());

    }

    private void insertDataApoinntment(Appointment rc) {

        try {
            System.out.println(
                    "Insert into Appointments ( AppNumber, next_review,  dtae_of_firstRev ,  DocNumber ) values" + "("
                            + rc.getAppNumber() + "," + "'" + rc.getNext_review() + "'" + "," + "'"
                            + rc.getDtae_of_firstRev() + "'" + "," + rc.getDocNumber() + ")" + ";");

            connectDB();
            ExecuteStatement(
                    "Insert into Appointments ( AppNumber, next_review,  dtae_of_firstRev ,  DocNumber ) values("
                            + rc.getAppNumber() + "," + "'" + rc.getNext_review() + "'" + "," + "'"
                            + rc.getDtae_of_firstRev() + "'" + "," + rc.getDocNumber() + ")" + ";");

            con.close();
            System.out.println("Connection closed" + dataApointment.size());

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void MedicationTabl(Stage stage) {

        BorderPane b = new BorderPane();

        HBox h = new HBox();

        TableView<medication> Tablemedication = new TableView<>();
//			Tablemedication.setPrefSize(300, 100);
//			Tablemedication.setPrefHeight(100);
//			Tablemedication.setPrefWidth(20);
//			Tablemedication.setTranslateX(1);
//			Tablemedication.setTranslateY(100);
        Tablemedication.setMaxHeight(400);
        Tablemedication.setMaxWidth(600);

        TableColumn<medication, Integer> id_Col = new TableColumn<medication, Integer>("Number Medication");
        id_Col.setMinWidth(40);
        id_Col.setCellValueFactory(p -> new SimpleIntegerProperty(p.getValue().getNumberMedication()).asObject());
        id_Col.setCellFactory(TextFieldTableCell.<medication, Integer>forTableColumn(new IntegerStringConverter()));

        id_Col.setOnEditCommit((CellEditEvent<medication, Integer> t) -> {
            ((medication) t.getTableView().getItems().get(t.getTablePosition().getRow()))
                    .setNumberMedication(t.getNewValue());
        });

        TableColumn<medication, String> name_Col = new TableColumn<medication, String>(" Name Medication");
        name_Col.setPrefWidth(150);
        name_Col.setCellValueFactory(p -> new SimpleStringProperty(p.getValue().getNameMedication()));
        name_Col.setCellFactory(TextFieldTableCell.<medication>forTableColumn());

        name_Col.setOnEditCommit((CellEditEvent<medication, String> t) -> {
            ((medication) t.getTableView().getItems().get(t.getTablePosition().getRow()))
                    .setNameMedication(t.getNewValue());

        });

        Tablemedication.getColumns().addAll(id_Col, name_Col);
        Tablemedication.setItems(dataListMedication);

        Tablemedication.setEditable(true);

        ImageView addIm = new ImageView("https://cdn-icons-png.flaticon.com/512/863/863782.png");
        addIm.setFitWidth(40);
        addIm.setFitHeight(40);
        Button addB = new Button(" ADD Medication ", addIm);
        addB.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 25));
//			addB.setTranslateX(100);
//			addB.setTranslateY(-490);
        addB.setPrefSize(250, 50);
        addB.setStyle("-fx-border-color:green");

        ImageView dAllIm = new ImageView("https://cdn-icons-png.flaticon.com/512/3496/3496416.png");
        dAllIm.setFitWidth(40);
        dAllIm.setFitHeight(40);
        Button dAll = new Button(" Delete All ", dAllIm);
        dAll.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 25));
//			dAll.setTranslateX(900);
//			dAll.setTranslateY(-590);
        dAll.setPrefSize(250, 50);
        dAll.setStyle("-fx-border-color:green");

        ImageView delSelctedIm = new ImageView("https://cdn-icons-png.flaticon.com/512/1251/1251555.png");
        delSelctedIm.setFitWidth(40);
        delSelctedIm.setFitHeight(40);
        Button delSelcted = new Button(" Delete Selected ", delSelctedIm);
        delSelcted.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 25));
//			delSelcted.setTranslateX(600);
//			delSelcted.setTranslateY(-690);
        delSelcted.setPrefSize(250, 50);
        delSelcted.setStyle("-fx-border-color:green");

        ImageView backIm = new ImageView("https://cdn-icons-png.flaticon.com/512/3368/3368865.png");
        backIm.setFitWidth(40);
        backIm.setFitHeight(40);
        Button back = new Button(" Back  ", backIm);
        back.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 25));
//			back.setTranslateX(750);
//			back.setTranslateY(-850);
        back.setPrefSize(250, 50);
        back.setStyle("-fx-border-color:green");

        Label lID = new Label(" Number Medication: ");
        lID.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));
        lID.setPrefWidth(100);
//			lID.setTranslateY(180);
//			lID.setTranslateX(95);
        TextField tID = new TextField();
        tID.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));
//			tID.setTranslateX(200);
//			tID.setTranslateY(100);
        tID.setPrefWidth(250);
        tID.setStyle("-fx-border-color:green");

        Label lName = new Label("Name Medication: ");
        lName.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));
        lName.setPrefWidth(100);
//			lName.setTranslateY(80);
//			lName.setTranslateX(90);
        TextField tNAme = new TextField();
        tNAme.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));
//			tNAme.setTranslateX(200);
//			tNAme.setTranslateY(0);
        tNAme.setPrefWidth(250);
        tNAme.setStyle("-fx-border-color:green");

//	        Label lWorkDays = new Label("Works Days : ");
//	        lWorkDays.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));
//	        lWorkDays.setPrefWidth(100);
////			lWorkDays.setTranslateY(-20);
////			lWorkDays.setTranslateX(90);
//	        TextField tWorkDays = new TextField();
//	        tWorkDays.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));
////			tWorkDays.setTranslateX(200);
////			tWorkDays.setTranslateY(-100);
//	        tWorkDays.setPrefWidth(250);
//	        tWorkDays.setStyle("-fx-border-color:green");

//			v.setSpacing(41);
//			v.getChildren().addAll(lID, tID, lName, tNAme,  addB, delSelcted, back);
//			v.setAlignment(Pos.CENTER);
        //
//			b.setCenter(v);

        addB.setOnAction(e -> {
            medication M;
            String id = tID.getText();
            String name = tNAme.getText();

            if (!id.equals("") && !name.equals("")) {
                M = new medication(Integer.parseInt(id), name);

                dataListMedication.add(M);
                insertDataMedication(M);

                tID.setText("");
                tNAme.setText("");

            }

        });
        dAll.setOnAction(e -> {
            Tablemedication.getItems().clear();
        });
        delSelcted.setOnAction(e -> {
            ObservableList<medication> selectedRows = Tablemedication.getSelectionModel().getSelectedItems();
            ArrayList<medication> rows = new ArrayList<>(selectedRows);
            rows.forEach(row -> {
                Tablemedication.getItems().remove(row);
                deleteRowinMedication(row);
                Tablemedication.refresh();
            });
        });
        back.setOnAction(e -> {
            try {
                list(stage);
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        });

        GridPane g = new GridPane();
        g.setAlignment(Pos.CENTER_LEFT);
        g.add(lID, 0, 0);
        g.add(tID, 1, 0);
        g.add(lName, 0, 1);
        g.add(tNAme, 1, 1);

        g.setAlignment(Pos.CENTER_LEFT);

        h.getChildren().addAll(addB, delSelcted, dAll, back);
        h.setSpacing(10);
        h.setAlignment(Pos.BOTTOM_CENTER);

        b.setCenter(Tablemedication);
        BorderPane.setAlignment(Tablemedication, Pos.CENTER);

        b.setLeft(g);
        BorderPane.setAlignment(g, Pos.CENTER_LEFT);

        b.setBottom(h);
        BorderPane.setAlignment(h, Pos.BOTTOM_CENTER);

        b.setStyle("-fx-background-color: white;");
        Scene scene = new Scene(b, 1370, 700);
        stage.setScene(scene);
        stage.show();

    }

    private void getDataMedication() throws SQLException, ClassNotFoundException {
        String SQL;

        connectDB();
        System.out.println("Connection established");

        SQL = "select MedNumber , MedName   from medication order by MedNumber";
        Statement stmt = con.createStatement();
        ResultSet pa = stmt.executeQuery(SQL);

        while (pa.next())
            dataMedication.add(new medication(Integer.parseInt(pa.getString(1)), pa.getString(2)));

        pa.close();
        stmt.close();

        con.close();
        System.out.println("Connection closed" + dataMedication.size());

    }

    private void insertDataMedication(medication M) {

        try {
            System.out.println("insert into medication (MedNumber,MedName) values (" + M.getNumberMedication() + ",'"
                    + M.getNameMedication() + "');");

            connectDB();
            ExecuteStatement("insert into medication (MedNumber,MedName) values (" + M.getNumberMedication() + ",'"
                    + M.getNameMedication() + "');");

            con.close();
            System.out.println("Connection closed" + dataMedication.size());

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void deleteRowinMedication(medication M) {
        try {
            System.out.println("delete from  medication where MedNumber=" + M.getNumberMedication() + ";");
            connectDB();
            ExecuteStatement("delete from  medication where MedNumber=" + M.getNumberMedication() + ";");
            con.close();
            System.out.println("Connection closed");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}

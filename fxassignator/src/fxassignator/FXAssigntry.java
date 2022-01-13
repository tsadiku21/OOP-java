package fxassignator;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import javax.swing.JOptionPane;

public class FXAssigntry extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        /////////////////////////////////////
        TableView table = new TableView<Table1>();

        //table.setStyle("Color:Black");
//        TableColumn sidColumn = new TableColumn<Table1, Integer>("SID");
//        sidColumn.setCellValueFactory(new PropertyValueFactory<Table1, Integer>("SID"));
//        sidColumn.setMinWidth(100);
//        TableColumn studidColumn = new TableColumn<Table1, String>("STUDID");
//        studidColumn.setCellValueFactory(new PropertyValueFactory<Table1, String>("STUDID"));
//        studidColumn.setMinWidth(100);
//        TableColumn fnameColumn = new TableColumn<Table1, String>("FIRSTNAME");
//        fnameColumn.setCellValueFactory(new PropertyValueFactory<Table1, String>("FIRSTNAME"));
//        fnameColumn.setMinWidth(150);
//        TableColumn lnameColumn = new TableColumn<Table1, String>("LASTNAME");
//        lnameColumn.setCellValueFactory(new PropertyValueFactory<Table1, String>("LASTNAME"));
//        lnameColumn.setMinWidth(150);
//        TableColumn sectionColumn = new TableColumn<Table1, String>("SECTION");
//        sectionColumn.setCellValueFactory(new PropertyValueFactory<Table1, String>("SECTION"));
//        sectionColumn.setMinWidth(100);
//        TableColumn departmentColumn = new TableColumn<Table1, String>("DEPARTMENT");
//        departmentColumn.setCellValueFactory(new PropertyValueFactory<Table1, String>("DEPARTMENT"));
//        departmentColumn.setMinWidth(150);
//
//        table.getColumns().add(sidColumn);
//        table.getColumns().add(studidColumn);
//        table.getColumns().add(fnameColumn);
//        table.getColumns().add(lnameColumn);
//        table.getColumns().add(sectionColumn);
//        table.getColumns().add(departmentColumn);
//
//        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        ///////////////////////////////
        Label dsid = new Label("SID");
        Label dstdid = new Label("Studid");
        Label dfname = new Label("Firstname");
        Label dlname = new Label("Lastname");
        Label dsection = new Label("Section");
        Label ddept = new Label("Departement");

        TextField tsid = new TextField();
        TextField tstudid = new TextField();
        TextField tfname = new TextField();
        TextField tlname = new TextField();
        TextField tsection = new TextField();
        TextField tdept = new TextField();

        Button insert = new Button();
        insert.setText("Insert");

        Button update = new Button();
        update.setText("Update");

        Button select = new Button();
        select.setText("View");

        Button sselect = new Button();
        sselect.setText("spefic View");

        Button dd = new Button();
        dd.setText("Distinct Section");

        HBox hbox = new HBox(dsid, tsid);
        hbox.setSpacing(20);
        HBox hboxb = new HBox(insert, update, select, sselect, dd);
        hboxb.setSpacing(20);

        HBox hbox2 = new HBox(dstdid, tstudid);
        hbox2.setSpacing(20);

        HBox hbox3 = new HBox(dfname, tfname);
        hbox.setSpacing(20);

        HBox hbox4 = new HBox(dlname, tlname);
        hbox2.setSpacing(20);

        HBox hbox5 = new HBox(dsection, tsection);
        hbox.setSpacing(20);

        HBox hbox6 = new HBox(ddept, tdept);
        hbox2.setSpacing(20);
        HBox hbox7 = new HBox(table);
        VBox vb = new VBox();
        vb.setSpacing(20);

        vb.getChildren().addAll(hbox, hbox2, hbox3, hbox4, hbox5, hbox6, hboxb, hbox7);

        insert.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                DBConnection db = new DBConnection();
                Connection con = null;
                try {
                    con = db.connMethod();
                    if (con != null) {
                        // Alert a = new Alert(Alert.AlertType.INFORMATION);
                        // a.setContentText("you are connected sucssfuly");
                        // a.showAndWait();
                    } else {
                        Alert a = new Alert(Alert.AlertType.INFORMATION);
                        a.setContentText("you are not connected sucssfuly");
                        a.showAndWait();
                    }
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(FXAssigntry.class.getName()).log(Level.SEVERE, null, ex);
                }

                try {
                    //Connection conn= DriverManager.getConnection(db.con);
                    String id = tsid.getText();
                    String st_id = tstudid.getText();
                    String fn = tfname.getText();
                    String ln = tlname.getText();
                    String sec = tsection.getText();
                    String dep = tdept.getText();
                    String query = "insert into dept_tbl(SID,Studid,Firstname,Lastname,Section,Department) values('" + id + "','" + st_id + "','" + fn + "','" + ln + "','" + sec + "','" + dep + "')";
                    if (id.equals("") || st_id.equals("") || fn.equals("") || ln.equals("") || sec.equals("") || dep.equals("")) {
                        JOptionPane.showMessageDialog(null, "every field is required");
                        tsid.setText("");
                        tstudid.setText("");
                        tfname.setText("");
                        tlname.setText("");
                        tsection.setText("");
                        tdept.setText("");
                    } else {
                        PreparedStatement ps = con.prepareStatement(query);
                        JOptionPane.showMessageDialog(null, "inserted successfuly");
                        ps.execute();
                    }

                    // ps.setString(1, tsid.getText());
                    // ps.setString(2, tstudid.getText());
                    //ps.setString(3, tfname.getText());
                    //ps.setString(4, tlname.getText());
                    // ps.setString(5, tsection.getText());
                    //ps.setString(6, tdept.getText());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "insertion failed");

                }

            }
        });

        update.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                DBConnection db = new DBConnection();
                Connection con = null;
                //String statement;
                try {
                    /* 
                   
                    String value1=tsid.getText();
                    String value2=tstudid.getText();
                    String value3=tfname.getText();
                     String value7="Tsadiku";
                      String value4=tlname.getText(); 
                      String value5=tsection.getText();
                       String value6=tdept.getText();*/
                    con = db.connMethod();
                    String Aman = "Aman";
                    String Ts = "Tsadiku";
                    String sql = "UPDATE dept_tbl SET Firstname='" + Ts + "' WHERE Firstname='" + Aman + "'";

                    PreparedStatement statement = con.prepareStatement(sql);
//statement.execute();
//statement.setString(3, value7);
//statement.setString(2, "William Henry Bill Gates");
//statement.setString(3, "bill.gates@microsoft.com");
//statement.setString(4, "bill");

                    statement.executeUpdate();
                    JOptionPane.showMessageDialog(null, "An existing user was updated successfully!");
                    // Alert a = new Alert(Alert.AlertType.INFORMATION);
                    //    a.setContentText("you are Update sucssfuly");
                    //   a.showAndWait();
//if (rowsUpdated > 0) {

//}
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });
///////////////////////////////////

       dd.setOnAction(new EventHandler<ActionEvent>() {
            private ObservableList<ObservableList> data;

            //private TableView tbl;
            @Override
            public void handle(ActionEvent event) {

                DBConnection db = new DBConnection();
                Connection c;
                ResultSet rs;
                data = FXCollections.observableArrayList();
                try {

                    // table.setStyle("-fx-background-color:red; -fx-font-color:yellow ");
                    c = db.connMethod();
                    String SQL = "SELECT distinct Section from dept_tbl";
                    rs = c.createStatement().executeQuery(SQL);
                    for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                        final int j = i;
                        TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1));
                        col.setCellValueFactory((Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>) param -> new SimpleStringProperty(param.getValue().get(j).toString()));
                        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
                        col.setMinWidth(100);
                        table.getColumns().addAll(col);
                       // System.out.println("Column [" + i + "] ");

                    }

                    while (rs.next()) {
                        ObservableList<String> row = FXCollections.observableArrayList();
                        for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                            row.add(rs.getString(i));
                        }
                       // System.out.println("Row[1]added " + row);
                        data.add(row);

                    }

                    table.setItems(data);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Error ");
                }

            }
        });
        /////////////////////
         select.setOnAction(new EventHandler<ActionEvent>() {

            private ObservableList<ObservableList> data;
            //private TableView tbl;

            @Override
            public void handle(ActionEvent event) {

                DBConnection obj1;
                Connection c;
                ResultSet rs;
                data = FXCollections.observableArrayList();
                try {

                    table.setStyle("-fx-background-color:red; -fx-font-color:yellow ");

                    obj1 = new DBConnection();
                    c = obj1.connMethod();
                    String SQL = "SELECT * from dept_tbl";
                    rs = c.createStatement().executeQuery(SQL);
                    for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                        final int j = i;
                        TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1));
                        col.setCellValueFactory((Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>) param -> new SimpleStringProperty(param.getValue().get(j).toString()));

                        table.getColumns().addAll(col);
                        //System.out.println("Column [" + i + "] ");

                    }

                    while (rs.next()) {
                        ObservableList<String> row = FXCollections.observableArrayList();
                        for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                            row.add(rs.getString(i));

                        }
                        //System.out.println("Row[1]added " + row);
                        data.add(row);

                    }

                    table.setItems(data);

                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Error ");
                }
            }

        });
        ////////////////////////

       sselect.setOnAction(new EventHandler<ActionEvent>() {
            private ObservableList<ObservableList> data;

            //private TableView tbl;
            @Override
            public void handle(ActionEvent event) {

                DBConnection db = new DBConnection();
                Connection c;
                ResultSet rs;
                data = FXCollections.observableArrayList();
                try {

                    // table.setStyle("-fx-background-color:red; -fx-font-color:yellow ");
                    c = db.connMethod();
                    String SQL = "SELECT * FROM dept_tbl WHERE Firstname='Elias'AND Section='SecA'AND Department='CS'";
                    rs = c.createStatement().executeQuery(SQL);
                    for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                        final int j = i;
                        TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1));
                        col.setCellValueFactory((Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>) param -> new SimpleStringProperty(param.getValue().get(j).toString()));
                        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
                        col.setMinWidth(100);
                        table.getColumns().addAll(col);
                       // System.out.println("Column [" + i + "] ");

                    }

                    while (rs.next()) {
                        ObservableList<String> row = FXCollections.observableArrayList();
                        for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                            row.add(rs.getString(i));
                        }
                       // System.out.println("Row[1]added " + row);
                        data.add(row);

                    }

                    table.setItems(data);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Error ");
                }

            }
        });
///////////////////////////
//        sselect.setOnAction(new EventHandler<ActionEvent>() {
//private ObservableList<ObservableList> data;
//            @Override
//            public void handle(ActionEvent event) {
//                DBConnection db = new DBConnection();
//                ResultSet rs;
//                Connection con = null;
//                try {
////rs = c.createStatement().executeQuery(sql2);
//                    Statement stm;//= (Statement) con.createStatement();
//                    con = db.connMethod();
//                    String sql2 = "SELECT * FROM dept_tbl WHERE Firstname='Elias'AND Section='SecA'AND Department='CS'";
//                    rs = con.createStatement().executeQuery(sql2);
//                    // ResultSet rs2 = (ResultSet) stm.executeQuery(sql2);
//
//                    
//                   for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
//                        final int j = i;
//                        TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1));
//                        col.setCellValueFactory((Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>) param -> new SimpleStringProperty(param.getValue().get(j).toString()));
//
//                        table.getColumns().addAll(col);
//                        //System.out.println("Column [" + i + "] ");
//
//                    }
//
//                    while (rs.next()) {
//                        ObservableList<String> row = FXCollections.observableArrayList();
//                        for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
//                            row.add(rs.getString(i));
//
//                        }
//                        //System.out.println("Row[1]added " + row);
//                        data.add(row);
//
//                    }
//
//                    table.setItems(data);
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    System.out.println("Error ");
//                }
//            }
//
//        });

////////////////////////////////////
        Scene scene = new Scene(vb, 1000, 600);

        primaryStage.setTitle("Student Information");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

}

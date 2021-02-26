/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modul6_pbo;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author ASUS
 */
public class Modul6_PBO extends Application {
    
public String jK;
    
    @Override
    public void start(Stage primaryStage) {
        
        primaryStage.setTitle("JavaFX Welcome Back");
        
        primaryStage.setResizable(false);
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_LEFT);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(5, 5, 5, 5));
        
        Scene scene = new Scene(grid,350,300);
        primaryStage.setScene(scene);
        
        Text scenetitle = new Text("Isi Data Diri Anda");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        grid.add(scenetitle, 0, 0, 2, 1);
        
        Label nim = new Label("NIM: ");
        grid.add(nim, 0, 1);
        
        TextField nimText = new TextField();
        nimText.setPromptText("ex. 201810370311273");
        nimText.toString();
        grid.add(nimText, 1, 1);
        
        Label nama = new Label("Nama: ");
        grid.add(nama, 0, 2);
        
        TextField namaText = new TextField();
        namaText.setPromptText("ex. Wahyu Priyo Wicaksono");
        namaText.toString();
        grid.add(namaText, 1, 2);
        
        Label kelamin = new Label("Jenis Kelamin: ");
        grid.add(kelamin, 0, 3);
        
        RadioButton lk = new RadioButton("Laki-laki");
        RadioButton pr = new RadioButton("Perempuan");
        ToggleGroup jenis = new ToggleGroup();
        lk.setToggleGroup(jenis);
        pr.setToggleGroup(jenis);
        HBox hRadio = new HBox(20, lk, pr);
        grid.add(hRadio, 1, 3);
      
        Label alam = new Label("Alamat: ");
        grid.add(alam, 0, 5);
        
        TextArea mat = new TextArea();
        mat.toString();
        mat.setPromptText("ex. Perum. BCT");
        mat.setPrefHeight(75);
        mat.setPrefWidth(250);
        grid.add(mat, 1, 5);
        
        Button baru = new Button("New");
        HBox hBaru = new HBox(5);
        hBaru.setAlignment(Pos.BOTTOM_CENTER);
        hBaru.getChildren().add(baru);
        
        Button edit = new Button("Edit");
        HBox hEdit = new HBox(5);
        hEdit.setAlignment(Pos.BASELINE_CENTER);
        hEdit.getChildren().add(edit);
        
        Button del = new Button("Delete");
        HBox hbtn = new HBox(5);
        hbtn.setAlignment(Pos.BOTTOM_CENTER);
        hbtn.getChildren().add(del);

        HBox buttons2 = new HBox(20, baru, edit, del);
        grid.add(buttons2, 1, 6);
        
        jenis.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
            @Override
            public void changed(ObservableValue<? extends Toggle> ob, Toggle o, Toggle n){
                RadioButton rB = (RadioButton)jenis.getSelectedToggle();
                jK = rB.getText();
            }
        });
        
        baru.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if((nimText.getText() == null) ||
                        (namaText.getText() == null) ||
                        (jenis.getSelectedToggle() == null) ||
                        (mat.getText() == null)){
                    newStage nW = new newStage(nimText.getText(), namaText.getText(), "Jenis Kelamin Kosong", mat.getText()/*, fakultasText.getText()*/);
                }
                else{
                    newStage nW = new newStage(nimText.getText(), namaText.getText(), jK, mat.getText()/*, fakultasText.getText()*/);
                }
                nimText.setDisable(true);
                namaText.setDisable(true);
                lk.setDisable(true);
                pr.setDisable(true);
                mat.setDisable(true);
                //fakultasText.setDisable(true);
            }
        });
        
        edit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                nimText.setDisable(false);
                namaText.setDisable(false);
                lk.setDisable(false);
                pr.setDisable(false);
                mat.setDisable(false);
                //fakultasText.setDisable(false);
            }
        });
        
        del.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                nimText.setText("");
                namaText.setText("");
                lk.setSelected(false);
                pr.setSelected(false);
                mat.setText("");
                //fakultasText.setText("");
            }
        });
        
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
class newStage {
    public newStage(String nimText, String namaText, String jK, String matText/*,String fakultasText*/){
        GridPane gBaru = new GridPane();
        gBaru.setHgap(10);
        gBaru.setVgap(10);
        gBaru.setPadding(new Insets(10, 10, 10, 10));
        gBaru.setAlignment(Pos.CENTER);
        Scene s = new Scene(gBaru, 300,400);
        Stage sD = new Stage();
        sD.setResizable(false);
        sD.setTitle("Berhasil Daftar");
        sD.setScene(s);
        
        Text pesan = new Text("Data Diri");
        pesan.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        gBaru.add(pesan, 0, 0);
        
        Text nimB = new Text(nimText);
        gBaru.add(nimB, 0, 1);
        
        Text namaB = new Text(namaText);
        gBaru.add(namaB, 0, 2);
        
        Text kelaminB = new Text(jK);
        gBaru.add(kelaminB, 0, 3);
        
//        Text fakultasB = new Text(fakultasText);
//        gBaru.add(fakultasB, 0, 5);
        
        TextArea matB = new TextArea(matText);
        matB.setDisable(true);
        matB.setPrefHeight(75);
        matB.setPrefWidth(250);
        gBaru.add(matB, 0, 5);
        
        
        sD.show();
        
    }
}
}
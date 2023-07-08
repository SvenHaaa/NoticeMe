package com.noticeme.controller;

import com.noticeme.NoticeMeApplication;
import com.noticeme.common.DateTimeConverter;
import com.noticeme.common.Testdatagenerator;
import com.noticeme.db.NoteRepository;
import com.noticeme.model.Benachrichtigung;
import com.noticeme.model.Note;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    public static final String SELF_FXML = "Base.fxml";

    @FXML
    private TableView<Note> tvNotes;
    private Note auswahl;
    @FXML
    private TableColumn<Note, String> tiTitle;
    @FXML
    private TableColumn<Note, String> tiNote;
    @FXML
    private TableColumn<Note, String> tiDate;
    @FXML
    private TableColumn<Note, String> tiTime;
    @FXML
    private TableColumn<Note, String> tiWhere;
    @FXML
    private TableColumn<Benachrichtigung, String> tiNotify;
    @FXML
    private Button btnNeu;

    private boolean hasTestDaten;
    private NoteRepository noteRepository;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        hasTestDaten = false;
        noteRepository = new NoteRepository();
        initTabelle();
    }

    private void init() {
        //todo getDatabase contents
    }

    private void initTabelle() {
        initTabelleCellValues();
        initTabelleSelectionModel();
    }

    private void initTabelleCellValues() {
        tiTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        tiNote.setCellValueFactory(new PropertyValueFactory<>("notiz"));
        tiDate.setCellValueFactory(cell -> new SimpleObjectProperty<>(DateTimeConverter.getConverted(cell.getValue().getDate())));
        tiTime.setCellValueFactory(cell -> new SimpleObjectProperty<>(cell.getValue().getUhrzeit()));
        tiWhere.setCellValueFactory(new PropertyValueFactory<>("where"));
        tiNotify.setCellValueFactory(cell -> {
            String notifyCellOutput = "nein";
            //ignore warning to replace with nullcheck, invocation of instanceof is necessary here
            if (cell.getValue() instanceof Benachrichtigung) {
                Benachrichtigung benachrichtigung = (Benachrichtigung) cell.getValue();
                notifyCellOutput = DateTimeConverter.getConverted(benachrichtigung.getNotifyWhen());
            }
            return new SimpleObjectProperty<>(notifyCellOutput);
        });
    }

    private void initTabelleSelectionModel() {
        tvNotes.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (oldValue != newValue) {
                auswahl = newValue;
            }
        });
    }

    private Note createOrEditNote(Note note) {
        try {


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @FXML
    private void onNew(ActionEvent event) {
        auswahl = null;
        Note note = createOrEditNote(null);
        System.out.println("Would create now");
        //service.create
    }

    @FXML
    private void onEdit(ActionEvent event) {
        if (auswahl != null) {
            Note note = createOrEditNote(auswahl);
            saveData();
            System.out.println("Would update now");
            //service.update
        }
    }

    private void saveData() {
        //todo reimplement
//        SaveData data = new SaveData();
//        //    data.nList = tvNotes.getItems();
//        try {
//            ResourceManager.save(data, "1.save");
//        } catch (Exception e) {
//            System.out.println("speichern fehlgeschlagen");
//        }
    }

    private void loadData() {
        //todo reimplement
//        try {
//            SaveData data = (SaveData) ResourceManager.load("1.save");
//            //          tvNotes.getItems().clear();
//            //          tvNotes.getItems().addAll(data.nList);
//        } catch (Exception e) {
//            System.out.println("laden fehlgeschlagen");
//        }
    }

    @FXML
    private void onAbout(ActionEvent event) {
        try {
            Dialog<MoreController> dialog = new Dialog<>();
            FXMLLoader moreFXML = new FXMLLoader(NoticeMeApplication.class.getResource(MoreController.SELF_FXML));
            dialog.getDialogPane().setContent(moreFXML.load());
            dialog.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public void onInsertTestData(ActionEvent actionEvent) {
        if (!hasTestDaten) {
            tvNotes.getItems().addAll(Testdatagenerator.generateTestDaten());
            hasTestDaten = true;
        }

    }

    public void onDeleteTestdata(ActionEvent actionEvent) {
        if (hasTestDaten) {
            tvNotes.getItems().removeAll(Testdatagenerator.generateTestDaten());
            hasTestDaten = false;
        }
    }

    public void onRefresh(ActionEvent actionEvent) {
        tvNotes.getItems().clear();
        tvNotes.getItems().addAll(noteRepository.findAll());
    }
}
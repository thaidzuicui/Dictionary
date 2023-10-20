package graphic_version;

import cmd_version.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.web.WebView;
import javafx.util.Callback;

import java.io.IOException;

public class Controller {
    @FXML
    private TextField search;
    @FXML
    private ListView<String> output;
    private ObservableList<String> allWords;
    private FilteredList<String> filteredWords;

    public Controller() throws IOException {
        allWords = FXCollections.observableArrayList();
        DictionaryManagement.insertFromFile();
        for (Word word : Dictionary.dic.words) {
            allWords.add(word.getWord_target());
        }

        filteredWords = new FilteredList<>(allWords);
    }

    @FXML
    public void search(ActionEvent e) {
        String searchedWord = search.getText().toLowerCase();
        if (!searchedWord.isEmpty()) {
            filteredWords.setPredicate(word -> word.toLowerCase().contains(searchedWord));
        }
    }


    @FXML
    private TextArea display;

    @FXML
    public void displayDefinition(MouseEvent e) { // show definition of selected word
        String selectedWord = output.getSelectionModel().getSelectedItem();
        if (selectedWord != null) {
            String definition = Dictionary.dic.findWord(selectedWord).getWord_explain();
            display.setText(definition);
        }
    }

    public void initialize() {
        // custom listview
        Callback<ListView<String>, ListCell<String>> cellFactory = param -> new ListCell<String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(item);
                    setFont(Font.font(18)); // Set the font size here
                }
            }
        };
        output.setCellFactory(cellFactory);


        // search
        output.setItems(filteredWords);
        search.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredWords.setPredicate(word -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();
                return word.toLowerCase().contains(lowerCaseFilter);
            });
        });

        // displayDefinition
        output.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue != null) {
                    // Display the definition in the TextArea
                    String definition = Dictionary.dic.findWord(newValue).getWord_explain();
                    display.setText(definition);
                }
            }
        });

        tt() ;
    }

    @FXML
    private WebView test;
    public void tt()
    {
        String htmlContent = "" ;

        // Load HTML content into the WebView
        test.getEngine().loadContent(htmlContent);
    }
}

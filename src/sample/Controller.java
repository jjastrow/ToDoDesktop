package sample;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.FocusModel;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    // need place to store ToDo items
    ObservableList<ToDoItem> items = FXCollections.observableArrayList();

    @FXML
    ListView list;

    @FXML
    TextField text;

    public void addItem() {
        ToDoItem newItem = new ToDoItem(text.getText());
        items.add(newItem);
        text.setText("");
    }
    public void removeItem(){
        ToDoItem item = (ToDoItem) list.getSelectionModel().getSelectedItem();
        items.remove(item);
    }
    public void toggleItem(){
        ToDoItem item = (ToDoItem) list.getSelectionModel().getSelectedItem();
        if (item != null) {
            item.isDone = ! item.isDone;
            list.setItems(null);
            list.setItems(items);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        list.setItems(items);
    }
}

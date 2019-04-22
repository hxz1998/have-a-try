package controller.util;

import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class WebViewPane extends Pane {

    public WebViewPane(String url) {
        VBox.setVgrow(this, Priority.ALWAYS);
        setMaxWidth(Double.MAX_VALUE);
        setMaxHeight(Double.MAX_VALUE);

        WebView view = new WebView();
        view.setMinSize(500, 400);
        view.setPrefSize(500, 400);
        final WebEngine eng = view.getEngine();
        eng.load(url);
    }
}

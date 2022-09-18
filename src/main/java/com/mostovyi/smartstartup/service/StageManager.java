package com.mostovyi.smartstartup.service;

import com.mostovyi.smartstartup.constant.FxmlView;
import com.mostovyi.smartstartup.controller.BaseController;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;

import java.util.Objects;

public class StageManager {

    private final Stage primaryStage;
    private final FxWeaver fxWeaver;

    public StageManager(FxWeaver fxWeaver, Stage primaryStage) {
        this.fxWeaver = fxWeaver;
        this.primaryStage = primaryStage;
    }

    public void switchScene(FxmlView fxmlView) {
        var controllerAndView = fxWeaver.load(fxmlView.getController());
        Parent root = (Parent) controllerAndView.getView().orElse(null);
        Scene scene = prepareScene(root);
        primaryStage.setScene(scene);

        BaseController controller = controllerAndView.getController();
        controller.postInitialize();
    }

    private Scene prepareScene(Parent root) {
        Scene scene = primaryStage.getScene();
        if (Objects.isNull(scene)) {
            return new Scene(root);
        }
        scene.setRoot(root);
        return scene;
    }

    public Scene getScene() {
        return primaryStage.getScene();
    }

}

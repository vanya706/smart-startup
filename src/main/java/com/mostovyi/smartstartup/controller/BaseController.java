package com.mostovyi.smartstartup.controller;

import com.mostovyi.smartstartup.domain.Settings;
import com.mostovyi.smartstartup.repository.SettingsRepository;
import com.mostovyi.smartstartup.service.StageManager;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.CheckMenuItem;
import org.apache.commons.lang3.BooleanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

public abstract class BaseController {

    private static final String DARK_THEME_RESOURCE_PATH = "com/mostovyi/smartstartup/controller/styles-dark-theme.css";

    @FXML
    private CheckMenuItem useDarkThemeCheckMenuItem;

    @Autowired
    private SettingsRepository settingsRepository;
    @Lazy
    @Autowired
    protected StageManager stageManager;

    abstract public void initialize();

    public void postInitialize() {
        Settings settings = settingsRepository.findAll()
                .stream()
                .findFirst()
                .orElseGet(Settings::new);

        useDarkThemeCheckMenuItem.selectedProperty()
                .addListener((observable, wasSelected, isSelected) -> {
                    ObservableList<String> stylesheets = stageManager.getScene().getStylesheets();
                    settings.setUseDarkTheme(isSelected);
                    settingsRepository.save(settings);
                    if (isSelected) {
                        stylesheets.add(DARK_THEME_RESOURCE_PATH);
                        return;
                    }
                    stylesheets.remove(DARK_THEME_RESOURCE_PATH);
                });
        useDarkThemeCheckMenuItem.setSelected(BooleanUtils.isTrue(settings.getUseDarkTheme()));
    }

}

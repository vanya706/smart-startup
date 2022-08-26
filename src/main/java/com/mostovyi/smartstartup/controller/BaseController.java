package com.mostovyi.smartstartup.controller;

import com.mostovyi.smartstartup.service.StageManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

public class BaseController {

    @Lazy
    @Autowired
    protected StageManager stageManager;

}

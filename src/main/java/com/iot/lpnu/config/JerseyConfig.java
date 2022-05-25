package com.iot.lpnu.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.iot.lpnu.controller.ToolController;

@Component
public class JerseyConfig extends ResourceConfig{
    public JerseyConfig(Class<?>... classes) {
        register(ToolController.class);
    }
}

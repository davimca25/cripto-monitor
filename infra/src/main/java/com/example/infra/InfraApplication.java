package com.example.infra;

import software.amazon.awscdk.App;
import software.amazon.awscdk.Stack;

public class InfraApplication {

    public static void main(String[] args) {
        App app = new App();
        new Stack(app, "CriptoMonitorStack");
        app.synth();
    }

}

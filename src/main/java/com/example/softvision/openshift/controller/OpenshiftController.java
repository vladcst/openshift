package com.example.softvision.openshift.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/openshift")
public class OpenshiftController {

    private String version;

    public OpenshiftController(@Value("${openshift.version}") final String version){
        this.version = version;
    }

    @GetMapping("/version")
    public ResponseEntity<String> getVersionWithGreeting(final String greeting) {
        log.info("getVersion() started with greeting: " + greeting);
        return new ResponseEntity<>(greeting + " : with version: " + version, HttpStatus.OK);
    }

}
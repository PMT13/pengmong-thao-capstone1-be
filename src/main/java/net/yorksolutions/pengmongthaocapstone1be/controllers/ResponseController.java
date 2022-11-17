package net.yorksolutions.pengmongthaocapstone1be.controllers;

import net.yorksolutions.pengmongthaocapstone1be.services.ResponseService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/response")
@CrossOrigin
public class ResponseController {
    ResponseService service;

    public ResponseController(ResponseService service) {
        this.service = service;
    }
}

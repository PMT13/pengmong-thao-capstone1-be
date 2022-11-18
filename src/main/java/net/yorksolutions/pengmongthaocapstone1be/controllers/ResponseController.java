package net.yorksolutions.pengmongthaocapstone1be.controllers;

import net.yorksolutions.pengmongthaocapstone1be.dto.AddResponseDTO;
import net.yorksolutions.pengmongthaocapstone1be.models.Response;
import net.yorksolutions.pengmongthaocapstone1be.models.SurveyResponses;
import net.yorksolutions.pengmongthaocapstone1be.services.ResponseService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/response")
@CrossOrigin
public class ResponseController {
    ResponseService service;

    public ResponseController(ResponseService service) {
        this.service = service;
    }

    @PostMapping("/{id}")
    public Iterable<SurveyResponses> addResponse(@RequestBody AddResponseDTO request, @PathVariable Long id){
        return this.service.addResponse(request, id);
    }
    @PutMapping
    public Iterable<SurveyResponses> updateResponse(@RequestBody Response request){
       return this.service.updateResponse(request);
    }
}

package net.yorksolutions.pengmongthaocapstone1be.services;

import net.yorksolutions.pengmongthaocapstone1be.repositories.ResponseRepository;
import org.springframework.stereotype.Service;

@Service
public class ResponseService {

    ResponseRepository repo;

    public ResponseService(ResponseRepository repo) {
        this.repo = repo;
    }
}

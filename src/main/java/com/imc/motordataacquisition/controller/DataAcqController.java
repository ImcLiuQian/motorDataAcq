package com.imc.motordataacquisition.controller;

import com.imc.motordataacquisition.service.dataAcq.AcqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/motorDataAcq")
public class DataAcqController {
    @Autowired
    private AcqService acqService;

    @GetMapping("/start")
    public ResponseEntity start() {
        acqService.startAcq();
        return ResponseEntity.ok("started");
    }

    @GetMapping("/stop")
    public ResponseEntity stop() {
        acqService.stopAcq();
        return ResponseEntity.ok("stopped");
    }
}

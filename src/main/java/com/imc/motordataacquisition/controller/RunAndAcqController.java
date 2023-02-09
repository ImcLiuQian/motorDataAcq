package com.imc.motordataacquisition.controller;

import com.imc.motordataacquisition.service.dataAcq.AcqService;
import com.imc.motordataacquisition.service.paraAndState.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/run")
public class RunAndAcqController {
    @Autowired
    private AcqService acqService;

    @Autowired
    private StateService stateService;

    @GetMapping("/start")
    public ResponseEntity start() {
        acqService.startAcq();
        stateService.changeToOp();
        return ResponseEntity.ok("started");
    }

    @GetMapping("/stop")
    public ResponseEntity stop() {
        acqService.stopAcq();
        stateService.changeToPoweredLock();
        return ResponseEntity.ok("stopped");
    }
}

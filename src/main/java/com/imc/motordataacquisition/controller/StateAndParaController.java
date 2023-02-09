package com.imc.motordataacquisition.controller;

import com.imc.motordataacquisition.service.paraAndState.ParaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@RequestMapping("/motorStateAndPara")
@Slf4j
public class StateAndParaController {
    @Autowired
    private ParaService paraService;

    @PutMapping("/ctrlCode/{controlCode}")
    public ResponseEntity setControlCode(@PathVariable Short controlCode) throws IOException {
        log.info("controlCode: " + controlCode);
        paraService.setControlCode(controlCode);
        return ResponseEntity.ok("controlCode set success");
    }

    @PutMapping("/mode/{mode}")
    public ResponseEntity setModeCode(@PathVariable Short mode) throws IOException {
        log.info("modeCode: " + mode);
        paraService.setModeCode(mode);
        return ResponseEntity.ok("modeCode set success");
    }

    @PutMapping("/vel/{velocity}")
    public ResponseEntity setVelocity(@PathVariable Short velocity) throws IOException {
        paraService.setVelocity(velocity);
        return ResponseEntity.ok("velocity set success");
    }

    @PutMapping("/pos/{position}")
    public ResponseEntity setPosition(@PathVariable Short position) throws IOException {
        paraService.setPosition(position);
        return ResponseEntity.ok("position set success");
    }

    @PutMapping("/iq/{currentIq}")
    public ResponseEntity setCurrentIq(@PathVariable short currentIq) throws IOException {
        paraService.setCurrentIq(currentIq);
        return ResponseEntity.ok("currentIq set success");
    }

    @PutMapping("/id/{currentId}")
    public ResponseEntity setCurrentId(@PathVariable short currentId) throws IOException {
        paraService.setCurrentId(currentId);
        return ResponseEntity.ok("currentId set success");
    }

    @PutMapping("/velkp/{speedRingKp}")
    public ResponseEntity setSpeedRingKp(@PathVariable short speedRingKp) throws IOException {
        paraService.setSpeedRingKp(speedRingKp);
        return ResponseEntity.ok("speedRingKp set success");
    }

    @PutMapping("/velki/{speedRingKi}")
    public ResponseEntity setSpeedRingKi(@PathVariable short speedRingKi) throws IOException {
        paraService.setSpeedRingKi(speedRingKi);
        return ResponseEntity.ok("speedRingKi set success");
    }

    @PutMapping("poskp/{positionRingKp}")
    public ResponseEntity setPositionRingKp(@PathVariable short positionRingKp) throws IOException {
        paraService.setPositionRingKp(positionRingKp);
        return ResponseEntity.ok("positionRingKp set success");
    }

    @PutMapping("poskd/{positionRingKd}")
    public ResponseEntity setPositionRingKd(@PathVariable short positionRingKd) throws IOException {
        paraService.setPositionRingKd(positionRingKd);
        return ResponseEntity.ok("positionRingKd set success");
    }

    @PutMapping("curkp/{currentRingKp}")
    public ResponseEntity setCurrentRingKp(@PathVariable short currentRingKp) throws IOException {
        paraService.setCurrentRingKp(currentRingKp);
        return ResponseEntity.ok("currentRingKp set success");
    }

    @PutMapping("curki/{currentRingKi}")
    public ResponseEntity setCurrentRingKi(@PathVariable short currentRingKi) throws IOException {
        paraService.setCurrentRingKi(currentRingKi);
        return ResponseEntity.ok("currentRingKi set success");
    }
}

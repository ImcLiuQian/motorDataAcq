package com.imc.motordataacquisition.service.paraAndState;

import com.imc.motordataacquisition.entity.Motor;
import com.imc.motordataacquisition.service.udp.UdpServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ParaService {
    @Autowired
    UdpServer server;

    @Autowired
    private StateService stateService;

    public void setModeCode(Short modeCode)  {
        stateService.changeToPoweredLock();
        Motor motor = server.recvOne();
        motor.setModeCode(modeCode);
        motor.setControlCode((short) 0xff00);
        server.send(motor);
    }

    public void setControlCode(Short controlCode) {
        Motor motor = server.recvOne();
        motor.setControlCode(controlCode);
        server.send(motor);
    }

    public void setVelocity(Short velocity) {
        Motor motor = server.recvOne();
        motor.setReferenceMechanicalSpeed(velocity);
        motor.setControlCode((short) 0xff00);
        server.send(motor);
    }

    public void setPosition(Short position) {
        Motor motor = server.recvOne();
        motor.setReferenceMechanicalPosition(position);
        motor.setControlCode((short) 0xff00);
        server.send(motor);
    }

    public void setCurrentIq(short currentIq) {
        Motor motor = server.recvOne();
        motor.setReferenceCurrentIq(currentIq);
        motor.setControlCode((short) 0xff00);
        server.send(motor);
    }

    public void setCurrentId(short currentId) throws IOException {
        Motor motor = server.recvOne();
        motor.setReferenceCurrentId(currentId);
        motor.setControlCode((short) 0xff00);
        server.send(motor);
    }

    public void setSpeedRingKp(short speedRingKp) throws IOException {
        Motor motor = server.recvOne();
        motor.setSpeedRingKp(speedRingKp);
        motor.setControlCode((short) 0xff00);
        server.send(motor);
    }

    public void setSpeedRingKi(short speedRingKi) throws IOException {
        Motor motor = server.recvOne();
        motor.setSpeedRingKi(speedRingKi);
        motor.setControlCode((short) 0xff00);
        server.send(motor);
    }

    public void setPositionRingKp(short positionRingKp) throws IOException {
        Motor motor = server.recvOne();
        motor.setPositionRingKp(positionRingKp);
        motor.setControlCode((short) 0xff00);
        server.send(motor);
    }

    public void setPositionRingKd(short positionRingKd) throws IOException {
        Motor motor = server.recvOne();
        motor.setPositionRingKd(positionRingKd);
        motor.setControlCode((short) 0xff00);
        server.send(motor);
    }

    public void setCurrentRingKp(short currentRingKp) throws IOException {
        Motor motor = server.recvOne();
        motor.setCurrentRingKp(currentRingKp);
        motor.setControlCode((short) 0xff00);
        server.send(motor);
    }

    public void setCurrentRingKi(short currentRingKi) throws IOException {
        Motor motor = server.recvOne();
        motor.setCurrentRingKi(currentRingKi);
        motor.setControlCode((short) 0xff00);
        server.send(motor);
    }
}

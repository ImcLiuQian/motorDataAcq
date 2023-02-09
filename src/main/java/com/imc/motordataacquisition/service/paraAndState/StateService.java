package com.imc.motordataacquisition.service.paraAndState;

import com.imc.motordataacquisition.entity.Motor;
import com.imc.motordataacquisition.entity.State;
import com.imc.motordataacquisition.service.udp.UdpServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StateService {
    @Autowired
    UdpServer server;

    public void changeToPoweredLock() {
        Motor motor = server.recvOne();
        State state = getState(motor);
        while (state != State.powered_lock) {
            switch (state) {
                case server_op:
                case op:
                case error:
                    motor.setControlCode((short) 0x0100);
                    server.send(motor);
                    break;
            }
            motor = server.recvOne();
            state = getState(motor);
        }
    }

    public void changeToOp() {
        Motor motor = server.recvOne();
        State state = getState(motor);
        while (state != State.op) {
            switch (state) {
                case server_op:
                case error:
                    motor.setControlCode((short) 0x0100);
                    server.send(motor);
                    break;
                case powered_lock:
                    motor.setControlCode((short) 0x0200);
                    server.send(motor);
                    break;
            }
            motor = server.recvOne();
            state = getState(motor);
        }
    }

    public State getState(Motor motor) {
        Short statusCode = motor.getStatusCode();
        switch (statusCode) {
            case 0:
                return State.power;
            case 1:
                return State.init;
            case 2:
                return State.server_op;
            case 3:
                return State.powered_lock;
            case 4:
                return State.op;
            case 255:
                return State.error;
            default:
                return State.unknownState;
        }
    }
}

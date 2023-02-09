package com.imc.motordataacquisition.service.udp;

import com.imc.motordataacquisition.entity.Motor;
import com.imc.motordataacquisition.properties.UdpProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.*;

@Component
@DependsOn("UdpProperties")
public class UdpServer {

    static Integer LOCAL_PORT = 8080;
    static String LOCAL_IP = "192.168.0.3";
    static Integer DES_PORT = 8080;
    static String DES_IP = "192.168.0.2";
    private DatagramSocket socket;
    private byte[] tempData = new byte[64];


    //每次缓存1s的电机数据
    @Setter
    @Getter
    byte[][] currData = new byte[UdpProperties.RATE][64];
    //用于读取电机的packet
    DatagramPacket packet = new DatagramPacket(currData[0], 64);

    {
        try {
            socket = new DatagramSocket(LOCAL_PORT, InetAddress.getByName(LOCAL_IP));
        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }

    public void send(Motor motor) {
        try {
            InetAddress desIP = InetAddress.getByName(DES_IP);
            byte[] data = motor.getBytes();//1.将接收到的数据转换为字节数组
            DatagramPacket packet2 = new DatagramPacket(data, data.length, desIP, DES_PORT);// 2.创建数据报，包含响应的数据信息
            socket.send(packet2); // 3.发送udp报文
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @return
     */
    public Motor recvOne() {
        packet.setData(tempData);
        try {
            socket.receive(packet);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return Motor.createByBytes(tempData);
    }

    /**
     * 接收电机数据，缓存到currData的第index个位置中
     */
    public void recv(int index) {
        packet.setData(currData[index]);
        try {
            socket.receive(packet);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

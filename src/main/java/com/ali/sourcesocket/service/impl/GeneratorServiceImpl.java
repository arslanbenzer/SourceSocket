package com.ali.sourcesocket.service.impl;


import com.ali.sourcesocket.service.GeneratorService;
import jakarta.xml.bind.DatatypeConverter;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.PrintWriter;
import java.net.Socket;
import java.security.MessageDigest;
import java.sql.Timestamp;

@Service
public class GeneratorServiceImpl implements GeneratorService {

    private final Integer port = 8000;

    @Override
    public void generateNumber() {

        String host = "localhost";
        try (Socket socket = new Socket(host, port); PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)) {
            System.out.println("Generating number");
            MessageDigest md = MessageDigest.getInstance("MD5");

            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            int random = (int) (Math.random() * 100);

            String concat = timestamp.toString() + random;

            md.update(concat.getBytes());
            byte[] digest = md.digest();
            String myHash = DatatypeConverter.printHexBinary(digest).toUpperCase();


            JSONObject jsonObject = new JSONObject();
            jsonObject.put("hash", myHash.substring(myHash.length() - 2));
            jsonObject.put("value", random);
            jsonObject.put("timestamp", timestamp.getTime());

            writer.println(jsonObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Message sent");
    }
}


package com.mycompany.tcpclient;

import com.mycompany.fileutill.FileUtill;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;


public class TCPClient {
    public static void main(String[] args) throws Exception {
    TCPClientV1("isobala.jpeg");
    }
    
    public static void TCPClientV1(String fileName) throws IOException, Exception{
    Socket socket = new Socket("localhost",6789);
    OutputStream outputStream = socket.getOutputStream();
    DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
    byte[] myDataInByte = FileUtill.readInBytes(fileName);
    dataOutputStream.writeInt(myDataInByte.length);
    dataOutputStream.write(myDataInByte);
    socket.close();
    
    }
}

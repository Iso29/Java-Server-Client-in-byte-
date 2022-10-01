
package com.mycompany.tcpserver;

import com.mycompany.fileutill.FileUtill;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

    public static void main(String[] args) throws Exception{
        Tcpbala("isobala2.jpeg");
    }
    
    public static void Tcpbala (String fileName) throws IOException, Exception{
    ServerSocket serverSocket = new ServerSocket(6789);
        while(true){
            System.out.println("Socket is waiting ...");
            Socket connecttion = serverSocket.accept();
            System.out.println("Server accepted socket ");
            InputStream is = connecttion.getInputStream();
            DataInputStream dataInputStream = new DataInputStream(is);
            byte[] dataByte = readInByte(dataInputStream);
            FileUtill.writeInBytes(fileName, dataByte);
        }
    }
    
    
    public static byte[] readInByte(DataInputStream dis)throws Exception{
        int msgLen = dis.readInt();
        byte[] msgInByte = new byte[msgLen];
        dis.readFully(msgInByte);
        return msgInByte;
    }
}

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Stack;

public class SymmetricalStringServer {
	public static final int PORT=9876;
	private static DatagramSocket server=null;
	private static byte[] receiveData;
	private static byte[] sendData;
	private static InetAddress clientIP;
	private static int clientPort;
	private static String sendMsg,receiveMsg;
	
	public static void main(String[] args) throws SocketException {
		server=new DatagramSocket(PORT);
		System.out.println("Server start");

		while(true) {
			try {
				receiveData=new byte[1024];
				DatagramPacket recieve_Packet = new DatagramPacket(receiveData, receiveData.length);
				server.receive(recieve_Packet);
				clientIP = recieve_Packet.getAddress();
				clientPort = recieve_Packet.getPort();

				
				
				receiveMsg=new String(recieve_Packet.getData(),"UTF-8").trim();
				
				sendData = new byte[1024];
				sendMsg="Khong phai chuoi doi xung";
				if (checkSymmetrical(receiveMsg))
				    sendMsg="Ngung nhap";
				sendData = sendMsg.getBytes();
				DatagramPacket send_result_Packet = new DatagramPacket(sendData, sendData.length, clientIP, clientPort);
				server.send(send_result_Packet);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();			
				break;
			}
		}

	}
	public static boolean checkSymmetrical(String st) {
		Stack stack = new Stack();
        for (int i = 0; i < st.length(); i++) {
            stack.push(st.charAt(i));
        }
        String reverseString = "";
 
        while (!stack.isEmpty()) {
            reverseString = reverseString+stack.pop();
        }
        if (st.equals(reverseString))
           return true;
        else
          return false;
}
}

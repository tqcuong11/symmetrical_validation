import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class SymmetricalStringClient {
	
	public static void Send(){
		// TODO Auto-generated method stub
		try {
			
			String result;
				InetAddress IPAddress=InetAddress.getByName("localhost");
				DatagramSocket clientSocket=new DatagramSocket();
				byte[] sendData= new byte[1024];
				byte[] receiveData= new byte[1024];
				
				
				
					String st=SymmetricalStringClientGUI.textField.getText().trim();
					sendData=st.getBytes();
					DatagramPacket sendPacket= new DatagramPacket(sendData,sendData.length,IPAddress,9876);
					clientSocket.send(sendPacket);
								
					DatagramPacket receivePacket= new DatagramPacket(receiveData, receiveData.length);
					clientSocket.receive(receivePacket);
					result=new String(receivePacket.getData(),"UTF-8").trim();
					if (!result.equals("Ngung nhap"))
						SymmetricalStringClientGUI.textArea.append("Ket qua: "+result+"\n");
					else {
						SymmetricalStringClientGUI.textArea.append(result+"\n");
						SymmetricalStringClientGUI.textField.setEnabled(false);
						
					}
						
			

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}

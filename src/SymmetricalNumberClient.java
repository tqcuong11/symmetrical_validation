import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class SymmetricalNumberClient {

	public static void Send(){
		BufferedReader br=null;
		PrintWriter pw=null;
		try {
			Socket socket=new Socket("localhost",9000);
			br= new BufferedReader(new InputStreamReader(socket.getInputStream()));
			BufferedReader sc= new BufferedReader(new InputStreamReader(System.in));
			pw = new PrintWriter(socket.getOutputStream());



			String s=SymmetricalNumberClientGUI.textField.getText().trim();
			pw.println(s);
			pw.flush();
			String result=br.readLine();

			SymmetricalNumberClientGUI.textArea.append("Result :"+result+"\n");
			if(result.contains("la so doi xung")) {
				SymmetricalNumberClientGUI.textArea.append("Ngung nhap\n");
				SymmetricalNumberClientGUI.textField.setEnabled(false);
			}



		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				if (br!= null) br.close();
				if (pw!=null) pw.close();

			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

}


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SymmetricalNumberServer {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ServerSocket server = new ServerSocket(9000);
		System.out.println("Server is started.");
		Socket sk=null;
		while(true) {
			try {
				sk=server.accept();
				PrintWriter pw= new PrintWriter(new OutputStreamWriter(sk.getOutputStream()));
				BufferedReader br=new BufferedReader(new InputStreamReader(sk.getInputStream()));
				while(true) {
					String s=br.readLine();
					int number=Integer.parseInt(s);
					String res="";
					if (checkSymmetrical(transfrom(number))) {
						res = addBits(transfrom(number)) +" la so doi xung";
					} else {
						res = addBits(transfrom(number)) +" so khong doi xung";
					}
					pw.println(res);
					pw.flush();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				try {
					if (sk!=null)
					sk.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}
	}
	
	public static String transfrom(int input) {
		String res = "";
		
		int du = 0, kq = 0;
		while (input > 0) {
			du = input % 2;
			input = input / 2;
			res += String.valueOf(du);
		}
		
		String nhiphan = "";
		for (int i=res.length()-1; i>=0; i--) {
			nhiphan += res.charAt(i);
		}
		return nhiphan;
	}

	public static String addBits(String input) {
		String res = "";
		for (int i=0; i<8-input.length(); i++) {
			res += "0";
		}
		
		res += input;
		return res;
	}
	
	public static boolean checkSymmetrical(String input) {
		
		for (int i=0; i<input.length()/2; i++) {
			if (input.charAt(i) != input.charAt(input.length()-1-i)) {
				return false;
			}
		}
		
		return true;
	}

}


package EmailUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.mail.MessagingException;

public class ReadFile {

	public static void ReadTheFile() {
		String filePath = "C:\\seleniumProject\\ecommerce\\src\\Downloads\\orders(1).csv";

		try {
			EmailUtil.emailUtil(filePath);
		} catch (MessagingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// Mail.mail(filePath);

		// 5. Read downloaded file and display the Heading and all the Order details in
		// the console windows
		File f = new File(filePath);
		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();
			while (line != null) {
				System.out.println(line);
				line = br.readLine();
			}
			fr.close();
			br.close();
		} catch (FileNotFoundException fe) {
			// TODO Auto-generated catch block
			fe.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
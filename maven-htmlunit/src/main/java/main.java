import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.logging.LogFactory;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlButton;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;


public class main {
	// Defining the Base Url
	private static final String baseUrl = "https://online.vodafone.com.tr/yanimda/#/giris";
	public static void main (String Args[]) {
		LogFactory.getFactory().setAttribute("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");
	
		// Creating the WebClient object
		WebClient client = new WebClient(BrowserVersion.CHROME);
		// Enabling the JS
		client.getOptions().setJavaScriptEnabled(true);
		client.getOptions().setThrowExceptionOnScriptError(false);
		client.getOptions().setThrowExceptionOnFailingStatusCode(false);
		// Creating the input object
		Scanner input = new Scanner(System.in);
		
	
		try {
			// Creating the HtmlPage object
			HtmlPage page = client.getPage(baseUrl);
			
			
			// Getting the Login Elements by Xpath
			HtmlInput inputMsisdn = page.getFirstByXPath("/html/body/app-root/app-login/div[1]/div/div[1]/div[3]/div[2]/div/div[2]/fieldset/div[1]/label/input");
			HtmlInput inputPass = page.getFirstByXPath("/html/body/app-root/app-login/div[1]/div/div[1]/div[3]/div[2]/div/div[2]/fieldset/div[2]/label/input");
			HtmlButton loginButton = page.getFirstByXPath("/html/body/app-root/app-login/div[1]/div/div[1]/div[3]/div[2]/div/div[2]/fieldset/div[4]/button");
			
			// Enter the credentials
			inputMsisdn.setValueAttribute("5537746432");
			inputPass.setValueAttribute("16819421");
			
			// Remove the "disabled" attribute from Button element
			loginButton.removeAttribute("disabled");
			// Submit the form
			loginButton.click();
			
			// Getting the security key by user
			System.out.println("Enter the security key: ");
			String smsKey = input.next();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		input.close();
		client.close();
	}
	
}
 
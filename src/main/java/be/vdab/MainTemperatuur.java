package be.vdab;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;

import be.vdab.utils.FahrenheitToCelsiusUtil;

class MainTemperatuur {
	private static final String URL = 
		"https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22brussels%2C%20be%22)&format=xml&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys";
	private static final String XPATH_EXPR_TEMPERATUUR = "//yweather:condition/@temp";
		
	
	public static void main(String[] args) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(URL);
			XPathFactory xPathFactory = XPathFactory.newInstance();
			XPath xPath = xPathFactory.newXPath();
			xPath.setNamespaceContext(new MyNamespaceContext());
			String temperatuurString = xPath.evaluate(XPATH_EXPR_TEMPERATUUR, document);
			System.out.printf("De temperatuur in Brussel is: %6.2f°C%n", 
				new FahrenheitToCelsiusUtil(temperatuurString).getTempCelsius());
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}

// temperatuur niet vergeten van F naar C om te zetten, utility voor schrijven
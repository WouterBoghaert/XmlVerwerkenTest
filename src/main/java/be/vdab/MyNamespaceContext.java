package be.vdab;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.xml.namespace.NamespaceContext;

class MyNamespaceContext implements NamespaceContext {
	private final Map<String, String> prefixesNamespaces = new HashMap<>();
	
	MyNamespaceContext() {
		prefixesNamespaces.put("yahoo", "http://www.yahooapis.com/v1/base.rng");
		prefixesNamespaces.put("yweather","http://xml.weather.yahoo.com/ns/rss/1.0");
		prefixesNamespaces.put("geo", "http://www.w3.org/2003/01/geo/wgs84_pos#");
	}
	
	@Override
	public String getNamespaceURI(String prefix) {
		String namespace = prefixesNamespaces.get(prefix);
		if(namespace == null) {
			throw new IllegalArgumentException("unknown prefix");
		}
		return namespace;
	}

	@Override
	public String getPrefix(String namespaceURI) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Iterator getPrefixes(String namespaceURI) {
		throw new UnsupportedOperationException();
	}

}

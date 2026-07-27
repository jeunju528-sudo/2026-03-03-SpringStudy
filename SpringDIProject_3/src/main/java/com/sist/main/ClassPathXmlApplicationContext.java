package com.sist.main;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class ClassPathXmlApplicationContext implements ApplicationContext {

	private Map clsMap = new HashMap();
	public ClassPathXmlApplicationContext(String path) {
		try {
			SAXParserFactory spf = SAXParserFactory.newInstance();
			SAXParser sp = spf.newSAXParser();
			
			XMLParse xp = new XMLParse();
			sp.parse(new File(path), xp);
			clsMap = xp.getMap();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public Object getBean(String key) {
		return clsMap.get(key);
	}
	
}

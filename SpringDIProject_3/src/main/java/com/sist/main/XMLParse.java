package com.sist.main;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/*
 * <?xml version="1.0" encoding="UTF-8"?> => startDocument()
<beans> => startElement()
	<bean id="sa" class="com.sist.main.Sawon" => startElement()
		p:sabun="1"
		p:name="홍길동"
		p:dept="개발부"
		p:job="사원"
	/> => endElement()
</beans> => endElement()
 * 
 * */

// ClassPathXmlApplicationContext("app.xml") 과 같은 행위를 함
public class XMLParse extends DefaultHandler {
	private Map map = new HashMap();
	
	// qName : 태그명, attributes 속성명
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		try {
			if(qName.equals("bean")) {
				String id = attributes.getValue("id");
				String cls = attributes.getValue("class");
				String sabun = attributes.getValue("p:sabun");
				String name = attributes.getValue("p:name");
				String dept = attributes.getValue("p:dept");
				String job = attributes.getValue("p:job");
//				System.out.println(id+" "+cls+" "+sabun+" ");
				String[] aName = {sabun, name, dept, job};
				String[] ss = {attributes.getQName(2),attributes.getQName(3),attributes.getQName(4),attributes.getQName(5)};
				System.out.println(Arrays.toString(ss));
				
				Class clsName = Class.forName(cls);
				Object obj = clsName.getDeclaredConstructor().newInstance();
				Method[] methods = clsName.getDeclaredMethods();
				for(Method m : methods) {
					String mName = m.getName();
					for(int i=0; i<ss.length; i++) {
						if(mName.equalsIgnoreCase("set"+ss[i].substring(ss[i].indexOf(":")+1))) {
							if(i==0) {
								m.invoke(obj, Integer.parseInt(aName[i]));
							}
							else {
								m.invoke(obj, aName[i]);
							}
						}
					}
					map.put(id, obj);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public Map getMap() {
		return map; 
	}

}

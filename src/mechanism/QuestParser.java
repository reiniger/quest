package mechanism;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class QuestParser {
	
	static final String QUEST = "quest";
	static final String SCREEN = "screen";
	static final String TEXT = "text";
	static final String NAME = "name";
	static final String OPTION = "option";
	static final String NEXT = "next";

	@SuppressWarnings({ "unchecked" })
	public ArrayList<Screen> readQuest(String questFile) {
		ArrayList<Screen> screens = new ArrayList<Screen>();
		try {
			// First, create a new XMLInputFactory
			XMLInputFactory inputFactory = XMLInputFactory.newInstance();
			
			// Setup a new eventReader
			InputStream in = new FileInputStream(questFile);
			XMLEventReader eventReader = inputFactory.createXMLEventReader(in);
			
			// read the XML document
			Screen screen = null;
			
			while (eventReader.hasNext()) {
				XMLEvent event = eventReader.nextEvent();
				
				if (event.isStartElement()) {
					StartElement startElement = event.asStartElement();
					
					if (startElement.getName().getLocalPart().equals(SCREEN)) {
						screen = new Screen();
						// We read the attributes from this tag
						Iterator<Attribute> attributes = startElement.getAttributes();
						if (attributes.hasNext()) {
							Attribute attribute = attributes.next();
							if (attribute.getName().toString().equals(NAME))
								screen.setName(attribute.getValue());
						}
						continue;
					}
					
					if (event.asStartElement().getName().getLocalPart().equals(TEXT)) {
						event = eventReader.nextEvent();
						screen.setText(event.asCharacters().getData());
						continue;
					}
					
					if (event.asStartElement().getName().getLocalPart().equals(OPTION)) {
						Option option = new Option();
						
						Iterator<Attribute> attributes = startElement.getAttributes();
						while (attributes.hasNext()) {
							Attribute attribute = attributes.next();
							if (attribute.getName().toString().equals(NAME))
								option.setName(attribute.getValue());
							if (attribute.getName().toString().equals(NEXT))
								option.setNext(attribute.getValue());
						}
						
						event = eventReader.nextEvent();
						option.setText(event.asCharacters().getData());
						screen.addOption(option);
						continue;
					}
				}
				
				// If we reach the end of an item element, we add it to the list
				if (event.isEndElement()) {
					EndElement endElement = event.asEndElement();
					if (endElement.getName().getLocalPart().equals(SCREEN)) {
						screens.add(screen);
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
	    return screens;
	}
}
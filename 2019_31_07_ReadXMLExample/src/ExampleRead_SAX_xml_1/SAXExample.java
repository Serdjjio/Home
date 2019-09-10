// достать всю информацию про всех сотрудников из файла xml
// вся нужная нам информация — это атрибуты элементов employee.

package ExampleRead_SAX_xml_1;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class SAXExample {
    private static ArrayList<Employee> employees = new ArrayList<>();

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        //создание фабрики и образца парсера
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        XMLHandler handler = new XMLHandler();
        parser.parse(new File("company.xml"),handler);

        for(Employee employee:employees){
            System.out.println(String.format("Имя сотрудника: %s, его должность: %s", employee.getName(), employee.getJob()));
        }
    }

    private static class XMLHandler extends DefaultHandler {

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            //     System.out.println("startElement");
            //     Тут будет логика реакции на начало элемента
       if(qName.equals("employee")){
           String name = attributes.getValue("name");
           String job = attributes.getValue("job");
           employees.add(new Employee(name,job));
            }
        }

        @Override
        public void startDocument() throws SAXException {
                //  System.out.println("startDocument");
                // Тут будет логика реакции на начало документа
        }

        @Override
        public void endDocument() throws SAXException {
                // System.out.println("endDocument");
                // Тут будет логика реакции на конец документа
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
                // System.out.println("endElement");
                // Тут будет логика реакции на конец элемента
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
                // System.out.println("characters");
                // Тут будет логика реакции на текст между элементами
        }

        @Override
        public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
                // System.out.println("ignorableWhitespace");
                // Тут будет логика реакции на пустое пространство внутри элементов (пробелы, переносы строчек и так далее).
        }
    }
}

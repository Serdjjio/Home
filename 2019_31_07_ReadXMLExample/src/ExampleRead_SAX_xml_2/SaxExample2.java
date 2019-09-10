// Как вы видите, информация про имя и должность теперь хранится как текстовая информация
// внутри элементов name и job. Для считывания текста внутри элементов у нас есть метод characters.
package ExampleRead_SAX_xml_2;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
public class SaxExample2 {
    private static ArrayList<Employee2> employees2 = new ArrayList<>();

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        //создание фабрики и образца парсера
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        XMLHandler handler = new XMLHandler();
        parser.parse(new File("company2_IT_Heaven.xml"), handler);

        for (Employee2 employee : employees2) {
            System.out.println(String.format("Имя сотрудника: %s, его должность: %s", employee.getName(), employee.getJob()));
        }
    }

    private static class XMLHandler extends DefaultHandler {
        private String name, job, lastElementName;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            lastElementName = qName;
        }


        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            // System.out.println("characters");
            // Тут будет логика реакции на текст между элементами
            String information = new String(ch, start, length);
            information = information.replace("/n", "").trim();

            if (!information.isEmpty()) {
                if (lastElementName.equals("name"))
                    name = information;
                if (lastElementName.equals("job"))
                    job = information;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            // System.out.println("endElement");
            // Тут будет логика реакции на конец элемента
            if ( (name != null && !name.isEmpty()) && (job != null && !job.isEmpty()) ) {
                employees2.add(new Employee2(name, job));
                name = null;
                job = null;
            }
        }
    }
}
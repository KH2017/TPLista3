package eu.jpereira.trainings.designpatterns.creational.abstractfactory;

import eu.jpereira.trainings.designpatterns.creational.abstractfactory.xml.XMLReportBody;
import eu.jpereira.trainings.designpatterns.creational.abstractfactory.xml.XMLReportFooter;
import eu.jpereira.trainings.designpatterns.creational.abstractfactory.xml.XMLReportHeader;

public class XMLReportElementsFactory extends AbstractReportElementsFactory{

	public XMLReportElementsFactory(){
		setBody(new XMLReportBody());
		setFooter(new XMLReportFooter());
		setHeader(new XMLReportHeader());
	}
}

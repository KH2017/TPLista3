package eu.jpereira.trainings.designpatterns.creational.abstractfactory;

import eu.jpereira.trainings.designpatterns.creational.abstractfactory.json.JSONReportBody;
import eu.jpereira.trainings.designpatterns.creational.abstractfactory.json.JSONReportFooter;
import eu.jpereira.trainings.designpatterns.creational.abstractfactory.json.JSONReportHeader;

public class JSONReportElementsFactory extends AbstractReportElementsFactory{

	public JSONReportElementsFactory(){
		setBody(new JSONReportBody());
		setFooter(new JSONReportFooter());
		setHeader(new JSONReportHeader());
	}
}

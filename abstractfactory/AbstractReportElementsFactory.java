package eu.jpereira.trainings.designpatterns.creational.abstractfactory;

public abstract class AbstractReportElementsFactory {

	private String reportContent;
	private ReportBody body;
	private ReportFooter footer;
	private ReportHeader header;
	private String reportType;
	
	public ReportBody getBody(){
		return body;
	}
	
	public ReportFooter getFooter(){
		return footer;
	}
	
	public ReportHeader getHeader(){
		return header;
	}
	
	public void setBody(ReportBody r){
		body = r;
	}
	
	public void setFooter(ReportFooter r){
		footer = r;
	}
	
	public void setHeader(ReportHeader r){
		header = r;
	}
}

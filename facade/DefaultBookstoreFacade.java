package eu.jpereira.trainings.designpatterns.structural.facade;

import eu.jpereira.trainings.designpatterns.structural.facade.model.Book;
import eu.jpereira.trainings.designpatterns.structural.facade.model.Customer;
import eu.jpereira.trainings.designpatterns.structural.facade.model.DispatchReceipt;
import eu.jpereira.trainings.designpatterns.structural.facade.model.Order;
import eu.jpereira.trainings.designpatterns.structural.facade.service.BookDBService;
import eu.jpereira.trainings.designpatterns.structural.facade.service.CustomerDBService;
import eu.jpereira.trainings.designpatterns.structural.facade.service.CustomerNotificationService;
import eu.jpereira.trainings.designpatterns.structural.facade.service.OrderingService;
import eu.jpereira.trainings.designpatterns.structural.facade.service.WharehouseService;

public class DefaultBookstoreFacade implements BookstoreFacade {
	WharehouseService wharehouseService;
	BookDBService bookService;
	OrderingService orderingService;
	CustomerDBService customerService;
	CustomerNotificationService customerNotificationService;
	
	
	public void setWharehouseService(WharehouseService wharehouseService){
		this.wharehouseService = wharehouseService;
	}
	
	public void setBookDBService(BookDBService bookService){
		this.bookService = bookService;
	}
	
	public void setOrderingService(OrderingService orderingService){
		this.orderingService = orderingService;
	}
	
	public void setCustomerDBService(CustomerDBService customerService){
		this.customerService = customerService;
	}
	
	public void setCustomerNotificationService(CustomerNotificationService customerNotificationService){
		this.customerNotificationService = customerNotificationService;
	}
	
	
	@Override
	public void placeOrder(String customerId, String isbn) {
		Book book = bookService.findBookByISBN(isbn);
		Customer customer = customerService.findCustomerById(customerId);
		Order order = orderingService.createOrder(customer, book);
		DispatchReceipt dispatchReceipt = wharehouseService.dispatch(order);
		
		customerNotificationService.notifyClient(order);
		customerNotificationService.notifyClient(dispatchReceipt);
	}

}

package async;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;
import javax.xml.ws.Endpoint;

@WebService(serviceName = "Reservation", portName = "ReservationPort", targetNamespace = "http://asu.dgtu.donetsk.ua/ex/students")
@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL, parameterStyle = ParameterStyle.WRAPPED)
public class ReservationService {

	// store Furniture assortment
	//TODO поменять
	private static Furniture[] furnitureData = {
			new Furniture("1", "IKEA", "Office chairs", "Office chair W3432", "10",8000),
			new Furniture("2", "Ashley HomeStore", "Table cafe", "Coffee table H3467", "25",15000),
			new Furniture("3", "Restoration Hardware", "Chair cafe", "Dining chair L2368", "7",1200),
			new Furniture("4", "Kartell", "Office table", "Console table Q0001", "20",17000),
			new Furniture("5", "Williams-Sonoma ", "Chair", "Chair for home T3126", "5",7000)
	};
	// the number of products in the store
	private static int[] quantityData = {11, 17, 8, 9, 19};
	private static StoreAssortment storeAssortment = new StoreAssortment(furnitureData, quantityData);
	private UserReserve goReserveFurniture(String type, int quantity) {
		int size = storeAssortment.getFurnitures().length;
		for (int i = 0; i < size; i++) {
			Furniture currentFurniture = storeAssortment.getFurnitures()[i];
			int currentQuantity = storeAssortment.getQuantity()[i];
			if (type.equals(currentFurniture.getType()) && quantity <= currentQuantity) {
				storeAssortment.setQuantityFromIndex(i, currentQuantity - quantity);
				return new UserReserve(currentFurniture, quantity);
			}
		}
		return null;
	}

	@WebMethod(operationName = "ReserveFurniture")
	public UserReserve reserveFurniture(String type, int quantity) {
		try {
			Thread.sleep(1000*10); // Sleep for 10 seconds
			return goReserveFurniture(type, quantity);
		} catch(InterruptedException e) {
			e.printStackTrace();
			return null;
		}
	}

	 public static void main(String args[]) {
	        Endpoint.publish("http://localhost:8082/Reservation", new ReservationService());
	  }
}

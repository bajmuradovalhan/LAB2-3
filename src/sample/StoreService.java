package sample;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

@WebService(serviceName = "DisplayAssortment", portName = "DisplayAssortmentPort", targetNamespace = "http://asu.dgtu.donetsk.ua/ex/passexam")
@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL, parameterStyle = ParameterStyle.WRAPPED)
public class StoreService {
    // store furniture assortment
    private static Furniture[] furnitureData = {
            new Furniture("1", "IKEA", "Chair", "Office chair", "10",8000),
            new Furniture("2", "Ashley HomeStore", "Table", "Coffee table", "25",15000),
            new Furniture("3", "Restoration Hardware", "Chair", "Dining chair", "7",1200),
            new Furniture("4", "Kartell", "Table", "Console table", "20",17000),
            new Furniture("5", "Williams-Sonoma ", "Chair", "Chair for home", "5",7000)
    };
    // the number of products in the store
    private static int[] quantityData = {24, 4, 52, 14, 32};
    private static StoreAssortment storeAssortment = new StoreAssortment(furnitureData, quantityData);

    @WebMethod(operationName = "GetStoreAssortment")
    public StoreAssortment getStoreAssortment() {
        return storeAssortment;
    }

}
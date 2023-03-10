package sample.client;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;

public class StoreClient {

    private final static QName SHOWASSORTMENT_QNAME = new QName(
            "http://asu.dgtu.donetsk.ua/ex/passexam", "DisplayAssortment"
    );

    private static URL getWSDLURL(String urlStr) {
        URL url = null;
        try {
            url = new URL(urlStr);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return url;
    }

    private void printStoreAssortment(StoreAssortment assortment) {
        for (int i = 0; i < assortment.getFurniture().size(); i++) {
            Furniture clothes = assortment.getFurniture().get(i);
            int quantity = assortment.getQuantity().get(i);
            System.out.println(clothes.company + " | " +
                    clothes.type + " | " +
                    clothes.name + " | " +
                    clothes.weight + "Kg | " +
                    clothes.price + "P" +
                    " | Amount: " + quantity);
        }
    }

    private void name(URL url) {
        DisplayAssortment service = new DisplayAssortment(url, SHOWASSORTMENT_QNAME);
        StoreService storeSvcPort = service.getDisplayAssortmentPort();
        StoreAssortment assortment = storeSvcPort.getStoreAssortment();
        System.out.println("    Shop Catalog  \n -----------------------");
        printStoreAssortment(assortment);
    }

    public static void main(String[] args) {
        URL url = getWSDLURL("http://localhost:8081/StoreSvcWeb/displayassortment?wsdl");
        StoreClient client = new StoreClient();
        client.name(url);
    }


}

package org.example.webservice;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import org.example.models.Product;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebService(serviceName = "ProductWS")
public class ProductWebService {
    private static final List<Product> products = new ArrayList<>();

    // Constructor to initialize some products
    public ProductWebService() {
        products.add(new Product(1, "Table", 300.0, new Date()));
        products.add(new Product(2, "Pen", 3.0, new Date()));
        products.add(new Product(3, "Cheese", 30.0, new Date()));
        products.add(new Product(4, "Bread", 6.0, new Date()));
    }

    @WebMethod(operationName = "sellingPrice")
    public Double sellingPrice(@WebParam(name = "Price") Double price) {
        return price * 1.5;
    }

    @WebMethod
    public Product getProduct(Integer code) {
        return products.stream()
                .filter(p -> p.getCode().equals(code))
                .findFirst()
                .orElse(null);
    }

    @WebMethod
    public List<Product> productList() {
        return products;
    }

    @WebMethod
    public String addProduct(@WebParam(name = "product") Product product) {
        products.add(product);
        return "Product added successfully: " + product.getName();
    }

    @WebMethod
    public String updateProduct(@WebParam(name = "product") Product updatedProduct) {
        for (Product product : products) {
            if (product.getCode().equals(updatedProduct.getCode())) {
                product.setName(updatedProduct.getName());
                product.setPrice(updatedProduct.getPrice());
                return "Product updated successfully: " + updatedProduct.getName();
            }
        }
        return "Product not found!";
    }

    @WebMethod
    public String deleteProduct(@WebParam(name = "code") Integer code) {
        Product productToRemove = products.stream()
                .filter(p -> p.getCode().equals(code))
                .findFirst()
                .orElse(null);

        if (productToRemove != null) {
            products.remove(productToRemove);
            return "Product deleted successfully: " + productToRemove.getName();
        }
        return "Product not found!";
    }
}

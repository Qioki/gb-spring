package com.example.l1.servlet;

import com.example.l1.service.ProductFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProductServlet", urlPatterns = "/product")
public class ProductServlet extends HttpServlet {

    private final Logger logger = LoggerFactory.getLogger(ProductServlet.class);


    private ProductFactory productFactory = new ProductFactory();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("productList", productFactory.getTestProducts(10));

//        HttpServletRequest
        getServletContext().getRequestDispatcher("/product.jsp").forward(req, resp);
    }

}

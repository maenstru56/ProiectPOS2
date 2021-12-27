package servlet;

import ejb.ProductBean;
import ejb.UserBean;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddProduct", value = "/AddProduct")
public class AddProduct extends HttpServlet {
    @Inject
    ProductBean productBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        productBean.createProduct("Lapte", 1, 500.0, 1, "invalid");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        int category = Integer.parseInt(request.getParameter("category"));
        double price = Double.parseDouble(request.getParameter("price"));
        int unit = Integer.parseInt(request.getParameter("unit"));
        String imgPath = request.getParameter("imgPath");

        productBean.createProduct(name, category, price, unit, imgPath);
    }
}

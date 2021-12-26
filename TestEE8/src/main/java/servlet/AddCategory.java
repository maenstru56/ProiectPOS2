package servlet;

import ejb.CategoryBean;
import ejb.ProductBean;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddCategory", value = "/AddCategory")
public class AddCategory extends HttpServlet {
    @Inject
    CategoryBean categoryBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");

        categoryBean.createCategory(name);
    }
}

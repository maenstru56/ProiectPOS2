package servlet;

import ejb.ProductBean;
import entity.ProductEntity;
import entity.UserTableEntity;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ShowAllProducts", value = "/ShowAllProducts")
public class ShowAllProducts extends HttpServlet {
    @Inject
    ProductBean productBean;

    List<ProductEntity> allProducts;
    @Override
    public void init(){
        allProducts = productBean.getAllProducts();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Set response to html page


        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");

        writeProductsTable(out);

        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void writeProductsTable(PrintWriter out) {
        out.println("<table>");
        out.println("<tr> <th>ID</th> <th>Name</th> <th>Category</th>" +
                " <th>Price</th> <th>Unit</th> <th>Img</th> </tr>");
        if(allProducts.isEmpty()) {
            out.println("<h1> No products right now! </h1>");
        }
        else {
            for (ProductEntity prod : allProducts) {
                out.println("<tr>" + "<td>" + prod.getId() + "</td>" + "<td>" + prod.getProductName() + "</td>" +
                        "<td>" + prod.getIdCategory() + "</td>" + "<td>" + prod.getPrice() + "</td>"
                        + "<td>" + prod.getIdUnit() + "</td>" + "<td>" + prod.getImgPath() + "</td>" + "</tr>");
            }
        }
        out.println("</table>");
    }
}

package servlet;

import ejb.UserBean;
import entity.UserTableEntity;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "AddUser", value = "/AddUser")
public class AddUser extends HttpServlet {
    @Inject
    UserBean userBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        int role = Integer.parseInt(request.getParameter("role"));
        String email = request.getParameter("email");

        userBean.CreateUser(username, password, role, email);

        List<UserTableEntity> x = userBean.getAllUsers();

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        for(int i = 1; i < 6; i++) {
            out.println("<p>" + "ID" + "USERNAME" + "PASSWORD" + "ID_ROLE" + "ID_STATE" + "EMAIL" + "</p>");
        }

        for(int i = 1; i < x.size(); i++) {
            out.println("<p>" + x.get(i).getId() + x.get(i).getUsername() + x.get(i).getPassword() + x.get(i).getIdRole() + x.get(i).getIdState() + x.get(i).getEmail() + "</p>");
        }
        out.println("</body></html>");
    }
}

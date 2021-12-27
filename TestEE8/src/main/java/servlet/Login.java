package servlet;

import ejb.UserBean;
import utility.Password;

import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {
    @Inject
    UserBean userBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("login_error_message", "Username or password incorrect");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //TODO:Hash Password
        //String hashPassword = Password.convertToSha256(password);

        String databasePassword = null;
        try {
            databasePassword = userBean.getPasswordByUsername(username);
        } catch (Exception e) {
            response.setContentType("text/html");

            PrintWriter out = response.getWriter();
            out.println("<html><body>Eroare!");
            out.println(e.getStackTrace());
            out.println("</body></html>");
        }

        if (password.equals(databasePassword)) {
            response.setContentType("text/html");

            PrintWriter out = response.getWriter();
            out.println("<html><body>Esti Logat!");
            out.println("</body></html>");
        } else {
            request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Login servlet";
    }
}

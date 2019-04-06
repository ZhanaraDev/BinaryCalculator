package servlets;

import services.Calculator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static services.Validator.isNullOrEmpty;

@WebServlet("/calculate")
public class BinaryCalculator extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        String operation_type = req.getParameter("type");
        String op1 = req.getParameter("x");
        String op2 = req.getParameter("y");

        String response = "Wrong Input Data! Check params again!";

        if(!isNullOrEmpty(operation_type) && !isNullOrEmpty(op1) && !isNullOrEmpty(op2)){
            int res = Calculator.getResult(operation_type, op1, op2);
            response = Integer.toBinaryString(res);
        }

        resp.setContentType("text/plain");

        PrintWriter out = resp.getWriter();
        out.print(response);
    }
}

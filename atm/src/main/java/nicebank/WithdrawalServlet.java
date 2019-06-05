package nicebank;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WithdrawalServlet extends HttpServlet {

    private CashSlot cashSlot;
    private Account account;

    public WithdrawalServlet(CashSlot cashSlot, Account account) {
        this.cashSlot = cashSlot;
        this.account = account;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        Teller teller = new AutomatedTeller(cashSlot);
        int amount = Integer.parseInt(request.getParameter("amount"));
        teller.withdrawFrom(account, amount);

        response.setContentType("text/html");
        response.getWriter().println(
                "<html><head><title>ATM</title></head>" +
                        "<body>Please take your $"+ amount + "</body>" + "</html>");

    }
}

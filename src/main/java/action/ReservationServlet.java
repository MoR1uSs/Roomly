package action;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet("/reserveringen")
public class ReservationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private List<Map<String, String>> getReserveringen() {
        List<Map<String, String>> reserveringen = new ArrayList<>();
        reserveringen.add(Map.of("datum", "2025-06-30", "tijd", "10:00", "ruimte", "A1", "gebruiker", "John", "capaciteit", "12"));
        reserveringen.add(Map.of("datum", "2025-07-02", "tijd", "14:30", "ruimte", "B2", "gebruiker", "Lisa", "capaciteit", "8"));
        reserveringen.add(Map.of("datum", "2025-07-04", "tijd", "09:00", "ruimte", "C3", "gebruiker", "Ahmed", "capaciteit", "10"));
        return reserveringen;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        StringBuilder json = new StringBuilder();
        json.append("[");
        List<Map<String, String>> reserveringen = getReserveringen();
        for (int i = 0; i < reserveringen.size(); i++) {
            Map<String, String> r = reserveringen.get(i);
            json.append("{");
            json.append("\"datum\":\"").append(r.get("datum")).append("\",");
            json.append("\"tijd\":\"").append(r.get("tijd")).append("\",");
            json.append("\"ruimte\":\"").append(r.get("ruimte")).append("\",");
            json.append("\"gebruiker\":\"").append(r.get("gebruiker")).append("\",");
            json.append("\"capaciteit\":\"").append(r.get("capaciteit")).append("\"");
            json.append("}");
            if (i < reserveringen.size() - 1) json.append(",");
        }
        json.append("]");
        out.print(json.toString());
        out.flush();
    }
}


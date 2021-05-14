<%@ page import="com.guitarshack.restockalert.*" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.concurrent.atomic.AtomicBoolean" %>
<html>
<body>
<%
    int productId =  Integer.parseInt(request.getParameter("productId"));
    int quantity =  Integer.parseInt(request.getParameter("quantity"));
    AtomicBoolean alertSent = new AtomicBoolean(false);
    SaleReceiver saleReceiver = new SaleReceiver(s -> { alertSent.set(true); },
            new ProductWarehouse(
                    new HttpNetwork(),
                    "https://6hr1390c1j.execute-api.us-east-2.amazonaws.com/default/"),
            new HistoricalSalesRestockCalculator(() -> Calendar.getInstance().getTime(),
                    new SalesHistoryApi(
                            new HttpNetwork(),
                            "https://gjtvhjg8e9.execute-api.us-east-2.amazonaws.com/default/")));
    saleReceiver.onSale(productId, quantity);
%>
<h2>
    <%= productId%>
    <%= quantity%>
    <%= alertSent.get()%>
</h2>
</body>
</html>

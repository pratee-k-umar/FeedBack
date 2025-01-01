<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%@ include file="links.jsp" %>
    <title>Bootstrap demo</title>
  </head>
  <body>
    <%@ include file="header.jsp" %>
    <div class="d-flex justify-content-center p-2">
      <a href="<%= application.getContextPath() %>/feedback.jsp" class="btn btn-primary">FeedBack</a>
    </div>
    <%@ include file="scripts.jsp" %>
  </body>
</html>
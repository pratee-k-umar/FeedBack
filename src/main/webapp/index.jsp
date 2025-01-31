<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List, org.example.models.Comment" %>
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
    <div class="container">
      <h1 class="heading">Comments</h1>
        <table class="table">
          <thead>
            <tr>
              <th>ID</th>
              <th>Email</th>
              <th>Phone</th>
              <th>Comment</th>
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>
            <%
              List<Comment> comments = (List<Comment>) request.getAttribute("comments");
              if (comments != null) {
                for (Comment comment: comments) {
            %>
            <tr>
              <td><%= comment.getId() %></td>
              <td><%= comment.getEmail() %></td>
              <td><%= comment.getPhone() %></td>
              <td><%= comment.getComment() %></td>
            </tr>
            <%
              }
            } else {
            %>
            <tr>
              <td colspan="5">No data found.</td>
            </tr>
            <% } %>
          </tbody>
        </table>
    </div>
    <%@ include file="scripts.jsp" %>
  </body>
</html>
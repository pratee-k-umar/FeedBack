<html>
<head>
  <%@ include file="links.jsp" %>
</head>
<body>
  <%@ include file="header.jsp" %>
  <h1 class="text-center m-5">FeedBack Form</h1>
  <form action="<%= application.getContextPath() %>/feedback" method="post" class="container w-50">
    <div class="form-floating mb-3">
      <input name="email" type="email" class="form-control" id="floatingInput" placeholder="name@example.com">
      <label for="floatingInput">Email address</label>
    </div>
    <div class="form-floating mb-3">
      <input name="password" type="password" class="form-control" id="floatingPassword" placeholder="Password">
      <label for="floatingPassword">Password</label>
    </div>
    <div class="form-floating mb-3">
      <textarea name="comment" rows="10" cols="" class="form-control" placeholder="Leave a comment here" id="floatingTextarea"></textarea>
      <label for="floatingTextarea">Comments</label>
    </div>
    <div class="d-flex justify-content-between">
      <button type="reset" class="btn btn-danger">Reset</button>
      <button type="submit" class="btn btn-primary">Submit</button>
    </div>
  </form>
</body>
</html>
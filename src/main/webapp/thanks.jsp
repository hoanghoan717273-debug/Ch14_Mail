<%@ page contentType="text/html;charset=UTF-8" %>

<%@ page import="murach.User" %>


<!DOCTYPE html>

<html>

<head>

    <meta charset="UTF-8">

    <title>Thanks for joining</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/main.css">

</head>


<body>

<div class="container">


    <h1>
        Thanks for joining our email list!
    </h1>


    <%

        User user =
                (User) request.getAttribute("user");

    %>


    <%

        if (user != null) {

    %>


        <p>

            Welcome,
            <%= user.getFirstName() %>!

        </p>


        <p>

            A welcome email was prepared for:

            <strong>
                <%= user.getEmail() %>
            </strong>

        </p>


    <%

        }

    %>


    <%

        String errorMessage =
                (String) request.getAttribute(
                        "errorMessage"
                );


        if (errorMessage != null) {

    %>


        <div class="error">

            <%= errorMessage %>

        </div>


    <%

        }

    %>


    <p>

        <a
            href="${pageContext.request.contextPath}/index.jsp">

            Back to the email list

        </a>

    </p>


</div>

</body>

</html>
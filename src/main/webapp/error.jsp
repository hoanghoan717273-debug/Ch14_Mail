<%@ page contentType="text/html;charset=UTF-8" %>


<!DOCTYPE html>

<html>

<head>

    <meta charset="UTF-8">

    <title>Error</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/main.css">

</head>


<body>

<div class="container">


    <h1>
        Error
    </h1>


    <div class="error">

        <%= request.getAttribute("errorMessage") != null
                ? request.getAttribute("errorMessage")
                : "An error occurred." %>

    </div>


    <p>

        <a
            href="${pageContext.request.contextPath}/index.jsp">

            Back

        </a>

    </p>


</div>

</body>

</html>
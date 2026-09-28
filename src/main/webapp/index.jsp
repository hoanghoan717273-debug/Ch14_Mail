<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>

<html>

<head>

    <meta charset="UTF-8">

    <title>Join our email list</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/main.css">

</head>


<body>

<div class="container">


    <h1>Join our email list</h1>


    <p>
        To join our email list,
        enter your information below.
    </p>


    <form
        action="${pageContext.request.contextPath}/emailList"
        method="post">


        <input
            type="hidden"
            name="action"
            value="add">


        <label>
            Email:
        </label>


        <input
            type="email"
            name="email"
            required>


        <label>
            First Name:
        </label>


        <input
            type="text"
            name="firstName"
            required>


        <label>
            Last Name:
        </label>


        <input
            type="text"
            name="lastName"
            required>


        <input
            type="submit"
            value="Join Now">


    </form>


</div>

</body>

</html>
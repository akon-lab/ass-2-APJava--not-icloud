<%--
  Created by IntelliJ IDEA.
  User: ak_he
  Date: 25.09.2020
  Time: 8:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Not ICloud</title>
    <!--icons-->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

    <!--fonts-->
    <link href="https://fonts.googleapis.com/css2?family=Kufam:wght@500&display=swap" rel="stylesheet">
    <!--CSS-->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/index.css">
    <!-- Bootstrap -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
</head>

<body>
<h1 class="logo text-center">
    <div class="fr-cloud">&#9729;</div>
    <a href="<%=request.getContextPath()%>/jsp/index.jsp">
        <sub>&#9729;</sub>Not ICloud<sub>&#9729;</sub>
    </a>
    <div class="sc-cloud">&#9729;</div>
</h1>
<h2 class="text-center font">Upload New File</h2>

<div class="upload-form">
    <div id="result">
        <h4>${requestScope["message"]}</h4>
    </div>

    <form method="post" enctype="multipart/form-data" action="<%=request.getContextPath()%>/upload">
        <input type="file" name="file" id="file" class="inputfile" />
        <label for="file">Choose a file <span style="color: white;">&#9729;</span></label>
        <input type="submit" value="Upload Image">
    </form>
</div>



<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://code.jquery.com/jquery-1.12.4.min.js" integrity="sha384-nvAa0+6Qg9clwYCGGPpDQLVpLNn0fRaROjHqs13t4Ggj3Ez50XnGQqc/r8MhnRDZ" crossorigin="anonymous"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>
</body>

</html>


<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        .tech-logos {
            text-align: center;
            padding: 20px;
        }
        .tech-logos img {
            width: 80px;
            margin: 10px;
        }
        .tech-logos .header {
            font-size: 24px;
            font-weight: bold;
        }
        .tech-logos .header span {
            color: #007bff;
        }

        h1 {
            color: rgb(236, 239, 83);
        }

        h2 {
            margin-bottom: 0;
        }

        .header-container {
            text-align: center;
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">
                <img src="https://www.x-workz.in/static/media/Logo.cf195593dc1b3f921369.png" alt="Xworkz Logo" height="40">
            </a>
        </div>
    </nav>

    <div class="container">
        <div class="header-container">
            <h2>Welcome To X-workz ODC</h2>
        </div>

        <div class="row justify-content-center">
            <div class="col-auto text-center">
                <a href="Signup.jsp" class="btn btn-primary btn-lg mb-2">Signup</a>

            </div>
            <div class="col-auto text-center">
                <a href="Signin.jsp" class="btn btn-secondary btn-lg mb-2">Signin</a>

            </div>
        </div>
    </div>



</body>
</html>


<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Signin</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            background-color: #f4f5f8;
            font-family: Arial, sans-serif;
        }
        .signin-container {

            max-width: 400px;
            margin: 50px auto;
            padding: 35px;
            background-color: #a9a356;
            border-radius: 10px;
            box-shadow: 0 4px 20px rgb(246, 159, 159);
        }
        h2 {
            text-align: center;
            margin-bottom: 30px;
            color: rgb(7, 7, 7);
            font-size: 25px;
        }
        .mb-3{
            color:white;
        }
        h4{
            color:white;
        }
        .btn{
            color:white;
            display:flex;
            justify-content:center;
        }
    </style>
</head>
<body>

<header class="bg-dark py-3">
    <div class="container d-flex justify-content-between align-items-center">
        <div>
            <img src="https://x-workz.in/static/media/Logo.cf195593dc1b3f921369.png" alt="Xworkz Logo" height="50">
        </div>
        <div class="header-buttons d-flex">
            <a href="index.jsp" class="btn btn-outline-light btn-sm me-2">Home</a>
            <a href="Signup.jsp" class="btn btn-outline-light btn-sm">Signup</a>
        </div>
    </div>
</header>

<div class="signin-container">
    <h2>Course Signin</h2>
    <form method="post" action="signin">
        <div class="mb-3">
            <label for="email" class="form-label">Email</label>
            <input type="text" name="email" id="email" class="form-control" required />
        </div>
        <div class="mb-3">
            <label for="password" class="form-label">Password</label>
            <input type="password" name="password" id="password" class="form-control" required />
        </div>
        <div class="btn">
            <button type="submit" class="btn">Signin</button>
        </div>
    </form>
    <h4>${error}</h4>
</div>

</body>
</html>

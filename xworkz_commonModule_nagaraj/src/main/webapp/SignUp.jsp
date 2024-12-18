
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <title>SIGNUP-Xworkz</title>

    <style>
        body {
            background-color: rgba(242, 237, 243, 0.604);
            color: black;
            font-family: apple-system, sans-serif;
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .form-container {
            background-color: #46dff0da;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.5);
            width: 100%;
            max-width: 400px;
        }

        .form-container h3 {
            color: #f9f9f9;
            text-align: center;
            text-shadow: 2px 2px 4px #000;
            margin-bottom: 20px;
        }

        .form-container h2 {
            font-family: Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif;
            color: #24d330;
            text-align: center;
            text-shadow: 3px 3px 5px #000000df;
            margin-bottom: 20px;
        }

        .form-control {
            background-color: #c5eddfe1;
            border: 1px solid #84ff00;
            color: white;
            border-radius: 5px;
        }

        .form-control:focus {
            border-color: #bbf44ac2;
            box-shadow: 0 0 5px rgba(147, 226, 50, 0.5);
        }

        .form-group {
            margin-bottom: 15px;
        }

        .btn-success{
            width: 100%;
        }
        </style>
</head>

<body>
    <div class="form-container">

        <h2>Welcome to Sign Up</h2>
        <h3>Enter your details</h3>
        <form action="signup" method="post">
            <div class="form-group">
                <input type="text" class="form-control" name="name" placeholder="Enter your name" required>
            </div>

            <div class="form-group">
                <input type="email" class="form-control" name="email" placeholder="Enter your email" required>
            </div>


            <div class="form-group">
                <input type="text" class="form-control" name="phno" placeholder="Enter your phno" required>
            </div>

            <div class="form-group">
                <input type="text" class="form-control" name="alterEmail" placeholder="Enter your alterEmail" required>
            </div>
            <div class="form-group">
                <input type="text" class="form-control" name="alterPhno" placeholder="Confirm your alterPhno"
                    required>
            </div>
            <div class="form-group">
                <input type="text" class="form-control" name="location" placeholder="Confirm your location"
                    required>
            </div>

            <div class="form-group">
                <button type="submit" class="btn btn-success">SIGN UP</button>
            </div>
        </form>

        <c:if test="${not empty failure}">
            <div class="error">${failure}</div>
        </c:if>

        <c:if test="${not empty success}">
            <div class="success">${success}</div>
        </c:if>
    </div>
</body>

</html>

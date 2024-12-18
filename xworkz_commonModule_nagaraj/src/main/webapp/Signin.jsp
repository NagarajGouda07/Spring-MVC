<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <title>SIGN IN - Xworkz</title>

    <style>
        body {
            background-color: rgba(207, 237, 238, 0.727);
            color: black;
            font-family: apple-system, sans-serif;
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .form-container {
            background-color: rgb(220, 209, 157);
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
            color: #38c316;
            text-align: center;
            text-shadow: 3px 3px 5px #000000df;
            margin-bottom: 20px;
        }

        .form-control {
            background-color: #bff4b0e1;
            border: 1px solid #84ff00;
            color: black;
            border-radius: 5px;
        }

        .form-control:focus {
            border-color: #bbf44ac2;
            box-shadow: 0 0 5px rgba(147, 226, 50, 0.5);
        }

        .form-group {
            margin-bottom: 15px;
        }

        .btn-success {
            width: 100%;
        }
    </style>
</head>

<body>
    <div class="form-container">
        <h2>Welcome to Sign In</h2>
        <h3>Enter your Details</h3>
        <form action="signin" method="POST">
            <div class="form-group">
                <input type="email" class="form-control" name="email" placeholder="Enter your email" required>
            </div>

            <div class="form-group">
                <input type="password" class="form-control" name="password" placeholder="Enter your password" required>
            </div>

            <div class="form-group">
                <button type="submit" class="btn btn-success">SIGN IN</button>
            </div>
        </form>
    </div>
</body>

</html>
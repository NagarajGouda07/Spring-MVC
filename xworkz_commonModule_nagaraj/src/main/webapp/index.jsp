<!-- <%@ page isELIgnored="false" %> -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>X-workz</title>
        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            margin: 0;
            font-family: Apple-system, sans-serif;
            background: linear-gradient(to right, #d9e4e5, #7ab1b2);
            color: #333;
        }

        .navbar {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 10px 20px;
            background-color: rgb(248, 202, 34);
            box-shadow: 0 4px 6px rgb(128, 213, 246);
        }

        .navbar .logo img {
            height: 60px;
        }

        .navbar .login-btn {
            text-decoration: none;
            color: white;
            background-color: transparent;
            padding: 12px 20px;
            border-radius: 5px;
            transition: background-color 0.3s ease, transform 0.3s ease;
        }

        .navbar .login-btn:hover {
            background-color: #ff7043;
            transform: scale(1.1);
        }

        @keyframes fadeIn {
            0% { opacity: 0; transform: translateY(-30px); }
            100% { opacity: 1; transform: translateY(0); }
        }

        @keyframes slideIn {
            0% { opacity: 0; transform: translateX(-100%); }
            100% { opacity: 1; transform: translateX(0); }
        }

        .heading-animate {
            font-size: 2.5rem;
            font-weight: 600;
            color: #0b1e04;
            text-shadow: 2px 2px 5px rgba(5, 227, 49, 0.2);
        }

        .btn-animate:hover {
            transform: scale(1.1);
            transition: transform 0.3s ease;
        }

        .container {
            padding: 50px 15px;
        }

        .btn {
            background-color: #004d40;
            color: white;
            border-radius: 20px;
            padding: 12px 24px;
            text-transform: uppercase;
            font-weight: 600;
            letter-spacing: 1px;
            transition: background-color 0.3s ease, transform 0.3s ease;
        }

        .btn:hover {
            background-color: #ff7043;
            transform: scale(1.05);
        }

    </style>
</head>
<body>
    <div class="navbar">
        <div class="logo">
            <img src="https://www.x-workz.in/static/media/Logo.cf195593dc1b3f921369.png" alt="X-workz Logo" title="X-workz">
        </div>
    </div>

    <div class="container text-center mt-5">
        <h2 class="heading-animate">Welcome To X-workz</h2>

        <a href="SignUp.jsp" class="btn btn-animate">SIGNUP</a>
        <a href="Signin.jsp" class="btn btn-animate">SIGNIN</a>
    </div>

</body>
</html>

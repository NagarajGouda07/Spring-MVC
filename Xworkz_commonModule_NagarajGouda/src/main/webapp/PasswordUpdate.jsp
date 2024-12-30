
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <title>Password-Update</title>
    <style>
        body {
            background-color: #ccc796;
            font-family: apple-system, sans-serif;
        }
        .signin-container {
            max-width: 400px;
            margin: 50px auto;
            padding: 35px;
            background-color: #bf7171;
            border-radius: 10px;
            box-shadow: 0 4px 20px rgb(20, 19, 19);
        }
        h2, h3 {
            text-align: center;
            margin-bottom: 30px;
            color: rgb(11, 10, 10);
            font-size: 25px;
        }
        .mb-3 {
            color: rgb(14, 13, 13);
        }
        h4 {
            color: rgb(15, 11, 11);
        }
        .btn {
            color: rgb(67, 220, 138);
            display: flex;
            justify-content: center;
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
                <a href="Signin.jsp" class="btn btn-outline-light btn-sm me-2">Signin</a>
                <a href="Signup.jsp" class="btn btn-outline-light btn-sm">Signup</a>
            </div>
        </div>
    </header>

    <div class="signin-container">
        <h3>Update Your Password</h3>

        <form action="updatePassword" method="post">
            <div class="mb-3">
                <label for="email" class="form-label">Email</label>
                <input type="text" class="form-control" id="email" onChange="onEmail()" name="email" required>
                <span id="displayEmail" style="color: red"></span>
            </div>

            <div class="mb-3">
                <label for="newPassword" class="form-label">New Password</label>
                <input type="password" class="form-control" id="newPassword" name="newPassword" required>
                <div id="passwordStrength" class="password-strength"></div>
            </div>

            <div class="mb-3">
                <label for="confirmPassword" class="form-label">Confirm Password</label>
                <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" required>
                <div id="confirmPasswordFeedback" class="invalid-feedback"></div>
            </div>

            <div class="btn">
                <button type="submit" id="submitButton" class="tom">Update Password</button>
            </div>
        </form>
    </div>

    <script>
        function onEmail() {
            console.log('email from jsp');
            var userEmail = document.getElementById('email');
            var emailValue = userEmail.value;

            var xhttp = new XMLHttpRequest();

            xhttp.open("GET", "http://localhost:2004/xworkz_commonModule_osama/userEmail/" + emailValue);
            xhttp.send();

            xhttp.onload = function () {
                console.log(this.responseText)
                document.getElementById("displayEmail").innerHTML = this.responseText;
            }
        }
    </script>
</body>
</html>

<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Signup</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            background-color: #f2f4f7;
            font-family: Arial, sans-serif;
        }
        .signup-container {

            max-width: 500px;
            margin: 50px auto;
            padding: 40px;
            background-color: #4e6ca2;
            border-radius: 12px;
            box-shadow: 0 5px 30px white;
        }
        h2 {
            text-align: center;
            margin-bottom: 30px;
            color: #fff;
            font-size: 25px;
        }
        .form-control {
            margin-bottom: 15px;
        }
        .form-label {
            color: white;
        }
        .error {
            color: red;
            text-align: center;
            margin-top: 10px;
        }
        .btn {
            color: white;
            display: flex;
            justify-content: center;
        }
        .signup-container h4 {
            color: red;
        }
        .error {
            color: red;
            font-size: 14px;
            margin-top: 5px;
        }
        .header-buttons a {
            margin-left: 10px;
            text-decoration: none;
        }
        #nameError, #emailError, #LocationError, #phoneNoError, #alterEmailError, #alterPhoneNoError, #LocationError {
            display: none;
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
        </div>
    </div>
</header>

<div class="signup-container">
    <h2>Course Signup</h2>

<c:forEach items="${error}" var="i">

<span style="color:red"> ${i.message}</span>

</c:forEach>
    <form method="post" action="signup">

        <div class="mb-3">
            <label for="name" class="form-label">Name</label>
            <input type="text" name="name" id="name" class="form-control" onchange="onUserName()" />
            <span id="displayName" class="error"></span>
            <p style="color: red;" id="nameError">Please Enter Name</p>
        </div>

        <div class="mb-3">
            <label for="email" class="form-label">Email</label>
            <input type="text" name="email" id="email" class="form-control" onchange="onEmail()" />
            <span id="displayEmail" class="error"></span>
            <p style="color: red;" id="emailError">Please Enter Email</p>
        </div>
        <div class="mb-3">
            <label for="ph" class="form-label">Phone</label>
            <input type="text" name="ph" id="ph" class="form-control" onchange="onPhone()" />
            <span id="displayPhone" class="error"></span>
            <p style="color: red;" id="phoneNoError">Please Enter PhoneNo</p>
        </div>
        <div class="mb-3">
            <label for="alterEmail" class="form-label">Alter Email</label>
            <input type="text" name="alterEmail" id="alterEmail" class="form-control" onchange="onAlterEmail()" />
            <span id="displayAlterEmail" class="error"></span>
            <p style="color: red;" id="alterEmailError">Please Enter alterEmail</p>
        </div>
        <div class="mb-3">
            <label for="alterPh" class="form-label">Alter Phone</label>
            <input type="text" name="alterPh" id="alterPh" class="form-control" onchange="onAlterPhone()" />
            <span id="displayAlterPhone" class="error"></span>
            <p style="color: red;" id="alterPhoneNoError">Please Enter alterPhoneNo</p>
        </div>
        <div class="mb-3">
            <label for="location" class="form-label">Location</label>
            <input type="text" name="location" id="location" class="form-control" />
            <p style="color: red;" id="LocationError">Please Enter Location</p>


        </div>
        <div class="btn">
            <button id ="button" onclick="signup()" type="submit">Signup</button>
        </div>
    </form>

</div>

<script>
    function signup() {
    var name = document.getElementById("name").value.trim();
    var email = document.getElementById("email").value.trim();
    var ph = document.getElementById("ph").value.trim();
    var alterEmail = document.getElementById("alterEmail").value.trim();
    var alterPh = document.getElementById("alterPh").value.trim();
    var location = document.getElementById("location").value.trim();

    // Regex patterns
    var emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
    var phonePattern = /^[0-9]{10}$/;

    // Name validation
    if (name.length === 0) {
        document.getElementById("nameError").style.display = "block";
    } else {
        document.getElementById("nameError").style.display = "none";
    }

    // Email validation
    if (email.length === 0 || !emailPattern.test(email)) {
        document.getElementById("emailError").innerText = "Please enter a valid email.";
        document.getElementById("emailError").style.display = "block";
    } else {
        document.getElementById("emailError").style.display = "none";
    }

    // Phone validation
    if (ph.length === 0 || !phonePattern.test(ph)) {
        document.getElementById("phoneNoError").innerText = "Please enter a valid 10-digit phone number.";
        document.getElementById("phoneNoError").style.display = "block";
    } else {
        document.getElementById("phoneNoError").style.display = "none";
    }

    // Alternate Email validation
    if (alterEmail.length === 0 || !emailPattern.test(alterEmail)) {
        document.getElementById("alterEmailError").innerText = "Please enter a valid alternate email.";
        document.getElementById("alterEmailError").style.display = "block";
    } else if (alterEmail === email) {
        document.getElementById("alterEmailError").innerText = "Alternate email must be different from the primary email.";
        document.getElementById("alterEmailError").style.display = "block";
    } else {
        document.getElementById("alterEmailError").style.display = "none";
    }

    // Alternate Phone validation
    if (alterPh.length === 0 || !phonePattern.test(alterPh)) {
        document.getElementById("alterPhoneNoError").innerText = "Please enter a valid alternate 10-digit phone number.";
        document.getElementById("alterPhoneNoError").style.display = "block";
    } else if (alterPh === ph) {
        document.getElementById("alterPhoneNoError").innerText = "Alternate phone number must be different from the primary phone number.";
        document.getElementById("alterPhoneNoError").style.display = "block";
    } else {
        document.getElementById("alterPhoneNoError").style.display = "none";
    }

    // Location validation
    if (location.length === 0) {
        document.getElementById("LocationError").style.display = "block";
    } else {
        document.getElementById("LocationError").style.display = "none";
    }

    // Submit form if all fields are valid
    if (
        name.length > 0 &&
        emailPattern.test(email) &&
        phonePattern.test(ph) &&
        emailPattern.test(alterEmail) &&
        alterEmail !== email &&
        phonePattern.test(alterPh) &&
        alterPh !== ph &&
        location.length > 0
     );

}
    function onUserName() {
        console.log('this is on Name');
        var name = document.getElementById('name');
        var nameValue = name.value;

        var xhttp = new XMLHttpRequest();
        xhttp.open("GET", "http://localhost:8086/Xworkz_commonModule_NagarajGouda/name/" + nameValue);
        xhttp.send();

        xhttp.onload = function() {
            console.log(this.responseText)
            document.getElementById("displayName").innerHTML = this.responseText;
        }
    }

    function onEmail() {
        var email = document.getElementById('email');
        var emailValue = email.value;
        var alterEmail = document.getElementById('alterEmail').value;

        var xhttp = new XMLHttpRequest();
        xhttp.open("GET", "http://localhost:8086/Xworkz_commonModule_NagarajGouda/email/" + emailValue + "?alterEmail=" + alterEmail);
        xhttp.send();

        xhttp.onload = function() {
            document.getElementById("displayEmail").innerHTML = this.responseText;
        }
    }


function onPhone() {
    var phone = document.getElementById('ph');
    var phoneValue = phone.value;
    var alterPhone = document.getElementById('alterPh').value;

    var xhttp = new XMLHttpRequest();
    xhttp.open("GET", "http://localhost:8086/Xworkz_commonModule_NagarajGouda/phone/" + phoneValue + "?alterPhone=" + alterPhone);
    xhttp.send();

    xhttp.onload = function() {
        document.getElementById("displayPhone").innerHTML = this.responseText;
    }
}

    function onAlterEmail() {
        var alterEmail = document.getElementById('alterEmail');
        var alterEmailValue = alterEmail.value;
        var email = document.getElementById('email').value;

        var xhttp = new XMLHttpRequest();
        xhttp.open("GET", "http://localhost:8086/Xworkz_commonModule_NagarajGouda/alterEmail/" + alterEmailValue + "?email=" + email);
        xhttp.send();

        xhttp.onload = function() {
            document.getElementById("displayAlterEmail").innerHTML = this.responseText;
        }
    }


function onAlterPhone() {
    var alterPhone = document.getElementById('alterPh');
    var alterPhoneValue = alterPhone.value;
    var phone = document.getElementById('ph').value;

    var xhttp = new XMLHttpRequest();
    xhttp.open("GET", "http://localhost:8086/Xworkz_commonModule_NagarajGouda/alterPhone/" + alterPhoneValue + "?phone=" + phone);
    xhttp.send();

    xhttp.onload = function() {
        document.getElementById("displayAlterPhone").innerHTML = this.responseText;
    }
}
</script>

</body>
</html>
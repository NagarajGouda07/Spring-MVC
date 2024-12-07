<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
<h2>Passport Application</h2>
<form action ="passport" method ="post">
    Full Name: <input type="text" id="fullName" name="fullName" placeholder="Enter your full name"><br><br>

    Date of Birth: <input type="date" id="dob" name="dob"><br><br>

     Gender: <select id="gender" name="gender">
        <option value="male">Male</option>
        <option value="female">Female</option>
        <option value="other">Other</option>
    </select><br><br>

     Nationality: <input type="text" id="nationality" name="nationality" placeholder="Enter your nationality"><br><br>

    Address: <textarea id="address" name="address" rows="4" cols="50" placeholder="Enter your current address"></textarea><br><br>

    Passport Type:
    <select id="passportType" name="passportType">
        <option value="regular">Regular</option>
        <option value="official">Official</option>
        <option value="diplomatic">Diplomatic</option>
    </select><br><br>

     Application ID: <input type="text" id="applicationID" name="applicationID" placeholder="Enter your application ID"><br><br>

     Upload Photo: <input type="file" id="photoUpload" name="photoUpload" accept="image/*"><br><br>

     Upload Documents: <input type="file" id="documentsUpload" name="documentsUpload" accept="application/pdf, image/*"><br><br>

    <button type="submit">Submit</button>
</form>


</body>
</html>
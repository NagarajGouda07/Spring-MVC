<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Product</title>
</head>
<body>
${message}, ${ProductDTO.name}

    <h1>Product Form</h1>
    <form action="product" method="post">
        Name : <input type="text" name="name" value="${productDTO.name}"><br><br>
        Type : <select name="type" id="">
                    <option value="Electronics" ${productDto.type == 'Electronics' ? 'selected' : ''}>Electronics</option>
                    <option value="Furniture" ${productDto.type == 'Furniture' ? 'selected' : ''}>Furniture</option>
                    <option value="Clothing" ${productDto.type == 'Clothing' ? 'selected' : ''}>Clothing</option>
                </select><br><br>
        Cost : <input type="text" name="cost" value="${productDto.cost}" ><br><br>
        Manufacturer : <select name="manufacturer" id="">
                            <option value="Sony" ${productDto.manufacturer == 'Sony' ? 'selected' : ''}>Sony</option>
                            <option value="Samsung" ${productDto.manufacturer == 'Samsung' ? 'selected' : ''}>Samsung</option>
                            <option value="Ikea" ${productDto.manufacturer == 'Ikea' ? 'selected' : ''}>Ikea</option>
                       </select><br><br>
        Manufacturer Date : <input type="date" name="manufactureDate" value="${productDto.manufactureDate}"><br><br>
        Warranty : <input type="text" name="warranty" value="${productDto.warranty}"><br><br>
        <button type="submit">Save</button>
    </form>


</body>
</html>
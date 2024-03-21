<!DOCTYPE html>
<html>
<head>
    <title>Роль пользователя</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f0f0f0;
        }
        .container {
            max-width: 600px;
            margin: 50px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            text-align: center;
        }
        p {
            text-align: center;
            margin-top: 20px;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Роль пользователя</h1>
    <p>
        <#if role == "Admin">
            Вы вошли как администратор.
        <#elseif role == "User">
            Вы вошли как обычный пользователь.
        <#else>
            Не удалось определить вашу роль.
        </#if>
    </p>
</div>
</body>
</html>

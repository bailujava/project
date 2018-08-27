<%@page pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<html>
<head>
    <script type="text/javascript">
        $(".xx").click(function () {
            var href = $(this).attr("href");
            $("#xxx").attr("action", href).submit();
            return false;
        })
    </script>
</head>
<body>
<a class="xx" href="/user/60">KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK</a>
<form action="" method="post" id="xxx">
    <input type="hidden" name="_method" value="DELETE">
</form>
</body>
</html>

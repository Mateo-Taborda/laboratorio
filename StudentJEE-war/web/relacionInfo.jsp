<%-- 
    Document   : relacionInfo
    Created on : 7/04/2023, 10:33:56 PM
    Author     : mateo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>relacion Information</h1>
        <form action="./RelacionServlet" method="POST">
            <table>
                <tr>
                    <td>Id Estudiante</td>
                    <td><input type="text" name="student" value="${estudiante_curso.student}" /></td>
                </tr>
                <tr>
                    <td>Codigo Curso</td>
                    <td><input type="text" name="curso" value="${estudiante_curso.curso}" /></td>
                </tr>
                <tr>
                    <td>Nota</td>
                    <td><input type="text" name="nota" value="${estudiante_curso.nota}" /></td>
                </tr>
              
                
                <tr>
                    <td colspan="2">
                        <input type="submit" name="action" value="Add" />
                        <input type="submit" name="action" value="Edit" />
                        <input type="submit" name="action" value="Delete" />
                        <input type="submit" name="action" value="Search" />
                    </td>
                </tr>
            </table>
        </form>
        <br>
        <table border="1">
            <th>ID</th>
            <th>Codigo Curso</th>
            <th>Nota</th>
         
                <c:forEach items="${allRelacion}" var="rela">
                <tr>
                    <td>${rela.student}</td>
                    <td>${rela.Curso}</td>
                    <td>${rela.nota}</td>
                 
                </tr>
            </c:forEach> 
        </table>
    </body>
</html>

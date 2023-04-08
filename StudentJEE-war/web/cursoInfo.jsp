<%-- 
    Document   : cursoInfo
    Created on : 7/04/2023, 07:43:32 PM
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
        <h1>course Information</h1>
        <form action="./CursoServlet" method="POST">
            <table>
                <tr>
                    <td>Codigo Curso</td>
                    <td><input type="text" name="codigo_curso" value="${curso.codigoCurso}" /></td>
                </tr>
                <tr>
                    <td>Nombre Curso</td>
                    <td><input type="text" name="nombre_curso" value="${curso.nombre_curso}" /></td>
                </tr>
                <tr>
                    <td>Numero Creditos</td>
                    <td><input type="text" name="numero_creditos" value="${curso.numero_creditos}" /></td>
                </tr>
                <tr>
                    <td>Semestre</td>
                    <td><input type="text" name="semestre" value="${curso.semestre}" /></td>
                </tr>
                 <tr>
                    <td>Numero Estudiantes Adimitidos</td>
                    <td><input type="text" name="num_estudiantes_admitidos" value="${curso.num_estudiantes_admitidos}" /></td>
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
            <th>Nombre Curso</th>
            <th>Numero Creditos</th>
            <th>Semestre</th>
             <th>Numero Estudiantes Adimitidos</th>
                <c:forEach items="${allCourse}" var="course">
                <tr>
                    <td>${course.codigoCurso}</td>
                    <td>${course.nombreCurso}</td>
                    <td>${course.numeroCreditos}</td>
                    <td>${course.semestre}</td>
                    <td>${course.numEstudiantesAdmitidos}</td>
                </tr>
            </c:forEach> 
        </table>
    </body>
</html>

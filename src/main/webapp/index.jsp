<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Students Page</title>
    <link rel="stylesheet" href="style.css">
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
    <script type="text/javascript" src="script.js"></script>
</head>
<body>

<div class="tabs">
    <!-- Кнопка-переключатель и название первого таба -->
    <input type="radio" name="tabs" id="tab-first" checked >
    <label for="tab-first">
        <p>Students</p>
    </label>
    <!-- Кнопка-переключатель и название второго таба -->
    <input type="radio" name="tabs" id="tab-second">
    <label for="tab-second">
        <p>Professors</p>
    </label>
    <!-- Кнопка-переключатель и название третьего таба -->
    <input type="radio" name="tabs" id="tab-third">
    <label for="tab-third">
        <p>Balls</p>
    </label>
    <!-- Вывод контента наших табов -->
    <div id="tab-content-1" class="tab-content">
        <p>
            <!-- контент под таб№1 -->
        <h1>Student List</h1>


        <table>
            <tr>
                <td width="70">ID</td>
                <td width="70">familyStudent</td>
                <td width="70">nameStudent</td>
                <td width="70">nameFatherStudent</td>
                <td width="70">birthdate</td>
                <td width="70">nameGroup</td>
                <td width="70">Edit</td>
                <td width="70">Delete</td>
            </tr>
            <c:forEach items="${listStudents}" var="student">
                <tr>
                    <td>${student.id}</td>
                    <td>${student.familyStudents}</td>
                    <td>${student.nameStudents}</td>
                    <td>${student.nameFatherStudents}</td>
                    <td>${student.birthdate}</td>
                    <td>${student.idGroup}</td>
                    <td><a href="/edit/${student.id}">Edit</a></td>
                    <td><a href="/remove/${student.id}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
        </p>
        <div class="link_group">
            <a class="show_popup" rel="reg_form" href="#">Add</a>
            <div class="popup reg_form">
                <h2>Add a Student</h2>
                <c:url var="addAction" value="/index/addSt"/>
                <form action="${addAction}" commandName="student">
                    <table>
                        <c:if test="${!empty student.familyStudents}">
                            <tr>
                                <td>
                                    <label path="id">
                                        ID
                                    </label>
                                </td>
                                <td>
                                    <input path=${student.id} readonly="true" size="8" disabled="true"/>
                                </td>
                            </tr>
                        </c:if>
                        <tr>
                            <td>
                                <label path="familyStudents">
                                    Family
                                </label>
                            </td>
                            <td>
                                <input path=${student.familyStudents}/>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <c:if test="${!empty student.familyStudents}">
                                    <input type="submit"
                                           value="EDIT"/>
                                </c:if>
                                <c:if test="${empty student.familyStudents}">
                                    <input type="submit"
                                           value="ADD"/>
                                </c:if>
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
    </div> <!-- #tab-content-1 -->
    <div id="tab-content-2" class="tab-content">
        <p><!-- контент под таб№2 -->
        <h1>Professors List</h1>


        <table>
            <tr>
                <td width="80">ID</td>
                <td width="120">nameGroup</td>
                <td width="60">Edit</td>
                <td width="60">Delete</td>
            </tr>
            <forEach items="${listGroups}" var="groups">
                <tr>
                    <td>${groups.id}</td>
                    <td><a href="/groupsdata/${groups.id}" target="_blank">${groups.nameGroup}</a></td>
                    <td><a href="/edit/${groups.id}">Edit</a></td>
                    <td><a href="/remove/${groups.id}">Delete</a></td>
                </tr>
            </forEach>
        </table>
        </p>
        <div class="link_group">
            <a class="show_popup" rel="reg_form" href="#">Add</a>
            <div class="popup reg_form">
                <h2>Add a Group</h2>
                <form method="post" action="">
                    <label for="login">Введите логин:</label>
                    <input type="text" name="login" />
                    <label for="password">Введите пароль:</label>
                    <input type="password" name="password" />
                    <input type="submit" value="Cancel" />
                    <input type="submit" value="Add" />
                </form>
            </div>
        </div>
    </div> <!-- #tab-content-2 -->
    <div id="tab-content-3" class="tab-content">
        <p>
            <!-- контент под таб№3 -->
        <h1>Balls</h1>


        <table>
            <tr>
                <td width="80">ID</td>
                <td width="120">nameGroup</td>
                <td width="60">Edit</td>
                <td width="60">Delete</td>
            </tr>
            <forEach items="${listGroups}" var="groups">
                <tr>
                    <td>${groups.id}</td>
                    <td><a href="/groupsdata/${groups.id}" target="_blank">${groups.nameGroup}</a></td>
                    <td><a href="/edit/${groups.id}">Edit</a></td>
                    <td><a href="/remove/${groups.id}">Delete</a></td>
                </tr>
            </forEach>
        </table>
        </p>
        <div class="link_group">
            <a class="show_popup" rel="reg_form" href="#">Add</a>
            <div class="popup reg_form">
                <h2>Add a Group</h2>
                <form method="post" action="">
                    <label for="login">Введите логин:</label>
                    <input type="text" name="login" />
                    <label for="password">Введите пароль:</label>
                    <input type="password" name="password" />
                    <input type="submit" value="Cancel" />
                    <input type="submit" value="Add" />
                </form>
            </div>
        </div>
    </div> <!-- #tab-content-3 -->
</div>

</body>
</html>

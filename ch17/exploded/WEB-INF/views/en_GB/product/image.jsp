<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<form action="image.html" method="post" enctype="multipart/form-data">
    <table>
        <tr>
            <td>Name</td>
            <td>
                <spring:bind path="product.name">
                    <input name="name" value="<c:out value="${status.value}"/>">
                    <span class="error"><c:out value="${status.errorMessage}"/></span>
                </spring:bind>
            </td>
        </tr>
        <tr>
            <td>Image</td>
            <td>
                <spring:bind path="product.contents">
                    <input name="contents" type="file">
                    <span class="error"><c:out value="${status.errorMessage}"/></span>
                </spring:bind>
            </td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit"></td>
        </tr>
    </table>
</form>
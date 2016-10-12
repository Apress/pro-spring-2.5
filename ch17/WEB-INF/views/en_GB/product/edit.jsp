<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form commandName="product" action="editProduct.html">
    <table>
        <tr>
            <td>Product name:</td>
            <td><form:input path="name" /></td>
        </tr>
         <tr>
            <td>Product type:</td>
            <td><form:select path="type">
            <form:option value="-" label="--Please Select"/>
            <form:options items="${types}"/>
        </form:select></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Save Changes" />
            </td>
        </tr>
    </table>
</form:form>



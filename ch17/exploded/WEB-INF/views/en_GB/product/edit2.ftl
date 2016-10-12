<#import "/spring.ftl" as spring />

<!-- freemarker macros have to be imported into a namespace.  We strongly
recommend sticking to 'spring' -->
<#import "spring.ftl" as spring />
<html>

<form action="" method="POST">
  Name:
  <@spring.formInput "product.name" />
  <#list spring.status.errorMessages as error> <b>${error}</b> <br> </#list>
  <br>
  Date:
    <@spring.formInput "product.expirationDate"/>
    <#list spring.status.errorMessages as error> <b>${error}</b> <br> </#list>
  <input type="submit" value="submit"/>
</form>

</html>

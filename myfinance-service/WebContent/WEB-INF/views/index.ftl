{
	
	<#list users as user>
	{
		"ID":"${user.id}" ,
		 "name":"${user.name}" ,
		 "username":"${user.userName}",
		 "password":"${user.password}"
	}
	<#if user_has_next>,</#if>
	</#list>
}
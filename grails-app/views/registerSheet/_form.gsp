<%@ page import="uk.ac.shu.webarch.eRegister.RegisterSheet" %>



<div class="fieldcontain ${hasErrors(bean: registerSheetInstance, field: 'regclass', 'error')} required">
	<label for="regclass">
		<g:message code="registerSheet.regclass.label" default="Regclass" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="regclass" name="regclass.id" from="${uk.ac.shu.webarch.eRegister.RegClass.list()}" optionKey="id" required="" value="${registerSheetInstance?.regclass?.id}" class="many-to-one"/>
</div>


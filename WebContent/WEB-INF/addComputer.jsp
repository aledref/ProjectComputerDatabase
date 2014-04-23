<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../include/header.jsp" />
<section id="main">

	<h1>Add Computer</h1>
	
	<form action="addComputer" method="POST">
		<fieldset>
			<div class="clearfix">
				<label for="name">Computer name:</label>
				<div class="input">
					<input type="text" name="name" />
					<span class="help-inline">Required</span>
				</div>
			</div>
	
			<div class="clearfix">
				<label for="introduced">Introduced date:</label>
				<div class="input">
					<input type="date" name="introducedDate" pattern="YY-MM-dd"/>
					<span class="help-inline">YYYY-MM-DD</span>
				</div>
			</div>
			<div class="clearfix">
				<label for="discontinued">Discontinued date:</label>
				<div class="input">
					<input type="date" name="discontinuedDate" pattern="YY-MM-dd"/>
					<span class="help-inline">YYYY-MM-DD</span>
				</div>
			</div>
			<div class="clearfix">
				<label for="company">Company Name:</label>
				<div class="input">
					<select name="companyid">
							<option selected value="0">--</option>
						<c:forEach items="${companylist}" var="company">
							<option value="${company.id}">${company.name}</option>
						</c:forEach>
					</select>
				</div>
			</div>
		</fieldset>
		
		<div class="actions">
			<input type="submit" value="add" class="btn btn-success">
			or <a href="dashboard" class="btn btn-danger">Cancel</a>
		</div>
	</form>
</section>

<jsp:include page="../include/footer.jsp" />
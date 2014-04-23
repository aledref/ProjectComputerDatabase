<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../include/header.jsp" />

<section id="main">
	<h1 id="homeTitle">${computerlistsize} Computers found.</h1>
	<div id="actions">
		<form action="searchComputer" method="GET">
			<input type="search" id="searchbox" name="namefilter"
				value="" placeholder="Search name">
			<input type="submit" id="searchsubmit"
				value="Filter by name"
				class="btn btn-primary">
		</form>
		
		<a class="btn btn-success" id="add" href="addComputer" >Add Computer</a>
		
	</div>

		<table class ="table table-bordered">
			<thead>
				<tr>
					<!-- Variable declarations for passing labels as parameters -->
					<!-- Table header for Computer Name -->
					<th>Computer Name</th>
					<!-- Table header for Introduced Date -->
					<th>Introduced Date</th>
					<!-- Table header for Discontinued Date -->
					<th>Discontinued Date</th>
					<!-- Table header for Company Name-->
					<th>Company</th>
					<!-- Table header for Edit buttons-->
					<th> </th>
					<!-- Table header for Delete buttons-->
					<th> </th>
				</tr>
			</thead>
			
	<!--  Affichage de la page I de Computer de la base de données -->	
			<tbody>			
			<c:forEach items="${computerlist}" var="comp">
				<tr>
					<td><a href="#">${comp.name}</a></td>
					<td>${comp.introduced}</td>
					<td>${comp.discontinued}</td>
					<td>${comp.company.name}</td>
					<td> <form action="editComputer" method="GET">
						 <input type="submit" class="btn btn-warning" name="ebutton" value="Edit" >
						 <input type="hidden" name="eid" value="${comp.id}">
						 </form>
					</td>
					<td> <form action="removeComputer" method="POST">
						 <input type="submit" class="btn btn-danger" name="rbutton" value="Delete" >
						 <input type="hidden" name="rid" value="${comp.id}">
						 </form>
					</td>
				</tr>
			</c:forEach>
				
			</tbody>
		</table>
</section>

<jsp:include page="../include/footer.jsp" />

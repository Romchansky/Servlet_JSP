<div class="navigation">
    <a href="${pageContext.request.contextPath}/">Home</a>
    <div class="dropdown">
        <button class="dropbtn">Company
            <i></i>
        </button>
        <div class="dropdown-content">
            <a href="${pageContext.request.contextPath}/VIEW/company/create_company.jsp">Crete company</a>
            <a href="${pageContext.request.contextPath}/VIEW/company/find_company.jsp">Find by ID</a>
            <a href="${pageContext.request.contextPath}/VIEW/company/update_company.jsp">Update company</a>
            <a href="${pageContext.request.contextPath}/VIEW/company/delete_company.jsp">Delete company</a>
            <a href="${pageContext.request.contextPath}/VIEW/company/all_companies.jsp">View all companies</a>
        </div>
    </div>
    <div class="dropdown">
        <button class="dropbtn">Developer
            <i></i>
        </button>
        <div class="dropdown-content">
            <a href="${pageContext.request.contextPath}/VIEW/developer/create_developer.jsp">Create developer</a>
            <a href="${pageContext.request.contextPath}/VIEW/developer/find_developer.jsp">Find by ID</a>
            <a href="${pageContext.request.contextPath}/VIEW/developer/update_developer.jsp">Update developer</a>
            <a href="${pageContext.request.contextPath}/VIEW/developer/delete_developer.jsp">Delete developer</a>
            <a href="${pageContext.request.contextPath}/VIEW/developer/all_developers.jsp">View all developers</a>
        </div>
    </div>
    <div class="dropdown">
        <button class="dropbtn">Project
            <i></i>
        </button>
        <div class="dropdown-content">
            <a href="${pageContext.request.contextPath}/VIEW/project/create_project.jsp">Create Project</a>
            <a href="${pageContext.request.contextPath}/VIEW/project/find_project.jsp">Find by ID</a>
            <a href="${pageContext.request.contextPath}/VIEW/project/update_project.jsp">Update project</a>
            <a href="${pageContext.request.contextPath}/VIEW/project/delete_project.jsp">Delete project</a>
            <a href="${pageContext.request.contextPath}/VIEW/project/all_projects.jsp">View all projects</a>
        </div>
    </div>
    <div class="dropdown">
        <button class="dropbtn">Customer
            <i></i>
        </button>
        <div class="dropdown-content">
            <a href="${pageContext.request.contextPath}/VIEW/customer/create_customer.jsp">Create customer</a>
            <a href="${pageContext.request.contextPath}/VIEW/customer/find_customer.jsp">Find by ID</a>
            <a href="${pageContext.request.contextPath}/VIEW/customer/update_customer.jsp">Update customer</a>
            <a href="${pageContext.request.contextPath}/VIEW/customer/delete_customer.jsp">Delete customer</a>
            <a href="${pageContext.request.contextPath}/VIEW/customer/all_customers.jsp">View all customers</a>
        </div>
    </div>
    <div class="dropdown">
        <button class="dropbtn">Other operation
            <i></i>
        </button>
        <div class="dropdown-content">
            <a href="${pageContext.request.contextPath}/VIEW/query/get_developers_by_project.jsp">Developers on project</a>
            <a href="${pageContext.request.contextPath}/VIEW/query/get_salary.jsp">Developers salary</a>
            <a href="${pageContext.request.contextPath}/VIEW/query/get_level.jsp">Developers by level</a>
            <a href="${pageContext.request.contextPath}/VIEW/query/get_language.jsp">Developers by language</a>
        </div>
    </div>
</div>
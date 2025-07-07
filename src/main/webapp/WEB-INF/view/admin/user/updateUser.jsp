<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <title>Create User</title>
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

            </head>

            <body>
                <div class="container mt-5">
                    <div class="row">
                        <div class="col-md-6 col-12 mx-auto">
                            <h3>Update User</h3>
                            <hr>
                            <form:form action="/admin/user/update/${id}" method="POST" modelAttribute="user">
                                <div class="mb-3" style="display: none;">
                                    <label class="form-label" for="Password">Id</label>
                                    <form:input class="form-control" id="Password" type="id" path="id" />
                                </div>

                                <div class="mb-3">
                                    <label class="form-label" for="Email">Email address</label>
                                    <form:input class="form-control" id="Email" type="email" path="email"
                                        disabled="true" />
                                </div>


                                <div class="mb-3">
                                    <label class="form-label" for="FullName">Full Name</label>
                                    <form:input class="form-control" id="fullName" type="text" path="fullName" />
                                </div>
                                <div class="mb-3">
                                    <label class="form-label" for="Phone">Phone Number</label>
                                    <form:input class="form-control" type="text" path="phone" />
                                </div>
                                <div class="mb-3">
                                    <label class="form-label" for="Address">Address</label>
                                    <form:input class="form-control" id="Address" type="text" path="address" />
                                </div>

                                <button class="btn btn-primary" type="submit">Submit</button>
                            </form:form>
                        </div>
                    </div>
                </div>
            </body>

            </html>
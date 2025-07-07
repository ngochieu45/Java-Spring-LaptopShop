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
                        <div class="col-md-11 col-12 mx-auto">
                            <div class="d-flex justify-content-between align-items-center mb-3">
                                <h3 class="m-0">User Detail ${id}</h3>
                                <hr>

                            </div>
                            <hr>
                            <div class="card" style="width: 60%;">
                                <div class="card-header">
                                    User Information
                                </div>
                                <ul class="list-group list-group-flush">
                                    <li class="list-group-item">ID: ${user.id}</li>
                                    <li class="list-group-item">Email: ${user.email}</li>
                                    <li class="list-group-item">fullName: ${user.fullName}</li>
                                    <li class="list-group-item">Address: ${user.address}</li>
                                    <li class="list-group-item">Phone: ${user.phone}</li>
                                </ul>
                            </div>
                            <a href="/admin/user" class=" btn btn-success">back</a>
                        </div>
                    </div>
                </div>
            </body>

            </html>
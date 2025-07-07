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
                                <h3 class="m-0">Delete User</h3>
                            </div>
                            <hr>
                            <div class="alert alert-danger" role="alert">
                                Sure you want to delete this user id = ${id}
                            </div>
                            <form action="/admin/user/delete/${id}" method="post" class="d-inline">
                                <button type="submit" class="btn btn-danger">Delete User</button>
                            </form>
                        </div>
                    </div>
                </div>
            </body>

            </html>
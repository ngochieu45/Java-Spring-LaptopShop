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
                                <h3 class="m-0">Table User</h3>
                                <form action="/admin/user/create" method="POST" class="d-inline">
                                    <button type="submit" class="btn btn-primary">Create User</button>
                                </form>
                            </div>
                            <hr>
                            <table class="table table-bordered">
                                <thead>
                                    <tr>
                                        <th scope="col">ID</th>
                                        <th scope="col">Email</th>
                                        <th scope="col">FullName</th>
                                        <th scope="col">Action</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <th scope="row">1</th>
                                        <td>Mark</td>
                                        <td>Otto</td>
                                        <td><button class="btn btn-success">view</button>
                                            <button class="btn btn-warning">update</button>
                                            <button class="btn btn-danger">delete</button>
                                        </td>

                                    </tr>
                                    <tr>
                                        <th scope="row">2</th>
                                        <td>Jacob</td>
                                        <td>Thornton</td>
                                        <td><button class="btn btn-success">view</button>
                                            <button class="btn btn-warning">update</button>
                                            <button class="btn btn-danger">delete</button>
                                        </td>

                                    </tr>
                                    <tr>
                                        <th scope="row">3</th>
                                        <td>Larry the Bird</td>
                                        <td>Larry the Bird</td>
                                        <td><button class="btn btn-success">view</button>
                                            <button class="btn btn-warning">update</button>
                                            <button class="btn btn-danger">delete</button>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </body>

            </html>
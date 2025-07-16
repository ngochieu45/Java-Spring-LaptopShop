<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="utf-8" />
                <meta http-equiv="X-UA-Compatible" content="IE=edge" />
                <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
                <meta name="description" content="Hỏi Dân IT - Dự án laptopshop" />
                <meta name="author" content="Hỏi Dân IT" />
                <title>Dashboard - Hỏi Dân IT</title>
                <link href="/css/styles.css" rel="stylesheet" />
                <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
                <script>
                    $(document).ready(() => {
                        const avatarFile = $("#avatarFile");
                        avatarFile.change(function (e) {
                            const imgURL = URL.createObjectURL(e.target.files[0]);
                            $("#avatarPreview").attr("src", imgURL);
                            $("#avatarPreview").css({ "display": "block" });
                        });
                    }); 
                </script>
                <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>

            </head>

            <body class="sb-nav-fixed">
                <jsp:include page="../layout/header.jsp" />
                <div id="layoutSidenav">
                    <jsp:include page="../layout/sidebar.jsp" />
                    <div id="layoutSidenav_content">
                        <main>
                            <div class="container-fluid px-4">
                                <h1 class="mt-4">Create User</h1>
                                <ol class="breadcrumb mb-4">
                                    <li class="breadcrumb-item"><a href="/admin">Dashboard</a></li>
                                    <li class="breadcrumb-item active">Create User</li>
                                </ol>
                                <div class="mt-5">
                                    <div class="row">
                                        <div class="col-md-6 col-12 mx-auto">
                                            <h3>Create User</h3>
                                            <hr>
                                            <form:form action="/admin/user/create" method="POST"
                                                modelAttribute="newUser" enctype="multipart/form-data">
                                                <div class="row g-3">
                                                    <div class="col">
                                                        <label class="form-label" for="Email">Email</label>
                                                        <form:input class="form-control" id="Email" type="email"
                                                            path="email" />
                                                    </div>

                                                    <div class="col">
                                                        <label class="form-label" for="Password">Password</label>
                                                        <form:input class="form-control" id="Password" type="password"
                                                            path="password" />
                                                    </div>
                                                </div>

                                                <div class="row g-3">
                                                    <div class="col">
                                                        <label class="form-label" for="FullName">Full Name</label>
                                                        <form:input class="form-control" type="text" path="fullName" />
                                                    </div>

                                                    <div class="col">
                                                        <label class="form-label" for="Phone">Phone Number</label>
                                                        <form:input class="form-control" type="text" path="phone" />
                                                    </div>
                                                </div>

                                                <div class="mb-3">
                                                    <label class="form-label" for="Address">Address</label>
                                                    <form:input class="form-control" id="Address" type="text"
                                                        path="address" />
                                                </div>

                                                <div class="row g-3">
                                                    <div class="col">
                                                        <label for="formFile" class="form-label">Role</label>
                                                        <form:select class="form-select" path="role.name">
                                                            <form:option value="User">User</form:option>
                                                            <form:option value="Admin">Admin</form:option>
                                                        </form:select>
                                                    </div>

                                                    <div class="col">
                                                        <label for="avatarFile" class="form-label">Avatar</label>
                                                        <input class="form-control" type="file" id="avatarFile"
                                                            accept=".jpg, .png, .jpeg" name="avatarFile" />
                                                    </div>

                                                    <div class="col-12 mb-3">
                                                        <img style="max-height: 250px; display: none;"
                                                            alt="avatar preview" id="avatarPreview" />
                                                    </div>
                                                </div>
                                                <div class="col-12 mb-5">
                                                    <button class="btn btn-primary" type="submit">Submit</button>
                                                </div>
                                            </form:form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </main>
                        <jsp:include page="../layout/footer.jsp" />
                    </div>
                </div>
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
                    crossorigin="anonymous"></script>
                <script src="js/scripts.js"></script>
            </body>

            </html>
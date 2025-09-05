<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
            <%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
                <!DOCTYPE html>
                <html lang="en">

                <head>
                    <meta charset="utf-8" />
                    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
                    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
                    <title>Update User</title>
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
                    <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js"
                        crossorigin="anonymous"></script>

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
                                        <li class="breadcrumb-item active">Update User</li>
                                    </ol>
                                    <div class="mt-5">
                                        <div class="row">
                                            <div class="col-md-6 col-12 mx-auto">
                                                <h3>Update User</h3>
                                                <hr>
                                                <form:form action="/admin/user/update/${user.id}" method="POST"
                                                    modelAttribute="user" enctype="multipart/form-data">
                                                    <div class="row g-3">
                                                        <div class="col">
                                                            <c:set var="errorEmail">
                                                                <form:errors path="email" cssClass="invalid-feedback" />
                                                            </c:set>

                                                            <label class="form-label" for="Email">Email</label>
                                                            <form:input
                                                                class="form-control ${not empty errorEmail ? 'is-invalid' : ''}"
                                                                type="email" path="email" />
                                                            ${errorEmail}
                                                        </div>

                                                        <div class="col">
                                                            <c:set var="errorPassword">
                                                                <form:errors path="password"
                                                                    cssClass="invalid-feedback" />
                                                            </c:set>
                                                            <label class="form-label" for="Password">Password</label>
                                                            <form:input
                                                                class="form-control ${not empty errorPassword ? 'is-invalid' : ''}"
                                                                id="Password" type="password" path="password" />
                                                            ${errorPassword}
                                                        </div>
                                                    </div>

                                                    <div class="row g-3">
                                                        <div class="col">
                                                            <c:set var="errorFullName">
                                                                <form:errors path="fullName"
                                                                    cssClass="invalid-feedback" />
                                                            </c:set>
                                                            <label class="form-label" for="FullName">Full Name</label>
                                                            <form:input
                                                                class="form-control ${not empty errorFullName ? 'is-invalid' : ''}"
                                                                type="text" path="fullName" />
                                                            ${errorFullName}
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
                                                            <form:select class="form-select" path="role.id">
                                                                <form:option value="1">Admin</form:option>
                                                                <form:option value="2">User</form:option>
                                                            </form:select>
                                                        </div>

                                                        <div class="col">
                                                            <label for="avatarFile" class="form-label">Avatar</label>
                                                            <input class="form-control" type="file" path="avatar"
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
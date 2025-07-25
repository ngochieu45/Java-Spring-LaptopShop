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
                                <h1 class="mt-4">Create Product</h1>
                                <ol class="breadcrumb mb-4">
                                    <li class="breadcrumb-item"><a href="/admin">Dashboard</a></li>
                                    <li class="breadcrumb-item active">Create Product</li>
                                </ol>
                                <div class="mt-5">
                                    <div class="row">
                                        <div class="col-md-6 col-12 mx-auto">
                                            <h3>Create Product</h3>
                                            <hr>
                                            <form:form action="/admin/product/create" method="POST"
                                                modelAttribute="newProduct" enctype="multipart/form-data">

                                                <div class="row g-3">
                                                    <div class="mb-3 col-12 col-md-6">
                                                        <c:set var="errorName">
                                                            <form:errors path="name" cssClass="invalid-feedback" />
                                                        </c:set>
                                                        <label class="form-label" for="Name">Name</label>
                                                        <form:input
                                                            class="form-control form-control-lg ${not empty errorName ? 'is-invalid' : ''}"
                                                            id="Name" type="text" path="name" />
                                                        ${errorName}
                                                    </div>

                                                    <div class="mb-3 col-12 col-md-6">
                                                        <c:set var="errorPrice">
                                                            <form:errors path="price" cssClass="invalid-feedback" />
                                                        </c:set>

                                                        <label class="form-label" for="Price">Price</label>
                                                        <form:input
                                                            class="form-control form-control-lg ${not empty errorName ? 'is-invalid' : ''}"
                                                            id="Price" type="number" path="price" />
                                                        ${errorPrice}
                                                    </div>

                                                    <div class="mb-3 col-12">
                                                        <c:set var="errorDetailDesc">
                                                            <form:errors path="detailDesc"
                                                                cssClass="invalid-feedback" />
                                                        </c:set>
                                                        <label class="form-label" for="detailDesc">Detail
                                                            Description</label>
                                                        <form:textarea
                                                            class="form-control form-control-lg ${not empty errorName ? 'is-invalid' : ''}"
                                                            id="detailDesc" path="detailDesc" rows="2" />
                                                        ${errorDetailDesc}
                                                    </div>

                                                    <div class="mb-3 col-12 col-md-6">
                                                        <c:set var="errorShortDesc">
                                                            <form:errors path="shortDesc" cssClass="invalid-feedback" />
                                                        </c:set>
                                                        <label class="form-label" for="shortDesc">Short
                                                            Description</label>
                                                        <form:input
                                                            class="form-control form-control-lg ${not empty errorName ? 'is-invalid' : ''}"
                                                            id="shortDesc" type="text" path="shortDesc" />
                                                        ${errorShortDesc}
                                                    </div>

                                                    <div class="mb-3 col-12 col-md-6">
                                                        <c:set var="errorQuantity">
                                                            <form:errors path="quantity" cssClass="invalid-feedback" />
                                                        </c:set>
                                                        <label class="form-label" for="quantity">Quantity</label>
                                                        <form:input
                                                            class="form-control form-control-lg ${not empty errorName ? 'is-invalid' : ''}"
                                                            id="quantity" type="text" path="quantity" />
                                                        ${errorQuantity}
                                                    </div>

                                                    <div class="mb-3 col-12 col-md-6">
                                                        <label class="form-label" for="factory">Factory</label>
                                                        <form:select class="form-select form-select-lg" id="factory"
                                                            path="factory">
                                                            <form:option value="">-- Select Factory --</form:option>
                                                            <form:option value="MacBook">MacBook</form:option>
                                                            <form:option value="Microsoft">Microsoft</form:option>
                                                            <form:option value="Acer">Acer</form:option>
                                                            <form:option value="Asus">Asus</form:option>
                                                            <form:option value="HP">HP</form:option>
                                                            <form:option value="Lenovo">Lenovo</form:option>
                                                        </form:select>
                                                    </div>

                                                    <div class="mb-3 col-12 col-md-6">
                                                        <label class="form-label" for="target">Target</label>
                                                        <form:select class="form-select form-select-lg" id="target"
                                                            path="target">
                                                            <form:option value="">-- Select Target --</form:option>
                                                            <form:option value="Gaming">Gaming</form:option>
                                                            <form:option value="Van-Phong">Văn Phòng</form:option>
                                                            <form:option value="Hs-sv">Hs sv</form:option>
                                                        </form:select>
                                                    </div>

                                                    <div class="mb-3 col-12 col-md-6">
                                                        <label class="form-label" for="avatarFile">Product Image</label>
                                                        <input class="form-control form-control-lg" type="file"
                                                            id="product_img" accept=".jpg, .png, .jpeg"
                                                            name="product_img" />
                                                    </div>

                                                    <div class="mb-3 col-12 col-md-6">
                                                        <img style="max-height: 250px; display: none;"
                                                            alt="avatar preview" id="avatarPreview" />
                                                    </div>

                                                    <div class="mb-3 col-12 text-end">
                                                        <button class="btn btn-primary btn-lg"
                                                            type="submit">Submit</button>
                                                    </div>
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
                <script src="/js/scripts.js"></script>
            </body>

            </html>
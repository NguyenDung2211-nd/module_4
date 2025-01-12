<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 25/12/2024
  Time: 09:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Quản lý học sinh</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Trang chủ</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/student">Học sinh</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Giáo viên</a>
                </li>

            </ul>
            <form class="d-flex">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>
<div class="container">
    <button class="btn btn-primary m-4" onclick="window.location.href='/students/create'">Thêm mới</button>
    <table class="table table-hover">
        <thead>
            <tr>
                <th>STT</th>
                <th>Tên</th>
                <th>Địa chỉ</th>
                <th>Điểm</th>
                <th>Lớp</th>
                <th colspan="2">Chức năng</th>
            </tr>
        </thead>
        <tbody>
<%--        for(Student student: students)--%>
            <c:forEach items="${students}" var="student" varStatus="status">
                <tr>
                    <td>${status.count}</td>
                    <td>${student.name}</td>
                    <td>${student.getAddress()}</td>
                    <td>${student.getPoint()}</td>
                    <td>${student.getClassName()}</td>
                    <td><button class="btn btn-warning">Cập nhật</button></td>
                    <td><button class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#modalDelete${student.code}">Xóa</button></td>

                    <!-- Modal -->
                    <div class="modal fade" id="modalDelete${student.code}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">Xóa học sinh</h5>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                    <p>Bạn có muốn xóa học sinh có tên là ${student.name} và có code là ${student.code} hay không?</p>
                                    <small style="color: red; font-style: italic">Lưu ý: hành động này không thể hoàn tác!</small>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Hủy</button>
                                    <button type="button" class="btn btn-danger" data-bs-dismiss="modal" onclick="window.location.href='/students/${student.code}/delete'">Xác nhận</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </tr>
            </c:forEach>
        </tbody>
    </table>
  <c:if test="${message !=null}">
      <div class="toast" role="alert" aria-live="assertive" aria-atomic="true" style="opacity: 1" id="notification">
          <div class="toast-header">
              <strong class="me-auto">Thông báo</strong>
              <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"></button>
          </div>
          <div class="toast-body">
                  ${message}
          </div>
      </div>
  </c:if>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
<script>
    setTimeout(function () {
        document.getElementById("notification").classList.add("d-none")
    }, 3000)
</script>
</html>

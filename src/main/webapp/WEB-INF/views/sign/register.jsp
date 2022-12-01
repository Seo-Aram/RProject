<%--
  Created by IntelliJ IDEA.
  User: LG
  Date: 2022-11-28
  Time: 오후 5:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../parts/default-items.jsp"%>
<html>
    <head>
        <title>회원 가입</title>
    </head>
    <body>
    <section>
        <div class="container-sm py-5 h-100" style="min-width: 500px">
            <div class="bs-docs-section">
                <div class="row d-flex justify-content-center align-items-center h-100">
                    <div class="bs-component col-lg-8 col-xl-6">
                        <form method="post" id="signup">
                        <div class="card-body p-4 p-md-5">
                            <h1 class="h3 mb-3 fw-normal"> 회원 가입 </h1>
                            <div class="form-group">
                                <label class="form-label mt-4">Email</label>
                                <div class="form-group">
                                    <div class="input-group mb-3">
                                        <span class="input-group-text">Email 입력</span>
                                        <input type="email" name="userID" id="userId" class="form-control" aria-label="Input Id" placeholder="example@mail.com">
                                    </div>
                                    <p class="text-muted text-sm-start small">ID는 Email로 사용합니다.</p>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="form-label mt-4">비밀번호</label>
                                <div class="form-group">
                                    <div class="input-group mb-3">
                                        <span class="input-group-text">비밀번호 입력</span>
                                        <input type="password" name="userPw" id="userPw" class="form-control" aria-label="" placeholder="">
                                    </div>
                                    <div class="input-group mb-3">
                                        <span class="input-group-text">비밀번호 확인</span>
                                        <input type="password" name="checkPw" id="checkPw" class="form-control" aria-label="" placeholder="비밀번호를 다시 입력하세요">
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="form-label mt-4">이름</label>
                                <div class="form-group">
                                    <div class="input-group mb-3">
                                        <input type="text" name="userName" id="userName" class="form-control" aria-label="" placeholder="">
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="form-label mt-4">전화번호</label>
                                <div class="form-group">
                                    <div class="input-group mb-3">
                                        <select name="nation" id="nation" class="form-select"></select>
                                    </div>
                                    <div class="input-group mb-3">
                                        <div class="w-100">
                                            <input type="text" name="phoneNum" id="phoneNum" class="form-control" placeholder="전화번호 입력">
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="form-label mt-4">생년월일</label>
                                <div class="form-group">
                                    <div class="input-group">
                                        <div class="col-md-3">
                                            <input type="text" name="bYear" id="bYear" class="form-control" placeholder="년(4자)">
                                        </div>
                                        <div class="col-sm-1"style="width: 12.5%">
                                            <p class="text-muted text-sm-center"> / </p>
                                        </div>
                                        <div class="col-md-3">
                                            <select name="bMonth" id="bMonth" class="form-select"></select>
                                        </div>
                                        <div class="col-sm-1" style="width: 12.5%">
                                            <p class="text-muted text-sm-center"> / </p>
                                        </div>
                                        <div class="col-md-3">
                                            <input type="text" name="bDay" id="bDay" class="form-control" placeholder="일">
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="form-group" style="margin-top:25px;">
                                <div class="input-group mb-3">
                                    <div class="col-1"></div>
                                    <div class="col-4">
                                        <input type="button" name="submit" id="submit" class="btn btn-lg btn-primary" style="width:100%"  value="회원가입">
                                    </div>
                                    <di class="col-1"></di>
                                    <div class="col-4">
                                        <input type="button" name="cancel" id="cancel" class="btn btn-lg btn-secondary" style="width:100%" value=" 취소 ">
                                    </div>
                                </div>
                            </div>
                        </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </section>
    </body>
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
    <script src="/resources/cvs/nationCode.js"></script>
    <script>
        document.addEventListener('DOMContentLoaded', () => {
            const bMonth = document.querySelector('#bMonth');
            let opt = '<option> 월 </option>';
            for(let i = 1; i <= 12; ++i) {
                opt += '<option value="' + i + '">' + i + '</option>';
            }
            bMonth.innerHTML = opt;

            const nation = document.querySelector('#nation');
            opt = '';
            for(let i = 0; i < nationCode.length; ++i) {
                let selected = nationCode[i].Code2=='KR'?'selected':'';
                opt += '<option value="' + nationCode[i].Code2 + '"' + selected + '>'
                    + '(' + nationCode[i].Pnum + '+) '
                    + nationCode[i].KName
                    + ' / '
                    + nationCode[i].Ename
                    + '</option>';
            }
            nation.innerHTML = opt;
        });

        document.querySelector('#submit').addEventListener('click', (event) =>{

            // submit 처리
        });

        /*axios.get('/api/v1/depts/10')
            .then(res => {
                console.log('res', res.data)
                // 태그 캐스팅 -> 데이터 변경
                // 태그 캐스팅 -> 데이터 변경
            })
            .catch(err => console.log(err))
        axios.post('/api/v1/depts',{ "deptno": 35, "dname": "DEV123", "loc": "판교123" })
            .then(res => console.log(res))
            .catch(err => console.log(err))*/
    </script>

</html>

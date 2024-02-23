<%--
  Created by IntelliJ IDEA.
  User: System 11
  Date: 22-02-2024
  Time: 18:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="basehtml.jsp"%>

<span>Add Employee</span>
<hr>
<div class="whitcont">
    <div class="whiteleftside">
        menu
    </div>
    <div class="whiterightside">
        <span class="contlabel"> Employee</span>
        <form class="row g-3 addemployee mt10">
            <div class="col-md-1">
                <label for="inputEmail4" class="form-label">Employee</label>
                <input type="text" class="form-control bg-white rounded-3" value="STTL" id="inputEmail4" disabled>
            </div>
            <div class="col-md-3">
                <label for="code" class="form-label">code</label>
                <input type="text" class="form-control bg-white" value="{value}" disabled id="code">
            </div>
            <div class="col-md-4">
                <label for="inputPassword4" class="form-label">Password</label>
                <input type="password" class="form-control bg-white" id="inputPassword4">
            </div>
            <div class="col-md-4">
                <label for="inputAddress" class="form-label">Address</label>
                <input type="text" class="form-control bg-white" id="inputAddress" placeholder="1234 Main St">
            </div>
            <div class="col-12">
                <label for="inputAddress2" class="form-label">Address 2</label>
                <input type="text" class="form-control bg-white" id="inputAddress2" placeholder="Apartment, studio, or floor">
            </div>
            <div class="col-md-6">
                <label for="inputCity" class="form-label">City</label>
                <input type="text" class="form-control bg-white" id="inputCity">
            </div>
            <div class="col-md-4">
                <label for="inputState" class="form-label">State</label>
                <select id="inputState" class="form-select">
                    <option selected>Choose...</option>
                    <option>...</option>
                </select>
            </div>
            <div class="col-md-2">
                <label for="inputZip" class="form-label">Zip</label>
                <input type="text" class="form-control bg-white" id="inputZip">
            </div>
            <div class="col-12">
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" id="gridCheck">
                    <label class="form-check-label" for="gridCheck">
                        Check me out
                    </label>
                </div>
            </div>
            <div class="col-12">
                <button type="submit" class="btn btn-primary">Sign in</button>
            </div>
        </form>
    </div>
</div>
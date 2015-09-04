<%@page import="doituong.DichVu"%>
<%@page import="doituong.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

    <div id="content-right"  class="content">

    	
    	<form action="do-edit-dich-vu" method="POST" role="form">
   	
            <legend>Edit dich vu</legend>

            <div class="form-group">
                <label for="">ID</label>
                <input type="text" class="form-control" name="id" value="" placeholder="Input field">
            </div>

            <div class="form-group">
                <label for="">Ten dich vu</label>
                <input type="text" class="form-control" name="tenDichVu" value="" placeholder="Input field">
            </div>

            <div class="form-group">
                <label for="">Gia dich vu</label>
                <input type="text" class="form-control" name="giaDichVu" value="" placeholder="Input field">
            </div>

            <div class="form-group">
                <label for="">Mo ta</label>
                <input type="text" class="form-control" name="moTa" value="" placeholder="Input field">
            </div>

            <button type="submit" class="btn btn-primary">Accept</button>
        </form>
            
    </div>
    
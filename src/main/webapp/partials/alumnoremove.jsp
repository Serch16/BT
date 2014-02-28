<%-- 
    Document   : ofertaremove
    Created on : Feb 16, 2014, 11:42:41 AM
    Author     : rafa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="row-fluid">
    <div class="span6 offset3">   
        <div class="row-fluid">
            <h2>Borrado de Oferta</h2>
        </div>        
        <table class="table table-striped table-condensed">
            <thead>                
                <tr>    
                    <th>campo</th>
                    <th>valor</th>
                </tr>
            </thead>
            <tbody>
                <tr><td>id</td><td>{{objeto.id}}</td></tr>
                <tr><td>nombre</td><td>{{objeto.nombre}}</td>
                <tr><td>primer apellido</td><td>{{objeto.ape1}}</td>
                <tr><td>segundo apellido</td><td>{{objeto.ape2}}</td>
                <tr><td>email</td><td>{{objeto.email}}</td>                
            </tbody>
        </table> 
        <div>¿Está seguro de que desea borrar el oferta con id={{objeto.id}}?</div>
        <div class="text-right" > 
            <a class="btn" ng-click="remove()">SÍ</a>
            <a class="btn" ng-click="back()">NO</a>
        </div>
        <div><span class="alert alert-success">{{result.status}} {{result.message}}</span></div>
    </div>
</div>
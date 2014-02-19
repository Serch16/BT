<%-- 
    Document   : ofertaedit
    Created on : Feb 16, 2014, 11:11:03 AM
    Author     : rafa
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<form class="form-horizontal" action="#" id="formulario" name="formulario">
    <h2>Oferta</h2>
    <div class="control-group">
        <label class="control-label" for="inputId">Id:</label>
        <div class="controls">
            <input type="text" id="id" ng-model="objeto.id" name="id" placeholder="id" />
        </div>
    </div>
    <div class="control-group">
        <label class="control-label"  for="inputNombre">Nombre:</label>
        <div class="controls">
            <input type="text" id="nombre" ng-model="objeto.nombre" name="nombre" size="15" placeholder="nombre" />
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputApe1" >Primer apellido:</label>
        <div class="controls">
            <input type="text" id="ape1" ng-model="objeto.ape1" name="ape1" placeholder="primer apellido" size="15" />
        </div>
    </div>
    <div class="control-group">
        <label class="control-label"  for="inputApe2">Segundo apellido:</label>
        <div class="controls">
            <input type="text" id="ape2" ng-model="objeto.ape2" name="ape2" placeholder="segundo apellido" size="15" />
        </div>
    </div>
    <div class="control-group">
        <label class="control-label"  for="inputEmail">Email:</label>
        <div class="controls">
            <input type="text" id="email" ng-model="objeto.email" name="email" placeholder="email" size="15" />
        </div>
    </div>
    <div class="control-group">
        <div class="controls">
            <a class="btn" ng-click="save()">Guardar</a>
            <a class="btn" ng-click="back()">Volver</a>
        </div>
    </div>
<div><span class="alert alert-success">{{result.status}} {{result.message}}</span></div>
</form>

<%-- 
    Document   : productoedit
    Created on : Feb 13, 2014, 7:04:09 PM
    Author     : rafa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<form class="form-horizontal" action="#" id="formulario" name="formulario">
    <fieldset>
        <div class="control-group">
            <label class="control-label" for="id">Id: </label>
            <div class="controls">
                <input id="id" ng-model="objeto.id" name="id" type="text" size="30" maxlength="50" />
            </div>
        </div>        
        <div class="control-group">
            <label class="control-label" for="codigo">Código: </label>
            <div class="controls">
                <input id="codigo" ng-model="objeto.codigo" name="codigo" type="text" size="30" maxlength="50" />
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="descripcion">Descripción: </label> 
            <div class="controls">
                <input id="descripcion"  ng-model="objeto.descripcion"  name="descripcion" type="text" size="30" maxlength="50" />
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="precio">Precio: </label> 
            <div class="controls">
                <input id="precio"  ng-model="objeto.precio"  name="precio" type="text" size="30" maxlength="50" /> 
            </div>
        </div>           
        <div class="control-group">
            <label class="control-label" for="id_tipoproducto">Tipo de producto: </label> 
            <div class="controls"> 
                <!-- <span id="id_tipoproducto" class="alert alert-info"></span> -->
                <input readonly="true"  ng-model="objeto.id_tipoproducto" id="id_tipoproducto" class="input-mini"
                       name="id_tipoproducto" type="text" size="5" maxlength="5" />  
                <a class="btn btn-mini" id="id_tipoproducto_button"  ng-click="go('tipoproducto')"><i class="icon-search"></i></a>
            </div>
        </div>
        <div class="control-group">
            <div class="controls">
                <span id="id_tipoproducto_desc"  class="alert alert-success">{{id_tipoproducto_desc}}</span>     

            </div>
        </div>             
        <div class="control-group">
            <div class="controls">
                <button type="submit" id="submitForm" class="btn submitForm">Submit</button>
                <a class="btn" ng-click="back()">Volver</a>
            </div>
        </div>
    </fieldset>

</form>

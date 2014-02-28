<%-- 
    Document   : alumnoedit
    Created on : Feb 28, 2014, 12:08:03 AM
    Author     : Sergio Martín Tárraga
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="container back">
    <div class="masthead">
        <div class="navbar">
            <div class="navbar-inner">
                <div class="container">
                    <ul class="nav">
                        <li><a href="#inicio"><span><i class="icon-home"></i></span> Inicio</a></li>
                        <li><a href="#oferta/list/1/10">Ofertas de trabajo</a></li>
                        <li><a href="#tipoproducto/list/1/10">Empleo público</a></li>
                    </ul>
                    <ul class="nav pull-right">
                        <li class="active"><a href="#alumno/edit/1">Mi Perfil</a></li>
                    </ul>
                </div>
            </div>
        </div><!-- /.navbar -->
    </div>
</div>
<div class="container back">
    <div class="row-fluid">
        <div class="span12">
            <ul class="breadcrumb">
                Estás en:
                <li><a href="#oferta/list/1/10">Perfil</a> <span class="divider">/</span></li>
                <li class="active">Edición de mi perfil</li>
            </ul>
        </div>
    </div>
    <div class="row-fluid">
        <div class="span12">
            <h2>Mi perfil</h2>
        </div>
    </div>
    <div class="row-fluid">
        <div class="span6">
            <form class="form-horizontal" action="#" id="formulario" name="formulario">
                <div class="control-group">
                    <label class="control-label"  for="inputNombre">Nombre:</label>
                    <div class="controls">
                        <input type="text" id="nombre" ng-model="objeto.nombre" name="nombre" size="15" placeholder="nombre" />
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label" for="inputApellido1" >Primer apellido:</label>
                    <div class="controls">
                        <input type="text" id="apellido1" ng-model="objeto.apellido1" name="apellido1" placeholder="primer apellido" size="15" />
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label"  for="inputApellido2">Segundo apellido:</label>
                    <div class="controls">
                        <input type="text" id="apellido2" ng-model="objeto.apellido2" name="apellido2" placeholder="segundo apellido" size="15" />
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label"  for="inputNifnie">NIF/NIE:</label>
                    <div class="controls">
                        <input type="text" id="nifnie" ng-model="objeto.nifnie" name="nifnie" placeholder="NIF o NIE" size="15" />
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label"  for="inputDomicilio">Domicilio:</label>
                    <div class="controls">
                        <input type="text" id="domicilio" ng-model="objeto.domicilio" name="domicilio" placeholder="Dirección" size="15" />
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label"  for="inputCpostal">Código Postal:</label>
                    <div class="controls">
                        <input type="text" id="cpostal" ng-model="objeto.cpostal" name="cpostal" placeholder="Código postal" size="15" />
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label"  for="inputLocalidad">Localidad:</label>
                    <div class="controls">
                        <input type="text" id="localidad" ng-model="objeto.localidad" name="localidad" placeholder="Localidad" size="15" />
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label"  for="inputProvincia">Provincia:</label>
                    <div class="controls">
                        <select>
                            <option ng-repeat="pro in provincias">{{pro.nombrepro}}</option>
                        </select>
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
        </div>
        <div class="span6">
            <form class="form-horizontal" action="#" id="formulario" name="formulario">
                <div class="control-group">
                    <label class="control-label"  for="inputEmail">Email:</label>
                    <div class="controls">
                        <input type="text" id="email" ng-model="objeto.email" name="email" placeholder="Em@il" size="15" />
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label"  for="inputPassword">Password:</label>
                    <div class="controls">
                        <input type="text" id="password" ng-model="objeto.password" name="password" placeholder="Password" size="15" />
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
